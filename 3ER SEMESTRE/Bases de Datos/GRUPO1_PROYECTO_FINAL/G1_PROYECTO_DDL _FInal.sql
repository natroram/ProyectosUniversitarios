/*
Proyecto BD Grupo1 Paralelo4
Integrantes:	Darwin Borja
				Maria Mora
				Natalia Ramirez
				Gabriel Villanueva
*/

#Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS G1_PROYECTO;

#Seteado de la base de datos como la base de datos por defecto
USE G1_PROYECTO;

drop view if exists reporte_ingresos_bodega;
drop view if exists reporte_egresos_bodega;
drop view if exists reporte_compras_clientes_categoria;
drop procedure if exists crear_venta;

#Eliminación de Tablas si existen con anterioridad para evitar errores
SET FOREIGN_KEY_CHECKS = 0; #Sentencia que ignora las claves foráneas al eliminar las tablas
DROP TABLE IF EXISTS FACTURA_ITEM, FACTURA, CLIENTE; 
DROP TABLE IF EXISTS EMAIL_EMPLEADO, TEL_EMPLEADO, DIR_EMPLEADO, EMPLEADO, CARGO_EMPLEADO;
DROP TABLE IF EXISTS BODEGA, NOTA_EGRESO, NOTA_EGRESO_ITEM, NOTA_INGRESO, NOTA_INGRESO_ITEM;
DROP TABLE IF EXISTS FARMACIA, CANTON, PROVINCIA;
DROP TABLE IF EXISTS MEDICINA, CADUCIDAD_MEDICINA, CATEGORIA_MEDICINA;
DROP TABLE IF EXISTS KARDEX, KARDEX_MOVIMIENTO;
DROP TABLE IF EXISTS PERSONA, EDIFICIO_EMPRESA;
SET FOREIGN_KEY_CHECKS = 1; #Sentencia que setea el check en claves foráneas de las tablas

#Creación de Tabla PERSONA
CREATE TABLE IF NOT EXISTS PERSONA(
CEDULA				VARCHAR(10)		PRIMARY KEY		COMMENT 'Número único otorgado a cada ciudadano de un país en específico',
NOMBRE				VARCHAR(50)		NOT NULL		COMMENT 'Nombre/s oficial de la persona',
APELLIDO_MATERNO	VARCHAR(20)		NOT NULL		COMMENT 'Apellido paterno oficial de la persona',
APELLIDO_PATERNO	VARCHAR(20)		NOT NULL		COMMENT 'Apellido materno oficial de la persona'
);

/*
La siguiente tabla se crea debido a que en el Diseño lógico se había decidido que una clase foránea de empleado
referenicara a dos diferentes tablas. (Empleado) FK Lugar_Trabajo podía ser ID_Farmacia o ID_Bodega.
SQL no soporta este tipo de constraints, UNA CLAVE FORÁNEA DEBE REFERENCIAR A UNA SOLA TABLA OBJETIVO

Soulción:
Creación de una tabla supertipo para Farmacia y Bodega que Empleado pueda referenciar únicamente como su clave foránea.
*/
#Creación de la Tabla EDIFICIO_EMPRESA.
CREATE TABLE IF NOT EXISTS EDIFICIO_EMPRESA(
COD_EDIFICIO		VARCHAR(10)		PRIMARY KEY		COMMENT 'Código que identifica en general a un edificio de la empresa',
DESCRIPCION			VARCHAR(50)		NOT NULL		COMMENT 'Descripción general del edificio'
);

#Creación de la taba PROVINCIA
CREATE TABLE IF NOT EXISTS PROVINCIA(
ID_PROVINCIA	INT				PRIMARY KEY				COMMENT 'Código único para representar a una provincia del país',
NOMBRE			VARCHAR(30)		NOT NULL	UNIQUE		COMMENT 'Nombre completo de la provincia',
CONSTRAINT ID_PROV_POSITIVO CHECK (ID_PROVINCIA > 0)	#Restricción entero positivo
);

