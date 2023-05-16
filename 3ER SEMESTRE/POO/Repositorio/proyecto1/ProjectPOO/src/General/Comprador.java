package General;


import Pago.MetododePago;
import Ubicacion.Coordenadas;
import compra.CarritoCompra;

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

    public Comprador(String nombre, int numeroIdentificacion, String direccion, Coordenadas ubicacion, String correo_electronico, String nombreUsuario, String clave, MetododePago forma_pago) {
        super(nombre,numeroIdentificacion, direccion, ubicacion, correo_electronico, nombreUsuario, clave);
        this.forma_pago = forma_pago;
        CarritoCompra carrito = new CarritoCompra(); 
        this.carrito = carrito;
    }
    
    public Comprador(String nombre, int numeroIdentificacion, String direccion, Coordenadas ubicacion, String correo_electronico, MetododePago forma_pago) {
        super(nombre,numeroIdentificacion, direccion, ubicacion, correo_electronico);
        this.forma_pago = forma_pago;
        CarritoCompra carrito = new CarritoCompra(); 
        this.carrito = carrito;
    }
    public void consultarCarrito(){
        carrito.mostrarCarrito();
    }
    
    
    
}
