/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

import Categoria.Categorias;
import Correo.Mail;
import General.Comprador;
import General.Pedido;
import General.Producto;
import General.Proveedor;
import Ubicacion.Coordenadas;
import java.time.LocalDateTime;

import java.util.ArrayList;

/**
 *
 * @author Natalia Ramirez
 */
public class CarritoCompra {
    private ArrayList<DetalleProducto> articulos;
    private double total;
    private Comprador comprador;
    private Mail correo;
    
    public CarritoCompra(Comprador comprador){
        this.articulos = new ArrayList();
        this.comprador = comprador;
    }

    
    public ArrayList<DetalleProducto> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<DetalleProducto> articulos) {
        this.articulos = articulos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    /**
     * Agrega un producto al carrito de compras
     * @param p Producto que se desea agregar
     * @param cantidad  Cantidad que se desea agregar de ese producto
     */
    
    public void agregarProducto(Producto p, int cantidad){
        DetalleProducto dp = new DetalleProducto(p, cantidad);
        articulos.add(dp);
    }
    
    
    /**
     * Calcula el total de todos los productos que se encuentran en el carrito compra
     * @param articulos Array que contiene los articulos agregadados al producto
     * @return el total a pagar por todos los articulos dentro del carrito
     */
    public double calcularTotal(ArrayList<DetalleProducto> articulos){
        double total = 0;
        for (DetalleProducto dp : articulos){
            double sub = dp.calcularSubtotal(dp.getProducto(), dp.getCantidad());
            total += sub;
        }
        this.total = total;
        return total;
    }
    /**
     * Metodo que muestra el detalle de los productos del carrito
     */
    
    public void mostrarCarrito(){
        System.out.println("\t\tDetalle de los productos agregados al momento");
        for (DetalleProducto dp: articulos){
            System.out.println(dp);
        }
        System.out.println("Total: " + calcularTotal(articulos)); 
    }
    /**
     * Metodo que junta la informacion de la compra para poder enviarle en el email
     * @return el string con todos los productos que se compraron.
     */
       
    public String enviarInfoEmail(){

        String cadena ="";
            String total="";
            for (DetalleProducto dp: articulos){
                cadena+= dp.toString()+"\n";
        }
        total+= "Total: " + calcularTotal(articulos); 
        return "\t\tArticulos comprados\n"+cadena +" \n" + total;
    }
    
    
    /**
     * Metodo que permite eliminar un producto del carrito 
     * @param codigo  Codigo del producto a eliminarse
     * @return retorna un valor boolean true si se pudo eliminar el producto, caso contrario retorna false
     */
    public boolean eliminarProducto(String codigo){
        boolean valor = false;
        for (DetalleProducto dp: articulos){
            if (dp.getProducto().getCodigo().equals(codigo)){
                    int indice= articulos.indexOf(dp);
                    articulos.remove(indice);
                    valor = true;
                    break;
            }
        }
        return valor;
        
    }
/**
 * Genera un numero aleatoria para cada pedido
 * @param min Valor minimo
 * @param max Valor maximo
 * @return un entero entre los valores pasados como parametros
 */    
    public int generarCodPedido(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    /**
     * Metodo que genera un pedido para cada proveedor involucrado en la compra
     */
    
    public void generarPedidos(){
        ArrayList<Proveedor> provEnCompra = new ArrayList();
        ArrayList<ArrayList<Producto>> productosPorProveedor = new ArrayList();
        for(DetalleProducto dp : articulos){
            if(!(provEnCompra.contains(dp.getProducto().getProveedor()))){
                provEnCompra.add(dp.getProducto().getProveedor());
            }            
        }
        for(Proveedor pro : provEnCompra){
            ArrayList<Producto> prodProveedor = new ArrayList();
            for(DetalleProducto dp : articulos){
                if(pro.equals(dp.getProducto().getProveedor())){
                    prodProveedor.add(dp.getProducto());
                }
            }
            productosPorProveedor.add(prodProveedor);
        }
        
        for(Proveedor pro : provEnCompra){
            int cod = generarCodPedido(100, 999);
            int indice = provEnCompra.indexOf(pro);
            Pedido pedido = new Pedido(cod, LocalDateTime.now(),productosPorProveedor.get(indice) , comprador, comprador.getForma_pago(), 
            pro, "solicitado", total);
            pro.getPedidosProveedor().add(pedido);
            comprador.getPedidosComprador().add(pedido);
        }
        this.correo = new Mail(comprador.getCorreo_electronico());
        correo.sendMail("Detalle de la compra realizada", "Estimado cliente,\n"
                + "le mostramos los detalles de su compra:\n" + this.enviarInfoEmail());
    }
    
    /*public static void main(String[] args){
        Comprador comp = new Comprador();
        CarritoCompra c = new CarritoCompra(comp);
        Coordenadas cor= new Coordenadas(79.8, -79.8);
        Proveedor p= new Proveedor ("Nombre","1","direccion",cor,"proyecto@gmail.com","user","1234","123456");
        p.registrarProductos("001", "leche", "lalalala", "LACTEOS", 10.0, p);
        p.registrarProductos("005", "leche", "lalalala", "LACTEOS", 20.0, p);
        
        Proveedor p2= new Proveedor("E","1","direccion",cor,"proyecto@gmail.com","user11","1234","123456");
        p2.registrarProductos("002", "mantequilla", "lalalala", "LACTEOS", 5.0, p2);
        p2.registrarProductos("004", "mantequilla", "lala", "LACTEOS", 5.0, p2);
        
        Producto prod = new Producto("003", "carne", "lalalala", "CARNICOS", 20.0, p);
        
        c.agregarProducto(prod, 2);
        
        
        c.calcularTotal(c.getArticulos());
        c.mostrarCarrito();
        
        c.eliminarProducto("001");
        c.mostrarCarrito();
        
        Mail correo = new Mail("emaalpar@espol.edu.ec");
        correo.sendMail("Detalle de la compra realizada", "Estimado cliente,\n"
                + "le mostramos los detalles de su compra:\n"+ c.enviarInfoEmail());
    }*/
    
}