#Creación de la tabla CANTON
CREATE TABLE IF NOT EXISTS CANTON(
ID_CANTON		INT				PRIMARY KEY				COMMENT 'Código único para representar a un cantón del país',
NOMBRE			VARCHAR(30)		NOT NULL		UNIQUE	COMMENT 'Nombre completo del cantón según su ID',
ID_PROVINCIA	INT										COMMENT 'Código único para representar a una provincia del país',
CONSTRAINT ID_CANTON_POSITIVO CHECK (ID_CANTON > 0),	#Restricción entero positivo
CONSTRAINT FK_PROVINCIA FOREIGN KEY (ID_PROVINCIA) REFERENCES PROVINCIA (ID_PROVINCIA) ON UPDATE CASCADE	#Referencia clave foránea
);

#Creación de tabla FARMACIA
CREATE TABLE IF NOT EXISTS FARMACIA(
CODIGO				VARCHAR(10)		PRIMARY KEY		COMMENT 'Código único para representar a cada farmacia que forma parte de la empresa',
NOMBRE              VARCHAR(50)     NOT NULL        COMMENT 'Nombre de la Farmacia',
CALLE_PRINCIPAL		VARCHAR(50)		         		COMMENT 'Detalles de la calle primaria en donde se encuentra ubicada la farmacia',
CALLE_SECUNDARIA	VARCHAR(50)		         		COMMENT 'Detalles de la calle secundaria en donde se encuentra ubicada la farmacia',
LATITUD				DECIMAL(10,8)	        		COMMENT 'Dirección angular que mide desde un punto de la tierra hacia la linea ecuatorial',
LONGITUD			DECIMAL(11,8)	         		COMMENT 'Localización de un lugar  (Este y Oeste)',
REFERENCIA			VARCHAR(100)	        		COMMENT 'Breve detalle de un lugar cercano a la farmacia analizada',
ID_CANTON			INT				NOT NULL		COMMENT 'Código único para representar a un cantón del país',
ID_JEFE				VARCHAR(10)		NOT NULL	    COMMENT 'Código único otorgado a cada jefe de cada farmacia que esta a su cargo',
COD_EDIFICIO		VARCHAR(10)						COMMENT 'Clave foránea proveniente de la tabla EDIFICIO_EMPRESA',
CONSTRAINT FK_CANTON FOREIGN KEY (ID_CANTON) REFERENCES CANTON (ID_CANTON) ON UPDATE CASCADE,	#Referencia clave foránea
CONSTRAINT FK_FARM_EDIF FOREIGN KEY (COD_EDIFICIO) REFERENCES EDIFICIO_EMPRESA (COD_EDIFICIO) ON UPDATE CASCADE #Referencia clave foránea
);

#Creación de tabla BODEGA
CREATE TABLE IF NOT EXISTS BODEGA(
ID_BODEGA		VARCHAR(10)		PRIMARY KEY		COMMENT 'Código único para cada bodega enlistada en la empresa',
DIRECCION		VARCHAR(50)		NOT NULL		COMMENT 'Dirección en donde se encuentra ubicada la bodega de la empresa', -- Cambio
COD_EDIFICIO	VARCHAR(10)						COMMENT 'Clave foránea proveniente de la tabla EDIFICIO_EMPRESA',
CONSTRAINT FK_BOD_EDIF FOREIGN KEY (COD_EDIFICIO) REFERENCES EDIFICIO_EMPRESA (COD_EDIFICIO) ON UPDATE CASCADE #Referencia clave foránea
);

#Creación de tabla CARGO_EMPLEADO
CREATE TABLE IF NOT EXISTS CARGO_EMPLEADO(
ID_CARGO			INT				PRIMARY KEY				COMMENT 'Entero que relaciona el nombre del cargo del empleado',
NOMBRE				VARCHAR(30)		NOT NULL		UNIQUE	COMMENT 'Nombre del cargo del empleado',
CONSTRAINT ID_CARGO_POSITIVO CHECK (ID_CARGO > 0)	#Restricción entero positivo
);

