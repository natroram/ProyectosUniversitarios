/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;

import Categoria.Categorias;
import General.Producto;
import java.util.ArrayList;

/**
 *
 * @author Natalia Ramirez
 */
public class CarritoCompra {
    private ArrayList<DetalleProducto> articulos;
    private double total;
    
    public CarritoCompra(){
        this.articulos = new ArrayList();
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
    
    
    public void agregarProducto(Producto p, int cantidad){
        DetalleProducto dp = new DetalleProducto(p, cantidad);
        articulos.add(dp);
    }
    
    public double calcularTotal(ArrayList<DetalleProducto> articulos){
        double total = 0;
        for (DetalleProducto dp : articulos){
            double sub = dp.calcularSubtotal(dp.getProducto(), dp.getCantidad());
            total += sub;
        }
        this.total = total;
        return total;
    }
    public void mostrarCarrito(){
        System.out.println("\t\tDetalle de los productos agregados al momento");
        for (DetalleProducto dp: articulos){
            System.out.println(dp);
        }
        System.out.println("Total: " + calcularTotal(articulos)); 
    }
    
    public void eliminarProducto(String codigo){
        int indice=0;
        for (DetalleProducto dp: articulos){
            if (dp.getProducto().getCodigo().equals(codigo)){
                    indice=articulos.indexOf(dp);
                    break;
            }
        }
        articulos.remove(indice);
    }
    
    
    
    
    
    public static void main(String[] args){
        CarritoCompra c = new CarritoCompra();
        
        Producto p1 = new Producto("001", "leche", "lalalala", Categorias.LACTEOS, 10.0);
        Producto p3 = new Producto("003", "carne", "lalalala", Categorias.CARNICOS, 20.0);
        Producto p2 = new Producto("002", "mantequilla", "lalalala", Categorias.LACTEOS, 5.0);
        
        c.agregarProducto(p1, 2);
        c.agregarProducto(p2, 1);
        c.agregarProducto(p3, 4);
        
        c.calcularTotal(c.getArticulos());
        c.mostrarCarrito();
        
        c.eliminarProducto("001");
        c.mostrarCarrito();
    }
    
}


