package General;


import Pago.MetododePago;
import java.time.LocalDateTime;

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
public class Pedido {
    private int codigoPedi;
    private LocalDateTime fechaPedido;
    private ArrayList<Producto> productosProveedor;
    private Comprador cliente;
    private Proveedor proveedor;
    private MetododePago metodoPago;
    private ArrayList<LocalDateTime> RegistroFechas;
    private String estado;
    private double monto;
    private ArrayList<String> RegistroEstados;
    
    /**
     * Constructos de objeto Pedido
     * @param codigoPedido codigo unico del pedido (generado)
     * @param fechaPedido fecha en la que se realizo el peduido
     * @param productosProveedor lista de productos involucrados en el pedido
     * @param cliente objeto Comprador que representa al cliente que solicito el pedido
     * @param metodoPago objeto MetododePago que se utilizo al realizar la compra y generar el pedido
     * @param proveedor Objeto Proveedor que representa al proveedor del que fueron solititados los proudctos
     * @param estado estado actual del pedido
     * @param monto  cantidad que costo el pedido
     */
    public Pedido(int codigoPedido, LocalDateTime fechaPedido, 
            ArrayList<Producto> productosProveedor, Comprador cliente,
            MetododePago metodoPago, Proveedor proveedor, String estado, double monto){
        this.codigoPedi = codigoPedido ;
        this.cliente = cliente;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
        this.metodoPago = metodoPago;
        this.productosProveedor = productosProveedor;
        this.proveedor = proveedor;
        this.monto = monto;
        this.RegistroFechas= new ArrayList<>();
        this.RegistroEstados= new ArrayList<>();
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    public int getCodigo(){
        return this.codigoPedi;
    }
    
    public LocalDateTime getFecha(){
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
    
    /**
     * Metodo el cual registra los cambios de estado del pedido y la fecha en que se los realizo
     */
    public void agregaEstados(){
        RegistroEstados.add(getEstado());
        RegistroFechas.add(getFecha());
    }
    
    
    public ArrayList getFechas(){
      return this.RegistroFechas;
    }
    
    public String getEstado(){
        return this.estado;
    }
    
    public void setCodigo(int codigo){
        this.codigoPedi = codigo;
    }
    
    public void setFecha(LocalDateTime fechaPedido){
        this.fechaPedido = fechaPedido;
    }
    
    public void setComprador(Comprador cliente){
        this.cliente = cliente;
    }
    
    public void setMetodoPago(MetododePago metodoPago){
        this.metodoPago = metodoPago;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo toString() de Pedido
     * @return muestra la informacion detallada de cada pedido
     */
    @Override
    public String toString() {
        String Productos ="";
        for (Producto p: productosProveedor){
            Productos+=p+"\n";
        }
        return "\t\t Pedido\n" + 
                " CodigoPedido:\t " + codigoPedi+"\n"+ 
                " FechaPedido:\t " + fechaPedido + "\n"+ 
                " Productos Proveedor:\n " + Productos+
                " Cliente:\t " + cliente.getNombre() + "\n"+ 
                " MetodoPago:\t" + metodoPago + "\n"+ 
                " Estado:\t" + estado;
    }

    
    
    
   
}