#Creación de tabla EMPLEADO
CREATE TABLE IF NOT EXISTS EMPLEADO(
ID_EMPLEADO			VARCHAR(10)			PRIMARY KEY		COMMENT 'Código único otorgado a las personas que trabajan en la empresa, independiente del cargo',
SUELDO				DECIMAL(7,2)		NOT NULL		COMMENT 'Decimal que indica la cantidad por remuneración que se le paga al empleado',
FECHA_INGRESO		DATE				NOT NULL		COMMENT 'Fecha que indica el ingreso del empleado a la empresa',
CEDULA				VARCHAR(10)							COMMENT 'Clave foránea proveniente de Persona',
ID_CARGO			INT									COMMENT 'Clave foránea proveniente de Cargo',
ID_SUPERVISOR		VARCHAR(10)							COMMENT 'Clave por recursividad que indica cúal empleado supervisa a este',
ID_LUGAR_TRABAJO	VARCHAR(10)							COMMENT 'Código que identifica el lugar donde trabaja el empleado',
CONSTRAINT FK_PERSONA FOREIGN KEY (CEDULA) REFERENCES PERSONA (CEDULA) ON UPDATE CASCADE,	#Referencia clave foránea
CONSTRAINT FK_CARGO FOREIGN KEY (ID_CARGO) REFERENCES CARGO_EMPLEADO (ID_CARGO) ON UPDATE CASCADE,	#Referencia clave foránea
CONSTRAINT FK_LUGTRAB_EDIF FOREIGN KEY (ID_LUGAR_TRABAJO) REFERENCES EDIFICIO_EMPRESA (COD_EDIFICIO) ON UPDATE CASCADE, #Referencia clave foránea
CONSTRAINT FK_SUPERVISOR_RECURSIVIDAD FOREIGN KEY (ID_SUPERVISOR) REFERENCES EMPLEADO(ID_EMPLEADO) ON UPDATE CASCADE,	#Referencia clave foránea de si mismo
CONSTRAINT SUELDO_POSITIVO CHECK (SUELDO >= 0) #Restricción decimal positivo
);

#Agregación de constrain de clave foránea Empleado en FARMACIA
ALTER TABLE FARMACIA ADD CONSTRAINT FK_EMPLEADO FOREIGN KEY (ID_JEFE) REFERENCES EMPLEADO(ID_EMPLEADO);

#Creación de la tabla DIR_EMPLEADO
CREATE TABLE IF NOT EXISTS DIR_EMPLEADO(
COD_DIR_EMPL	VARCHAR(10)		PRIMARY KEY		COMMENT 'Clave artificial que identifica una dirección del empleado',
DIRECCION		VARCHAR(50)		NOT NULL		COMMENT 'Dirección del Empleado',
ID_EMPLEADO		VARCHAR(10)						COMMENT 'Clave foránea proveniente de Empleado que identifica a un Empleado',
CONSTRAINT FK_DIR_EMPLEADO FOREIGN KEY (ID_EMPLEADO) REFERENCES EMPLEADO(ID_EMPLEADO) ON UPDATE CASCADE
);

#Creación de la tabla TEL_EMPLEADO
CREATE TABLE IF NOT EXISTS TEL_EMPLEADO(
COD_TEL_EMPL	VARCHAR(10)		PRIMARY KEY		COMMENT 'Clave artificial que identifica un número del empleado',
TELEFONO		INT				NOT NULL		COMMENT 'Teléfono del Empleado',
ID_EMPLEADO		VARCHAR(10)						COMMENT 'Clave foránea proveniente de Empleado que identifica a un Empleado',
CONSTRAINT FK_TEL_EMPLEADO FOREIGN KEY (ID_EMPLEADO) REFERENCES EMPLEADO (ID_EMPLEADO) ON UPDATE CASCADE,
CONSTRAINT TEL_POSITIVO CHECK (TELEFONO > 0) #Restricción entero positivo
);

