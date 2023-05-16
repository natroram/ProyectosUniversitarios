/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compra;
import General.Producto;
/**
 *
 * @author Natalia Ramirez
 */
public class DetalleProducto {
    private Producto producto;
    private int cantidad;
    
    public DetalleProducto(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    public double calcularSubtotal(Producto producto, int cantidad){
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "Codigo: " +producto.getCodigo()+ ", Nombre: " + producto.getNombre() + 
                ", Cantidad: " + cantidad + ", Precio Unitario: "+ producto.getPrecio()+
                ", Subtotal: "+ calcularSubtotal(producto, cantidad);
    }
    
    
}
