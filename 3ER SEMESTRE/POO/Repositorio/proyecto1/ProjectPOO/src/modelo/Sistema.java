/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import General.Comprador;
import General.Proveedor;
import Pago.MetododePago;
import Ubicacion.Coordenadas;
import java.util.ArrayList;

/**
 *
 * @author nicolepilco
 */
public class Sistema {
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Comprador> compradores;

    public Sistema() {
        this.proveedores = new ArrayList();
        this.compradores = new ArrayList();
    }
    
    public void registrarProveedor(String nombre, int numeroIdentificacion, String direccion,
        Coordenadas ubicacion, String correo_electronico, int numeroContacto, String usuario, String clave){
        Proveedor pro = new Proveedor(nombre, numeroIdentificacion, direccion, ubicacion, correo_electronico,usuario, clave, numeroContacto);
        proveedores.add(pro);
    }
    
    public void registrarComprador(String nombre, int numeroIdentificacion, String direccion,
        Coordenadas ubicacion, String correo_electronico, String usuario, String clave, MetododePago formapago){
        Comprador com = new Comprador(nombre, numeroIdentificacion, direccion, ubicacion,correo_electronico, usuario, clave, formapago);
        compradores.add(com);
    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList<Proveedor> proveedores) {
        this.proveedores = proveedores;
    }

    public ArrayList<Comprador> getCompradores() {
        return compradores;
    }

    public void setCompradores(ArrayList<Comprador> compradores) {
        this.compradores = compradores;
    }
    
    
    
}