#Creación de la tabla EMAIL_EMPLEADO
CREATE TABLE IF NOT EXISTS EMAIL_EMPLEADO(
COD_EMAIL_EMPL	VARCHAR(10)		PRIMARY KEY		COMMENT 'Clave artificial que identifica un email del empleado',
EMAIL			VARCHAR(30)		NOT NULL		COMMENT 'Email del Empleado', -- Cambio
ID_EMPLEADO		VARCHAR(10)		COMMENT 'Clave foránea proveniente de Empleado que identifica a un Empleado', -- Cambio
CONSTRAINT FK_EMAIL_EMPLEADO FOREIGN KEY (ID_EMPLEADO) REFERENCES EMPLEADO(ID_EMPLEADO) ON UPDATE CASCADE
);

#Creación de la tabla CLIENTE
CREATE TABLE IF NOT EXISTS CLIENTE(
DIRECCION 	VARCHAR(50)		NOT NULL	COMMENT 'Dirección en donde se encuentra ubicada la casa del cliente',
TELEFONO	INT 			NOT NULL	COMMENT 'Número telefonico en donde puede ser contactado el usuario',
EMAIL		VARCHAR(30)	 	COMMENT 'Direccion de correo electrónico en donde el cliente puede ser contactado', -- CAMBIO
CEDULA		VARCHAR(10) 	NOT NULL	COMMENT 'Clave foránea de la tabla persona',
CONSTRAINT FK_CL_PERSONA FOREIGN KEY (CEDULA) REFERENCES PERSONA(CEDULA) ON UPDATE CASCADE,
CONSTRAINT TEL_POSITIVO_C CHECK (TELEFONO > 0) #Restricción entero positivo
);

#Creación de la tabla FACTURA
CREATE TABLE IF NOT EXISTS FACTURA(
NUMERO			VARCHAR(15)		PRIMARY KEY	COMMENT 'Código único para representar a cada factura emitida por una farmacia',
TOTAL_BRUTO		DECIMAL(5,2)	NOT NULL	COMMENT 'Sumatoria de costos de elementos sin IVA ni descuento',
TOTAL_DSCTO		DECIMAL(5,2)	NOT NULL	COMMENT 'Descuento a aplicarse en la compra descrita en la factura',
TOTAL_IVA		DECIMAL(5,2)	NOT NULL	COMMENT 'Total de IVA  aplicarsele a la factura dependiendo del país de procedencia',
TOTAL_FACTURA	DECIMAL(6,2)	NOT NULL	COMMENT 'Sumatoria total a pagar por el cliente',
ID_FARMACIA		VARCHAR(10)		NOT NULL	COMMENT 'Clave foránea de la tabla FARMACIA',
CEDULA_CLIENTE	VARCHAR(10)		NOT NULL	COMMENT 'Clave foránea de tabla CLIENTE',
CONSTRAINT FK_FAC_FARMACIA FOREIGN KEY (ID_FARMACIA) REFERENCES FARMACIA(CODIGO), 
CONSTRAINT FK_CLIENTE_FACTURA FOREIGN KEY (CEDULA_CLIENTE) REFERENCES CLIENTE(CEDULA),
CONSTRAINT BRUTO_POSITIVO CHECK (TOTAL_BRUTO >= 0), #Restricción decimal positivo
CONSTRAINT DSCTO_POSITIVO CHECK (TOTAL_DSCTO > 0), #Restricción decimal positivo
CONSTRAINT IVA_POSITIVO CHECK (TOTAL_IVA > 0), #Restricción decimal positivo
CONSTRAINT FACTURA_POSITIVO CHECK (TOTAL_FACTURA >= 0) #Restricción decimal positivo
);

