package General;
import Ubicacion.Coordenadas;
import java.util.Objects;

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
    private String numeroIdentificacion;
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
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
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

    public Personas(String nombreUsuario, String clave) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    
    public Personas(String nombre,String numeroIdentificacion,String direccion, Coordenadas ubicacion, String correo_electronico, 
        String nombreUsuario, String clave) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
        this.correo_electronico = correo_electronico;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    public Personas(String nombre, String numeroIdentificacion,String direccion, Coordenadas ubicacion, String correo_electronico 
        ){
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
        this.correo_electronico = correo_electronico;
    }

   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personas other = (Personas) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        return true;
    }
    /**
     * @param args the command line arguments
     */
    
    
}
