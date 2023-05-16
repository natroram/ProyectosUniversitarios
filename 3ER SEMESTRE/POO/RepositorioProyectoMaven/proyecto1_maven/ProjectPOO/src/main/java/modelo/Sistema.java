/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import General.Comprador;
import General.Personas;
import General.Proveedor;
import Pago.MetododePago;
import Pago.PagoPaypal;
import Pago.PagoTarjeta;
import Ubicacion.Coordenadas;

import java.util.ArrayList;

/**
 *
 * @author nicolepilco
 */
public class Sistema {
    private ArrayList<Personas> personas;
    

    public Sistema() {
        this.personas = new ArrayList();
    }
    /**
     * Metodo que permite el registro del proveedor en el sistema
     * @param nombre nombre del usuario
     * @param numeroIdentificacion cedula del usuario
     * @param direccion direccion del usuario
     * @param ubicacion objeto Coordenadas generado por geoconding
     * @param correo_electronico email del usuario
     * @param numeroContacto telefono del usuario
     * @param usuario username del usuario para iniciar sesion
     * @param clave clave del usuario para iniciar sesion
     */
    
    public void registrarProveedor(String nombre, String numeroIdentificacion, String direccion,
        Coordenadas ubicacion, String correo_electronico, String usuario, String clave, String numeroContacto){
        Personas pro = new Proveedor(nombre, numeroIdentificacion, direccion, ubicacion, correo_electronico,usuario, clave, numeroContacto);
        personas.add(pro);
    }
    /**
     * Metodo que permite el registro del comprador en el sistema
     * @param nombre nombre del usuario
     * @param numeroIdentificacion cedula del usuario
     * @param direccion direccion del usuario
     * @param ubicacion objeto Coordenadas generado por geoconding
     * @param correo_electronico email del usuario
     * @param usuario username del usuario para iniciar sesion
     * @param clave clave del usuario para iniciar sesion
     * @param formapago objeto MetododePago con la info del metodo de pago preferido del usuario
     */
    public void registrarComprador(String nombre, String numeroIdentificacion, String direccion,
        Coordenadas ubicacion, String correo_electronico, String usuario, String clave, MetododePago formapago){
        Personas com = new Comprador(nombre, numeroIdentificacion, direccion, ubicacion,correo_electronico, usuario, clave, formapago);
        personas.add(com);
    }

    public ArrayList<Personas> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Personas> personas) {
        this.personas = personas;
    }
    
    public Personas buscarUsuario(String usuario, String clave){
        for(Personas p : personas){
            if(p.getNombreUsuario().equals(usuario) && p.getClave().equals(clave)){
                return p;
            }
        }
        return null;
    }
/**
 * Metodo que inicializa el sistema con algunos datos
 */
    public void inicializarSistema(){
        Coordenadas cor1 = new Coordenadas(-2.1538874, -79.9533451);
        Personas per1 = new Proveedor("Juan Perez", "0956847563", "Bosques de la Costa", 
                cor1, "natroram@espol.edu.ec", "juanp01", "juprz0987", "0957428841");
        Coordenadas cor2 = new Coordenadas(-2.1863034, -79.9672112);
        Personas per2 = new Proveedor("Rocio Mera", "0956412873", "Puerto Azul", cor2, 
                "remera@espol.edu.ec", "rmera", "mera254", "0986452317");
        Coordenadas cor3 = new Coordenadas(-2.1511892, -79.9435852);
        Personas per3 = new Proveedor("Maria Mora", "0985412475", "Ceibos Norte", cor3, "natroram@espol.edu.ec", 
        "mamora", "nyttu367", "0754126396");
        
        Coordenadas cor4 = new Coordenadas(-2.1538874, -79.9533451);
        MetododePago pago1 = new PagoPaypal("mercuap", "utipo45");
        Personas comp1 = new Comprador("Rocio Mera", "0936521148", "Bosques de la Costa", 
        cor4, "remera@espol.edu.ec", "marapilc", "signo44", pago1);
        Coordenadas cor5 = new Coordenadas(-2.1511892, -79.9435852);
        MetododePago pago2 = new PagoTarjeta("Visa", "6325124582124578", "Daniel Pachinka","remera@espol.edu.ec" );
        Personas comp2 = new Comprador("Daniel Pachinka", "0865221224", "Ceibos Norte", cor5, "remera@espol.edu.ec", 
        "danipach", "pompo33", pago2);
        
        this.personas.add(per1);
        this.personas.add(per2);
        this.personas.add(per3);
        this.personas.add(comp1);
        this.personas.add(comp2);
        
        Proveedor prov1 = (Proveedor)per1;
        prov1.registrarProductos("001", "Leche Toni chocolate", "Leche Toni con sabor a chocolate. Presentacion personal", 
                "lacteos", 0.75, prov1);
        prov1.registrarProductos("002", "Frijoles Facundo", "Frejoles precocidos en conserva marca Facundo", 
                "vegetales,conservas", 5, prov1);
        prov1.registrarProductos("003", "Yogurt Toni de frutilla", "Yogurt Toni sabor a frutilla, presentacion personal, "
                + "fortificado con lactobacillus GG", "lacteos,frutas,conservas", 1.50, prov1);
        
        Proveedor prov2 = (Proveedor)per2;
        prov2.registrarProductos("004", "Paquete de muslos Mr Pollo", "aaaaaaaaa", "carnicos", 15.0, prov2);
        prov2.registrarProductos("005", "Caja de 24 huevos extra grandes", "aaaaaaaaa", "carnicos,frutas", 18.0, prov2);
        prov2.registrarProductos("006", "Lata de frutas confitadas", "aaaaaaaaa", "frutas,vegetales,conservas", 3, prov2);
        
        Proveedor prov3 = (Proveedor)per3;
        prov3.registrarProductos("007", "Paquete vegetales surtidos", "Inlcuye: brocoli, colifor, zanahoria", "vegetales", 
                10.0, prov3);
        prov3.registrarProductos("008", "Paquete de 100 naranjas", "aaaaaaaaa", "frutas", 20.0, prov3);
        prov3.registrarProductos("009", "Lata de atun Real", "aaaaaaaaa", "conservas,carnicos", 6.0, prov3);
        
    }
    public boolean existeUsuario(String usuario){
        for (Personas p:personas){
            if(p.getNombreUsuario().equals(usuario)){
                return true;
            }


        }return false;

    }


    
    
}