#Creación de la tabla MEDICINA
CREATE TABLE IF NOT EXISTS MEDICINA(
CODIGO			VARCHAR(10)		PRIMARY KEY		COMMENT 'Código alfa numérico que identifica de forma única a la medicina',
REG_SANITARIO	        VARCHAR(20)		                        COMMENT 'Numero de registro sanitario en el Ecuador',
NOMBRE			VARCHAR(20)		NOT NULL		COMMENT 'Nombre completo de la medicina.',
FABRICANTE		VARCHAR(20)		         		COMMENT 'Nombre del fabricante de la medicina.',
PAIS_ORIGEN		VARCHAR(10)		        		COMMENT 'Nombre del país de donde se fabricó la medicina.',
DESCRIPCION		VARCHAR(10)		         		COMMENT 'Descripción general acerca del propósito de la medicina.',
TIPO_USO		VARCHAR(10)		         		COMMENT 'Descripción acerca de como administrar la medicina.',
ID_CATEGORIA	INT				NOT NULL		COMMENT 'Clave foránea proveniente de Categoría de Medicina',
ID_CADUCIDAD	INT				         		COMMENT 'Clave foránea proveniente de Caducidad de Medicina'
);

#Creación de la tabla CATEGORIA_MEDICINA
CREATE TABLE IF NOT EXISTS CATEGORIA_MEDICINA(
ID_CATEGORIA	INT				PRIMARY KEY					COMMENT 'Número que identifica de forma única la categoría de la medicina.',
NOMBRE			VARCHAR(30)		NOT NULL		UNIQUE		COMMENT 'Nombre de la categoría de la medicina.',
CONSTRAINT ID_POSITIVO CHECK (ID_CATEGORIA > 0) #Restricción entero positivo
);

#Creación de la tabla CADUCIDAD_MEDICINA
CREATE TABLE IF NOT EXISTS CADUCIDAD_MEDICINA(
ID_CADUCIDAD	INT				PRIMARY KEY					COMMENT 'Clave artificial que identifica de forma única la caducidad de la medicina',
NUM_LOTE		VARCHAR(10)		NOT NULL					COMMENT 'Código alfa numérico que identifica el lote.',
FECHA_CADUCIDAD	DATE			NOT NULL					COMMENT 'Fecha que indica cuando expira la medicina.',
COD_MEDICINA	VARCHAR(10)		NOT NULL					COMMENT 'Clave foránea proveniente de Medicina',
CONSTRAINT ID_POSITIVO_CM CHECK (ID_CADUCIDAD > 0) #Restricción entero positivo
);

#Añadir constrains entre claves foráneas de MEDICINA, CADUCIDAD_MEDICINA, CATEGORIA_MEDICINA
ALTER TABLE MEDICINA ADD CONSTRAINT FK_CATEGORIA FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA_MEDICINA(ID_CATEGORIA) ON UPDATE CASCADE;
ALTER TABLE MEDICINA ADD CONSTRAINT FK_CADUCIDAD FOREIGN KEY (ID_CADUCIDAD) REFERENCES CADUCIDAD_MEDICINA(ID_CADUCIDAD) ON UPDATE CASCADE;
ALTER TABLE CADUCIDAD_MEDICINA ADD CONSTRAINT FK_MEDICINA FOREIGN KEY (COD_MEDICINA) REFERENCES MEDICINA(CODIGO) ON UPDATE CASCADE;

