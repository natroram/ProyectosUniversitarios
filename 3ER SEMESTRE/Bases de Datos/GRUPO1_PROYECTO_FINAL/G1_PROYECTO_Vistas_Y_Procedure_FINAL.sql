/*						Creación de Vistas						*/

USE G1_PROYECTO;

/*Vista1: Reporte de ingresos de bodega por solicitante, por fecha y por medicamento. Debe presentar dirección de la bodega,
nombre del solicitante, fecha de solicitud y el nombre de los medicamentos ingresados, la cantidad de medicamentos ingresados */
drop view if exists reporte_ingresos_bodega;
create view reporte_ingresos_bodega as
select
ni.NUM_INGRESO as numero_ingreso,
b.DIRECCION as direccion_bodega,
concat(p.NOMBRE, ' ', p.APELLIDO_PATERNO, ' ', p.APELLIDO_MATERNO) as solicitante,
ni.FECHA_SOLICITUD as fecha_solicitud,
m.NOMBRE as nombre_medicina,
nii.CANTIDAD as cantidad
from nota_ingreso ni
inner join (bodega b, nota_ingreso_item nii, empleado e, persona p, medicina m)
on (ni.BODEGA = b.ID_BODEGA and
ni.NUM_INGRESO = nii.NUM_INGRESO and
ni.SOLICITANTE = e.ID_EMPLEADO and
e.CEDULA = p.CEDULA and
nii.COD_MEDICINA = m.CODIGO)
group by ni.NUM_INGRESO, m.NOMBRE, nii.CANTIDAD
order by ni.FECHA_SOLICITUD desc;

/*Vista2: Reporte de egreso de bodega por solicitante, por fecha y por farmacia de destino. Debe presentar dirección de la bodega,
nombre del solicitante, fecha de egreso, nombre del solicitante, nombre de la farmacia de destino, dirección de la farmacia de destino,
la cantidad de medicamentos*/
drop view if exists reporte_egresos_bodega;
create view reporte_egresos_bodega as
select
ne.NUM_EGRESO as numero_egreso,
b.DIRECCION as direccion_bodega,
concat(p.NOMBRE, ' ', p.APELLIDO_PATERNO, ' ', p.APELLIDO_MATERNO) as solicitante,
ne.FECHA_EGRESO as fecha_egreso,
f.NOMBRE as farmacia_destino,
concat(f.CALLE_PRINCIPAL, ', ', f.CALLE_SECUNDARIA, ', ', f.REFERENCIA, ', ', c.NOMBRE, ', ',pr.NOMBRE) as direccion_farmacia_destino,
m.NOMBRE as nombre_medicina,
nei.CANTIDAD as cantidad
from nota_egreso ne
inner join (bodega b, nota_egreso_item nei, empleado e, persona p, farmacia f, medicina m, canton c, provincia pr)
on (ne.BODEGA = b.ID_BODEGA and
ne.NUM_EGRESO = nei.NUM_EGRESO and
ne.SOLICITANTE = e.ID_EMPLEADO and
e.CEDULA = p.CEDULA and
ne.DESTINO = f.CODIGO and
nei.COD_MEDICINA = m.CODIGO and
f.ID_CANTON = c.ID_CANTON and
c.ID_PROVINCIA = pr.ID_PROVINCIA)
group by ne.NUM_EGRESO, m.NOMBRE, nei.CANTIDAD
order by ne.FECHA_EGRESO desc;

/*Vista 3: Frecuencia de compras de clientes por categoría. Debe presentar el nombre de la categoría,
el nombre del cliente, la cantidad de veces que ha comprado productos de la categoría,
y el total de dinero que ha comprado productos de la categoría.*/
drop view if exists reporte_compras_clientes_categoria;
create view reporte_compras_clientes_categoria as
select cat.NOMBRE as categoria,
concat(p.NOMBRE, ' ', p.APELLIDO_PATERNO, ' ', p.APELLIDO_MATERNO) as cliente,
count(fitem.ID_ITEM) as cantidad_veces_compra_productos,
sum(fitem.CANTIDAD * fitem.PRECIO) as total_productos
from cliente cl
inner join (persona p, factura fac, factura_item fitem, medicina m, categoria_medicina cat)
on (cl.CEDULA = p.CEDULA and
cl.CEDULA = fac.CEDULA_CLIENTE and
fac.NUMERO = fitem.ID_FACTURA and
fitem.COD_MEDICINA = m.CODIGO and
m.ID_CATEGORIA = cat.ID_CATEGORIA)
group by cat.NOMBRE, p.NOMBRE, p.APELLIDO_PATERNO, p.APELLIDO_MATERNO
order by cantidad_veces_compra_productos desc;

#======================================================================================================================================#

/*						Creación del Trigger como Store Procedure 						*/
#Store Procdure: cuando se ejecute una venta debe disminuir el stock del medicamento en la farmacia automáticamente.

#Eliminar el procedure si ya existe
drop procedure if exists crear_venta;

#Inicio del Procedure
delimiter |

create procedure crear_venta(

#Variables que requiere el procedure
in num_factura varchar(15),
in id_farmacia varchar(10),
in cedula_cliente varchar(10), 
in cantidad int,
in precio decimal(5,2),
in por_dscto int,
in por_iva decimal(2,2),
in cod_medicina varchar(10),
exito boolean)

begin
	#Bloque de Manejo de Excepcion
	declare exit handler for sqlexception
    begin
		rollback;
        set exito = false;
	end;
    
    #Inicio de la Transaccion
    start transaction;
		
		#creacion de factura
        insert into factura (NUMERO, TOTAL_BRUTO, TOTAL_DSCTO, TOTAL_IVA, TOTAL_FACTURA, ID_FARMACIA, CEDULA_CLIENTE) values
        (num_factura, 0, 0, 0, 0, id_farmacia, cedula_cliente);
        
        #creacion del item de la factura
		insert into factura_item (ID_ITEM, CANTIDAD, PRECIO, POR_DSCTO, POR_IVA, NETO, ID_FACTURA, COD_MEDICINA) values
        (1, cantidad, precio, por_dscto, por_iva, precio, num_factura, cod_medicina);
        
        #actualizacion de factura
        update factura set TOTAL_BRUTO = cantidad * precio where factura.NUMERO = num_factura;
        update factura set TOTAL_DSCTO = TOTAL_BRUTO * (por_dscto * 0.01) where factura.NUMERO = num_factura;
        update factura set TOTAL_IVA = TOTAL_BRUTO * por_iva where factura.NUMERO = num_factura;
        update factura set TOTAL_FACTURA = TOTAL_BRUTO - TOTAL_DSCTO - TOTAL_IVA where factura.NUMERO = num_factura;
        
        #actualizacion del stock
        update kardex set STOCK = STOCK - cantidad where kardex.COD_FARMACIA = id_farmacia and kardex.COD_MEDICINA = cod_medicina;
        
		# seteado de variable de stock
		set @stock = (select stock from kardex where kardex.COD_FARMACIA = id_farmacia and kardex.COD_MEDICINA = cod_medicina);
		
        # condicional para la validacion de stock
		if @stock < 0 then
			rollback;
			set exito = false;
		else
			commit;
		end if;
    
end;
|