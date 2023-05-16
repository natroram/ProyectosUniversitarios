USE G1_PROYECTO;

DELIMITER |
CREATE PROCEDURE `ConsultaMedicinaxCodigo`(in in_codigo varchar(10))
BEGIN
	SELECT	CODIGO,
			IFNULL(REG_SANITARIO,'') REGSANIT,
			NOMBRE,
			DESCRIPCION
    FROM  	medicina
    WHERE 	CODIGO = in_codigo;
END;
| DELIMITER ;

DELIMITER |
CREATE PROCEDURE `ConsultaBodegas`()
BEGIN
	SELECT	Id_Bodega,
			e.DESCRIPCION,
            b.DIRECCION
    FROM 	bodega b
			INNER JOIN edificio_empresa e ON b.COD_EDIFICIO = e.COD_EDIFICIO;
END;
| DELIMITER ;

DELIMITER |
CREATE PROCEDURE `ConsultaEmpleados`()
BEGIN
	SELECT	emp.Id_empleado id,
			emp.CEDULA,
			p.NOMBRE,
            CONCAT(p.APELLIDO_PATERNO,' ',p.APELLIDO_MATERNO) AS APELLIDO
    FROM 	empleado emp
			INNER JOIN persona p ON emp.CEDULA = p.CEDULA;
END;
| DELIMITER ;

DELIMITER |
CREATE DEFINER=`root`@`localhost` PROCEDURE `GuardarNotaIngEgr`(IN in_tipoNota int,IN in_bodega VARCHAR(10), IN in_bodeguero VARCHAR(10),
	IN in_solicitante CHAR(10),IN in_fechaMov CHAR(10), IN in_fechaSolic CHAR(10), IN in_numero CHAR(10),IN in_justificativo VARCHAR(50),IN in_detalle VARCHAR(500),
    OUT mensajeOut VARCHAR(300))
