package General;

import Categoria.Categorias;
import Ubicacion.Coordenadas;
import java.time.LocalDateTime;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolepilco
 */

public class Proveedor extends Personas{
    private String numeroContacto;
    private ArrayList<Producto> productosProveedor;
    private ArrayList<Pedido> pedidosProveedor;

   
    /**
     * Constructor de la clase Proveedor
     * @param nombre nombre del usuario
     * @param numeroIdentificacion  cedula del usuario
     * @param direccion direccion del usuario
     * @param ubicacion objeto Coordenadas generado por geocoding que posee latitud y longitud
     * @param correo_electronico email del usuario
     * @param nombreUsuario username del usuario para el inicio de sesion
     * @param clave clave del usuario para el inicio de sesion
     * @param numeroContacto numero de telefono del usuario
     */
    public Proveedor(String nombre, String numeroIdentificacion, String direccion,
        Coordenadas ubicacion, String correo_electronico, String nombreUsuario, String clave, String numeroContacto){
        super(nombre, numeroIdentificacion, direccion, ubicacion, correo_electronico, nombreUsuario, clave);
        this.numeroContacto = numeroContacto;
        this.productosProveedor=new ArrayList<>();
        this.pedidosProveedor = new ArrayList();
    }


    public Proveedor(String nombre, String numeroIdentificacion, String direccion,
        Coordenadas ubicacion, String correo_electronico, String numeroContacto){
        super(nombre, numeroIdentificacion, direccion, ubicacion, correo_electronico);
        this.numeroContacto = numeroContacto;
        this.productosProveedor=new ArrayList<>();
        this.pedidosProveedor = new ArrayList();
    }

 
    
    public String getNumeroContacto() {
        return numeroContacto;
    }

    public ArrayList<Producto> getProductosProveedor() {
        return productosProveedor;
    }


    public ArrayList<Pedido> getPedidosProveedor() {
        return pedidosProveedor;
    }

    public void setPedidosProveedor(ArrayList<Pedido> pedidosProveedor) {
        this.pedidosProveedor = pedidosProveedor;
    }
    /**
     * Metodo que permite a los proveedores registrar sus productos al sistema
     * @param codigo Codigo del Producto
     * @param nombre Nombre del Producto
     * @param descripcion Breve descripcion del producto
     * @param categoria Categoria o Categorias a las cuales pertenece el producto
     * @param precio Costo por unidad del Producto
     * @param pro Proveedor al cual le pertence el Producto
     */
    
    public void registrarProductos(String codigo,String nombre,String descripcion,String categoria, double precio, Proveedor pro){
        Producto p= new Producto(codigo,nombre,descripcion, categoria, precio, pro);
        productosProveedor.add(p);
    }
    /**
     * Metodo que muestra la informacion de todos los pedidos
     */
    public void consultarInformacionPedidos(){
        for (Pedido ped: pedidosProveedor){
               System.out.println(ped);}
    }
    
    /**
     * Metodo que permite la gestion de los estados de cada pedido
     * @param cod codigo del pedido del cual se desea cambiar el estado
     * @return retorna boolean true si el pedido existe, caso contrario retorna false
     */
    public boolean existPedido(int cod){
        for (Pedido p :pedidosProveedor){
            if(p.getCodigo()==cod){return true;}
        }
        return false;
    }


    public void cambiarEstadoPedido(int codigo){
        for (Pedido ped: pedidosProveedor){
            if (ped.getCodigo()==codigo)
            {
                if (ped.getEstado().toLowerCase().equals("solicitado")){
                    ped.setEstado("procesando");
                    ped.setFecha(LocalDateTime.now());
                    ped.agregaEstados();
                }
                else if (ped.getEstado().toLowerCase().equals("procesando")){
                ped.setEstado("despachado");}
                ped.setFecha(LocalDateTime.now());
                ped.agregaEstados();
            }

            
        }
    }
     
    /**
     * Metodo que permite al proveedor editar el nombre de sus productos
     * @param nombre Nuevo nombre del producto
     * @param producto producto a ser editado.
     */ 
     
    public void editarProductoNom(Producto producto, String nombre){
        producto.setNombre(nombre);
    }
    
    
    /**
     * Metodo que permite al Proveedor editar la descripcion de un producto
     * @param producto producto a ser editado.
     * @param descripcion Nueva descripcion del producto

     */
    public void editarProductoDes(Producto producto, String descripcion){
        producto.setDescripcion(descripcion);
    }

    /**
     * Metodo que permite al Proveedor editar la Categoria de un producto
     * @param producto producto a ser editado.
     * @param categoria Nueva categoria del producto
     * @param opcion Opcion con respecto al menu de edicion.
     */
    public void editarProductoCat(Producto producto, String categoria, int opcion){
         producto.cambiarCategoria(opcion,Categorias.valueOf(categoria.toUpperCase()));
    }



    /**
     * Metodo que permite al Proveedor editar el Precio de un producto
     * @param precio Nueva precio del producto
     * @param producto producto a ser editado.
     */
    
    public void editarProductoPrecio(Producto producto, double precio){
        producto.setPrecio(precio);
    }
    
    /**
     * Metodo que permite al Proveedor consulta la informacion de los productos
     * @param categoria Nombre de la categoria 
     * @param nombre Nombre del producto

     */
    public void consultarInformacionProductos(String categoria, String nombre){
boolean i=true;
        String cat=categoria.toUpperCase();
        for (Producto p: productosProveedor){
            if ((p.getCategoria().toString().contains(cat)) && (p.getNombre().contains(nombre))){
                i=false;
                System.out.println(p);
            }
        }
        if(i){System.out.println("no se encontraron productos con las especificaciones indicadas");}
    }
    
    /**
     * Metodo que permite buscar un producto a partir de su codigo
     * @param codigo codigo del producto
     * @return el producto al cual le pertence dicho codigo
     */
    
    public Producto buscarProducto(String codigo){
        for (Producto p: productosProveedor){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }

 }
