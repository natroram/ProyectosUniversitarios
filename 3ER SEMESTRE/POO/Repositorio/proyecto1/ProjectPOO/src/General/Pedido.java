package General;


import Pago.MetododePago;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natalia Ramirez
 */
public class Pedido {
    private String codigoPedido;
    private String fechaPedido;
    private ArrayList<Producto> productosProveedor;
    private Comprador cliente;
    private MetododePago metodoPago;
    private ArrayList<String> fechaEstado;
    private ArrayList<String> estado;
    
    public Pedido(){
        
    }
    
    public Pedido(String codidoPedido, String fechaPedido, 
            ArrayList<Producto> productosProveedor, Comprador cliente,
            MetododePago metodoPago, ArrayList<String> fechaEstado, ArrayList<String> estado){
        
    }
    
    public String getCodigo(){
        return this.codigoPedido;
    }
    
    public String getFecha(){
        return this.fechaPedido;
    }
    
    public ArrayList getProductos(){
        return this.productosProveedor;
    }
    
    public Comprador getCliente(){
        return this.cliente;
    }
    
    public MetododePago getMetodoPago(){
        return this.metodoPago;
    }
    
    public ArrayList getFechas(){
        return this.fechaEstado;
    }
    
    public ArrayList getEstado(){
        return this.estado;
    }
    
    public void setCodigo(String codigo){
        this.codigoPedido = codigo;
    }
    
    public void setFecha(String fechaPedido){
        this.fechaPedido = fechaPedido;
    }
    
    public void setComprador(Comprador cliente){
        this.cliente = cliente;
    }
    
    public void setMetodoPago(MetododePago metodoPago){
        this.metodoPago = metodoPago;
    }

    public void setEstado(String estado) {
        this.estado.add(estado);
    }

    public void setFechaEstado(String fecha) {
        this.fechaEstado.add(fecha);
    }
    

    @Override
    public String toString() {
        return "Pedido{" + "codigoPedido=" + codigoPedido + ", fechaPedido=" + fechaPedido + ", productosProveedor=" + productosProveedor + ", cliente=" + cliente + ", metodoPago=" + metodoPago + ", fechaEstado=" + fechaEstado + ", estado=" + estado + '}';
    }

    
    
    
   
}
