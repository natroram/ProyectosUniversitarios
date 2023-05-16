package General;
import Ubicacion.Coordenadas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Personas {
    private String nombre;
    private int numeroIdentificacion;
    private String direccion; 
    private Coordenadas ubicacion;// (coordenadas lat y longitud):
    private String correo_electronico;
    private String nombreUsuario;
    private String clave;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Coordenadas getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Coordenadas ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public Personas() {
    }
    
    
    public Personas(String nombre,int númeroIdentificación,String dirección, Coordenadas ubicación, String correo_electrónico, 
        String nombreUsuario, String clave) {
        this.nombre = nombre;
        this.numeroIdentificacion = númeroIdentificación;
        this.direccion = dirección;
        this.ubicacion = ubicación;
        this.correo_electronico = correo_electrónico;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    public Personas(String nombre,int númeroIdentificación,String dirección, Coordenadas ubicación, String correo_electrónico 
        ){
        this.nombre = nombre;
        this.numeroIdentificacion = númeroIdentificación;
        this.direccion = dirección;
        this.ubicacion = ubicación;
        this.correo_electronico = correo_electrónico;
    }
    /**
     * @param args the command line arguments
     */
    
    
}