#Creación de la tabla FACTURA_ITEM
CREATE TABLE IF NOT EXISTS FACTURA_ITEM(
ID_ITEM			INT				PRIMARY KEY		COMMENT 'Número único otorgado a cada ciudadano de un país en específico.',
CANTIDAD		INT				NOT NULL		COMMENT 'Cantidad del producto vendido.',
PRECIO			DECIMAL(5,2)	NOT NULL		COMMENT 'Número que representa el precio unitario',
POR_DSCTO		INT				NOT NULL		COMMENT 'Número que representa el porcentaje de descuento otorgado al producto.',
POR_IVA			DECIMAL(2,2)	NOT NULL		COMMENT 'Número que representa el cargo del IVA al producto',
NETO			DECIMAL(5,2)	NOT NULL		COMMENT 'Número que representa el precio neto del producto',
ID_FACTURA		VARCHAR(15)		NOT NULL		COMMENT 'Dirección en donde se encuentra ubicada la casa del cliente',
COD_MEDICINA	VARCHAR(10)		NOT NULL		COMMENT 'Numero telefonico en donde puede ser contactado el usuario',
CONSTRAINT FK_ITEM_FACTURA FOREIGN KEY (ID_FACTURA) REFERENCES FACTURA(NUMERO),
CONSTRAINT FK_ITEM_MEDICINA FOREIGN KEY (COD_MEDICINA) REFERENCES MEDICINA(CODIGO),
CONSTRAINT ITEM_POSITIVO CHECK (ID_ITEM > 0), #Restricción entero positivo
CONSTRAINT CANTIDAD_POSITIVO CHECK (CANTIDAD > 0), #Restricción entero positivo
CONSTRAINT PRECIO_POSITIVO CHECK (PRECIO > 0), #Restricción decimal positivo
CONSTRAINT DSCTO_POSITIVO_F CHECK (POR_DSCTO >= 0), #Restricción entero positivo
CONSTRAINT IVA_POSITIVO_F CHECK (PRECIO >= 0), #Restricción decimal positivo
CONSTRAINT NETO_POSITIVO CHECK (NETO > 0) #Restricción decimal positivo
);

#Creacion de tabla KARDEX - representa el stock
CREATE TABLE IF NOT EXISTS KARDEX(
ID_KARDEX     INT             PRIMARY KEY    COMMENT 'Codigo numerico el cual identifica un registro de stock',
COD_MEDICINA  VARCHAR(10)     NOT NULL       COMMENT 'Codigo alfa numerico y clave foranea la cual identifica a la medicina que se le hace registro de stock',
ID_BODEGA     VARCHAR(10)     NOT NULL       COMMENT 'Codigo identificador y clave foranea referenciando la bodega donde se hace registro de stock',
COD_FARMACIA  VARCHAR(10)     NOT NULL       COMMENT 'Codigo identificador y clave foranea referenciando la farmacia donde se registra el stock',
CANTIDAD_MAX  DECIMAL                        COMMENT 'Numero que representa la cantidad maxima de stock',
CANTIDAD_MIN  DECIMAL                        COMMENT 'Numero que representa la cantidad minima de stock',
STOCK         DECIMAL         NOT NULL       COMMENT 'Cantidad de stock actualizado',
CONSTRAINT FK_KARDEX_CODMED FOREIGN KEY (COD_MEDICINA) REFERENCES MEDICINA(CODIGO) ON UPDATE CASCADE,
CONSTRAINT FK_KARDEX_IDBOD FOREIGN KEY (ID_BODEGA) REFERENCES BODEGA(ID_BODEGA) ON UPDATE CASCADE,
CONSTRAINT FK_KARDEX_CODFAR FOREIGN KEY (COD_FARMACIA) REFERENCES FARMACIA(CODIGO) ON UPDATE CASCADE
);

#Creacion de la tabla KARDEX_MOVIMIENTO - representa el detalle del registro de stock
CREATE TABLE IF NOT EXISTS KARDEX_MOVIMIENTO(
ID_MOVIMIENTO      INT            PRIMARY KEY    COMMENT 'Codigo que identifica a los detalles del registro de stock',
ID_KARDEX          INT            NOT NULL       COMMENT 'Codigo que referencia el registro de stock principal',
ID_CADUCIDAD       INT(11)        NOT NULL       COMMENT 'Codigo que referencia el registro de fecha de caducidad de cada lote de medicinas',
TIPO_MOVIMIENTO    CHAR(1)        NOT NULL       COMMENT 'Representa el tipo de movimiento en cuanto a stock (salida o ingreso)',
DESCRIPCION        VARCHAR(20)    NOT NULL       COMMENT 'Descripcion del movimiento',
CANTIDAD           INT            NOT NULL       COMMENT 'Numero que identifica la cantidad involucrada en el movimiento',
CONSTRAINT FK_KARDEXMOV_IDKARDEX FOREIGN KEY (ID_KARDEX) REFERENCES KARDEX(ID_KARDEX) ON UPDATE CASCADE,
CONSTRAINT FK_KARDEXMOV_IDCAD FOREIGN KEY (ID_CADUCIDAD) REFERENCES CADUCIDAD_MEDICINA(ID_CADUCIDAD) ON UPDATE CASCADE
);