BEGIN
	DECLARE cadena_total text;
    DECLARE cadena_parcial text;
    DECLARE aparicion int;
    DECLARE aparicion1 int;
    
    DECLARE stockAnterior int;
    DECLARE idNota INT;
    DECLARE codigoArt varchar(30);
    DECLARE denominacionArt varchar(200);
    DECLARE idCaducidad int;
    DECLARE nolote varchar(10);
    DECLARE fechaCaducidad char(10);
    DECLARE cantidad INT;
    DECLARE cantidadMax INT;
    DECLARE cantidadMin INT;
    DECLARE idKardexTemp INT;
    DECLARE detalle VARCHAR(200);
    
    DECLARE sin_stock CONDITION FOR SQLSTATE '45000';
    DECLARE falla_stockMin CONDITION FOR SQLSTATE '45001';
    DECLARE falla_stockMax CONDITION FOR SQLSTATE '45002';
    
    DECLARE EXIT HANDLER FOR sin_stock
    BEGIN
		SET mensajeOut = CONCAT('Error: El artículo ',codigoArt,' no tiene suficiente stock para despachar.');
        ROLLBACK;
    END;
    
    DECLARE EXIT HANDLER FOR falla_stockMin
    BEGIN
		SET mensajeOut = CONCAT('Error: El artículo ',codigoArt,' no cumple con la cantidad minima.');
        ROLLBACK;
    END;
    
    DECLARE EXIT HANDLER FOR falla_stockMax
    BEGIN
		SET mensajeOut = CONCAT('Error: El artículo ',codigoArt,' no cumple con la cantidad máxima.');
        ROLLBACK;
    END;
    
     DECLARE EXIT HANDLER FOR 1062 BEGIN
		SET mensajeOut = CONCAT('Error: El número de la Nota ya se encuentra registrada, intente con otro numero.');
        ROLLBACK;
	END;
    
    SET mensajeOut = '1';
    START TRANSACTION;
    
    IF(in_tipoNota=1)THEN
		INSERT INTO nota_ingreso(NUM_INGRESO,FECHA_SOLICITUD,FECHA_INGRESO,
			BODEGA,BODEGUERO,SOLICITANTE,JUSTIFICATIVO)
		VALUES(in_numero,in_fechaSolic,in_fechaMov,in_bodega,in_bodeguero,
			in_solicitante,in_justificativo);
	ELSE
		INSERT INTO nota_egreso(NUM_EGRESO,FECHA_SOLICITUD,FECHA_EGRESO,
			BODEGA,BODEGUERO,SOLICITANTE,DESTINO)
		VALUES(in_numero,in_fechaSolic,in_fechaMov,in_bodega,in_bodeguero,
			in_solicitante,in_justificativo);
    END IF;
    
    SET cadena_total = in_detalle;
	SET aparicion = LOCATE('@#',cadena_total);

	WHILE (aparicion<>0) DO
        SET cadena_parcial = SUBSTRING(cadena_total,1,aparicion-1);
		SET aparicion1 = LOCATE('|$',cadena_parcial);            
		SET codigoArt = SUBSTRING(cadena_parcial,1, aparicion1-1);
        
        SET cadena_parcial = SUBSTRING(cadena_parcial, aparicion1+2);
		SET aparicion1 = LOCATE('|$',cadena_parcial);  
		SET denominacionArt = SUBSTRING(cadena_parcial,1, aparicion1-1);
        
        SET cadena_parcial = SUBSTRING(cadena_parcial, aparicion1+2);
		SET aparicion1 = LOCATE('|$',cadena_parcial);  
		SET cantidad = SUBSTRING(cadena_parcial,1, aparicion1-1);
        
        SET cadena_parcial = SUBSTRING(cadena_parcial, aparicion1+2);
		SET aparicion1 = LOCATE('|$',cadena_parcial);  
		SET nolote = SUBSTRING(cadena_parcial,1, aparicion1-1);
        
        SET fechaCaducidad = SUBSTRING(cadena_parcial, aparicion1+2);
        
        SET idCaducidad = NULL;
        SELECT 	ID_CADUCIDAD
				INTO idCaducidad
        FROM 	caducidad_medicina
        WHERE 	COD_MEDICINA = codigoArt
				AND NUM_LOTE = nolote;
        
        IF(idCaducidad IS NULL) THEN
			INSERT INTO CADUCIDAD_MEDICINA(NUM_LOTE,FECHA_CADUCIDAD,COD_MEDICINA)
            VALUES(nolote,fechaCaducidad,codigoArt);
            SET idCaducidad = last_insert_id();
        END IF;
        
        SET idKardexTemp = NULL;
        IF(in_tipoNota = 1)THEN
			INSERT INTO nota_ingreso_item(NUM_INGRESO,COD_MEDICINA,ID_CADUCIDAD,CANTIDAD)
            VALUES(in_numero,codigoArt,idCaducidad,cantidad);
            
            SELECT 	ID_KARDEX,
					CANTIDAD_MAX,
					STOCK
					INTO idKardexTemp,cantidadMax,stockAnterior
			FROM 	kardex
			WHERE 	COD_MEDICINA = codigoArt
					AND ID_BODEGA = in_bodega;
                    
			IF(idKardexTemp IS NULL)THEN
				INSERT INTO kardex(COD_MEDICINA,ID_BODEGA,CANTIDAD_MAX,CANTIDAD_MIN,STOCK)
                VALUES(codigoArt,in_bodega,0,0,0);
			ELSE
				IF((stockAnterior+cantidad)<cantidadMax AND cantidadMax>0)THEN
					SIGNAL falla_stockMax;
				END IF;
            END IF;
            
            SET detalle = CONCAT('Por Nota Ingreso #',in_numero);
            INSERT INTO kardex_movimiento(ID_KARDEX_ID_CADUCIDAD,TIPO_MOVIMIENTO,
				DESCRIPCION,CANTIDAD)
			VALUES(idKardexTemp,idCaducidad,'I',detalle,cantidad);
            
            UPDATE 	kardex
            SET 	STOCK = STOCK + cantidad
            WHERE 	ID_KARDEX = idKardexTemp;
		ELSE 
			SELECT 	ID_KARDEX,
					CANTIDAD_MIN,
					STOCK
					INTO idKardexTemp,cantidadMin,stockAnterior
			FROM 	kardex
			WHERE 	COD_MEDICINA = codigoArt
					AND ID_BODEGA = in_bodega;
                        
			IF(cantidad>stockAnterior)THEN
				SIGNAL sin_stock;
            END IF;
            IF((stockAnterior-cantidad)<cantidadMin AND cantidadMin>0)THEN
				SIGNAL falla_stockMin;
            END IF;
        
			INSERT INTO nota_egreso_item(NUM_EGRESO,COD_MEDICINA,ID_CADUCIDAD,CANTIDAD)
            VALUES(in_numero,codigoArt,idCaducidad,cantidad);
            
            SET detalle = CONCAT('Por Nota Egreso #',in_numero);
            INSERT INTO kardex_movimiento(ID_KARDEX_ID_CADUCIDAD,TIPO_MOVIMIENTO,
				DESCRIPCION,CANTIDAD)
			VALUES(idKardexTemp,idCaducidad,'E',detalle,cantidad);
            
            UPDATE 	kardex
            SET 	STOCK = STOCK - cantidad
            WHERE 	ID_KARDEX = idKardexTemp;
        END IF;
        
        SET cadena_total = SUBSTRING(cadena_total,aparicion+2);
		SET aparicion = LOCATE('@#',cadena_total);
    END WHILE;
    
    COMMIT;
END;
| DELIMITER ;