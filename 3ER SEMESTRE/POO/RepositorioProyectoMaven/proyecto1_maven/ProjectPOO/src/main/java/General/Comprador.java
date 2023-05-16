package General;


import Categoria.Categorias;
import Pago.MetododePago;
import Ubicacion.Coordenadas;
import compra.CarritoCompra;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Natalia Ramirez
 */


public class Comprador extends Personas{
    private MetododePago forma_pago;
    private CarritoCompra carrito;
    private ArrayList<Proveedor> proveCercanos;
    private ArrayList<Pedido> pedidosComprador;

    public Comprador() {
    }
    

    
    public MetododePago getForma_pago() {
        return forma_pago;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }
    public void setForma_pago(MetododePago forma_pago) {
        this.forma_pago = forma_pago;
    }
    
    public void setCarrito(CarritoCompra carrito) {
        this.carrito = carrito;
    }
    
   /**
    * Constructor clase Comprador
    * @param nombre nombre del usuario
    * @param numeroIdentificacion cedula del usuario
    * @param direccion direccion del usuario
    * @param ubicacion objeto Coordenadas que posee latitud y longitud - generado por geocoding
    * @param correo_electronico email del usuario
    * @param nombreUsuario username del usuario para iniciar sesion
    * @param clave clave del usuario para iniciar sesion
    * @param forma_pago objeto MetododePago el cual es del tipo preferido del usuario para sus compras (paypal o tarjeta)
    */
    public Comprador(String nombre, String numeroIdentificacion, String direccion, Coordenadas ubicacion, String correo_electronico, String nombreUsuario, String clave, MetododePago forma_pago) {
        super(nombre,numeroIdentificacion, direccion, ubicacion, correo_electronico, nombreUsuario, clave);
        this.forma_pago = forma_pago;
        CarritoCompra carrito = new CarritoCompra(this); 
        this.carrito = carrito;
        this.pedidosComprador = new ArrayList();
        this.proveCercanos = new ArrayList<>();
    }
    
    public Comprador(String nombre, String numeroIdentificacion, String direccion, Coordenadas ubicacion, String correo_electronico, MetododePago forma_pago) {
        super(nombre,numeroIdentificacion, direccion, ubicacion, correo_electronico);
        this.forma_pago = forma_pago;
        this.carrito = new CarritoCompra(this);
        this.pedidosComprador = new ArrayList();
        this.proveCercanos = new ArrayList<>();
    }
    /**
     * Metodo que muestra la informacion del carrito de compras
     */
    public void consultarCarrito(){
        carrito.mostrarCarrito();
    }
    

    public ArrayList<Proveedor> getProveCercanos() {
        return proveCercanos;
    }

    public void setProveCercanos(ArrayList<Proveedor> proveCercanos) {
        this.proveCercanos = proveCercanos;
    }

    public ArrayList<Pedido> getPedidosComprador() {
        return pedidosComprador;
    }

    public void setPedidosComprador(ArrayList<Pedido> pedidosComprador) {
        this.pedidosComprador = pedidosComprador;
    }
    
    /**
     * Metodo que muestra la informacion de los pedidos que tiene el comprador
     */
    public void consultarPedidos(){
        for (Pedido p: pedidosComprador){
            System.out.println(p);
        }
    }
    
    /**
     * Metodo que busca los proveedores que se encuentran a una distancia menor a 50 km
     * del cliente que esta realizando busquedas.
     * @param proveedoresSistema ArrayList de proveedores que estan registrados en el sistema
     */
    public void consultarInfoDistan(ArrayList<Proveedor> proveedoresSistema){
        for(Proveedor p: proveedoresSistema){

            double distancia = Coordenadas.calcularDistanciaDosPuntos(this.getUbicacion(), p.getUbicacion());
            if(distancia <= 50){
                proveCercanos.add(p);
            }
        }
    }
    
    /**
     * Metodo que permite buscar un producto a partir de su codigo
     * @param producto Array que contiene los productos con respecto al ultimo filtro ingresado por el usuario
     * @param codigo Codigo del producto del cual se desea saber la informacion
     * @return retorna el producto al cual le pertenece dicho codigo
     */
    
    public Producto buscarProductoCodi(ArrayList<Producto> producto, String codigo){
        for(Producto p: producto){
            if(p.getCodigo().equals(codigo)){
                return p;
            }
        }
        return null;
    }
    /**
     * Metodo que permite al usuario filtrar los productos por una categoria en especfica
     * @param categoria Nombre de la categoria por el cual se desea filtrar
     * @return retorna la lista de los productos que tienen dentro de sus categorias la categoria ingresada por el usuario
     */
    public ArrayList<Producto> porFiltroCategoria(String categoria){
        ArrayList<Producto> producto1 = new ArrayList<>();       
        for(Proveedor pro: proveCercanos){
            for(Producto prod :pro.getProductosProveedor()){
                for(Categorias cat:prod.getCategoria()){
                    
                    if(cat == Categorias.valueOf(categoria.toUpperCase())){
                        producto1.add(prod);
                    }    
                }                    
            }
        }
        return producto1;
    }
    /**
     * Metodo que permite al usuario filtrar los productos por un nombre(ya sea parcial o completo)
     * @param nombre contiene la cadena de texto que hara referencia al nombre o a la parte del nombre de un producto 
     * del cual el usuario desea saber informacion
     * @return retorna una arreglo con los productos que contenga esa subcadena dentro de su nombre.
     */
    public ArrayList<Producto> porFiltroName(String nombre){
        ArrayList<Producto> producto1 = new ArrayList<>();
        for(Proveedor pro: proveCercanos){
            for(Producto prod :pro.getProductosProveedor()){
                if(prod.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                    producto1.add(prod);
                }
            }
        }
        return producto1;
    }
    
    /**
     * Metodo que permite al usuario filtrar los productos por un rango de precio seleccionado por el
     * @param precioMax representa el valor maximo de los  productos
     * @param precioMin representa el valor minimo de los productos
     * @return retorna un arreglo con los productos que esten dentro de ese rango de precio
     */
        
    public ArrayList<Producto> porFiltroPrecio(double precioMax, double precioMin){
        ArrayList<Producto> producto1 = new ArrayList<>();
        for(Proveedor pro: proveCercanos){
            for(Producto prod :pro.getProductosProveedor()){
                if(prod.getPrecio()<= precioMax && prod.getPrecio()>= precioMin){
                    producto1.add(prod);
                }
            }
        }
        return producto1;
    }

    
    /**
     * Metodo toStringClaseComprador
     * @return String que contiene la informacion del carrito del comprador
     */
    @Override
    public String toString() {
        return "Comprador{" + "carrito=" + carrito + '}';
    }
    
    
    
    
}