#Creación de la tabla NOTA_EGRESO
CREATE TABLE IF NOT EXISTS NOTA_EGRESO(
NUM_EGRESO 		VARCHAR(10) 	PRIMARY KEY		COMMENT 'Código alfa numérico que identifica de forma la nota de egreso',
SOLICITANTE 	VARCHAR(10) 	NOT NULL		COMMENT 'Clave foránea proveniente de Empleado que identifica al empleado administrador de bodega solicitante',
BODEGUERO 		VARCHAR(10) 	NOT NULL		COMMENT 'Clave foránea proveniente de Empleado que identifica al empleado en bodega que realizó el despacho',
BODEGA 			VARCHAR(10) 	NOT NULL		COMMENT 'Clave foránea proveniente de Bodega que identifica la bodega a donde se hizo el egreso',
FECHA_SOLICITUD DATE 			NOT NULL		COMMENT 'Fecha que indica cuando se requirio cierta cantidad y tipos de medicamentos',
FECHA_EGRESO 	DATE 			NOT NULL		COMMENT 'Fecha que indica cuando se realizó el egreso de los medicamentos de la bodega',
DESTINO 		VARCHAR(100) 	NOT NULL		COMMENT 'Breve detalle del destino hacia donde se dirigiran los medicamentos que egresaron',
CONSTRAINT FK_NOTAEGR_EMPSOLIC FOREIGN KEY (SOLICITANTE) REFERENCES EMPLEADO(ID_EMPLEADO) ON UPDATE CASCADE,
CONSTRAINT FK_NOTAEGR_BODGUERO FOREIGN KEY (BODEGUERO) REFERENCES EMPLEADO(ID_EMPLEADO) ON UPDATE CASCADE,
CONSTRAINT FK_NOTAEGR_BODEGA FOREIGN KEY (BODEGA) REFERENCES BODEGA(ID_BODEGA) ON UPDATE CASCADE
);

#Creación de la tabla NOTA_EGRESO_ITEM
CREATE TABLE IF NOT EXISTS NOTA_EGRESO_ITEM(
ID_ITEM 		INT 			PRIMARY KEY		COMMENT 'Código numérico que identifica únicamente al item dentro de la nota de egreso',
NUM_EGRESO 	    CHAR(10) 		NOT NULL		COMMENT 'Clave foránea proveniente de Nota de Egreso que identifica de donde proviene el item',
COD_MEDICINA 	VARCHAR(10) 	NOT NULL		COMMENT 'Clave foránea proveniente de Medicina que identifica a la medicina',
ID_CADUCIDAD 	INT 			NOT NULL		COMMENT 'Clave foránea proveniente de Medicina que identifica la fecha de caducidad',
CANTIDAD 		INT			 	NOT NULL		COMMENT 'Número que identifica la cantidad del item que se está egresando',
CONSTRAINT FK_NOTAEGITEM_MEDICINA FOREIGN KEY (COD_MEDICINA) REFERENCES MEDICINA(CODIGO) ON UPDATE CASCADE,
CONSTRAINT FK_NOTAEGITEM_CADUCIDAD FOREIGN KEY (ID_CADUCIDAD) REFERENCES CADUCIDAD_MEDICINA(ID_CADUCIDAD) ON UPDATE CASCADE,
CONSTRAINT ITEM_POSITIVO_NE CHECK (ID_ITEM > 0), #Restricción entero positivo
CONSTRAINT CANTIDAD_POSITIVO_NE CHECK (CANTIDAD > 0), #Restricción entero positivo
CONSTRAINT FK_NOTA_EGRESO FOREIGN KEY (NUM_EGRESO) REFERENCES NOTA_EGRESO(NUM_EGRESO) ON UPDATE CASCADE
);

#Creación de la tabla NOTA_INGRESO
CREATE TABLE IF NOT EXISTS NOTA_INGRESO(
NUM_INGRESO			CHAR(10)		PRIMARY KEY		COMMENT 'Código alfa numérico que identifica de forma la nota de ingreso',
FECHA_SOLICITUD		DATE			NOT NULL		COMMENT 'Fecha que indica cuando se realizó la solicitud de ingreso',
FECHA_INGRESO		DATE			NOT NULL		COMMENT 'Fecha que indica cuando se realizó el ingreso a bodega',
JUSTIFICATIVO		VARCHAR(50)		NOT NULL		COMMENT 'Descripción acerca del ingreso de la medicina a bodega',
SOLICITANTE			VARCHAR(10)		NOT NULL		COMMENT 'Clave foránea proveniente de Empleado que identifica al empleado administrador de bodega solicitante',
BODEGUERO			VARCHAR(10)		NOT NULL		COMMENT 'Clave foránea proveniente de Empleado que identifica al empleado en bodega que realizó el despacho',
BODEGA				VARCHAR(10)		NOT NULL		COMMENT 'Clave foránea proveniente de Bodega que identifica la bodega a donde se hizo el ingreso',
CONSTRAINT FK_NOTAINGRESO_SOLICITANTE FOREIGN KEY (SOLICITANTE) REFERENCES EMPLEADO(ID_EMPLEADO),
CONSTRAINT FK_NOTAINGRESO_BODEGUERO FOREIGN KEY (BODEGUERO) REFERENCES EMPLEADO(ID_EMPLEADO),
CONSTRAINT FK_NOTAINGRESO_BODEGA FOREIGN KEY (BODEGA) REFERENCES BODEGA (ID_BODEGA)
);

#Creación de la tabla NOTA_INGRESO_ITEM
CREATE TABLE IF NOT EXISTS NOTA_INGRESO_ITEM(
ID_ITEM 		INT 			PRIMARY KEY		COMMENT 'Código numérico que identifica únicamente al item dentro de la nota de ingreso',
NUM_INGRESO 	CHAR(10) 		NOT NULL		COMMENT 'Clave foránea proveniente de Nota de Ingreso que identifica de donde proviene el item',
COD_MEDICINA 	VARCHAR(10) 	NOT NULL		COMMENT 'Clave foránea proveniente de Medicina que identifica a la medicina',
ID_CADUCIDAD 	INT 			NOT NULL		COMMENT 'Clave foránea proveniente de Medicina que identifica la fecha de caducidad',
CANTIDAD 		INT			 	NOT NULL		COMMENT 'Número que identifica la cantidad del item que se está ingresando',
CONSTRAINT FK_NOTAIGITEM_MEDICINA FOREIGN KEY (COD_MEDICINA) REFERENCES MEDICINA(CODIGO) ON UPDATE CASCADE,
CONSTRAINT FK_NOTAIGITEM_CADUCIDAD FOREIGN KEY (ID_CADUCIDAD) REFERENCES CADUCIDAD_MEDICINA(ID_CADUCIDAD) ON UPDATE CASCADE,
CONSTRAINT ITEM_POSITIVO_NI CHECK (ID_ITEM > 0), #Restricción entero positivo
CONSTRAINT CANTIDAD_POSITIVO_NING CHECK (CANTIDAD > 0), #Restricción entero positivo
CONSTRAINT FK_NOTA_INGRESO FOREIGN KEY (NUM_INGRESO) REFERENCES NOTA_INGRESO (NUM_INGRESO) ON UPDATE CASCADE
);
