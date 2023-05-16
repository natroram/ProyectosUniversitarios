package Modelo.Personas;

import java.util.HashMap;

import Modelo.ErroresAplicacion.Exception_Contraseña_Invalida;
import Modelo.ErroresAplicacion.Exception_Informacion_Administrador;
import Modelo.ErroresAplicacion.Exception_Informacion_Usuario;
import Modelo.ErroresAplicacion.Exception_Usuario_Invalido;
import Modelo.Main.*;
import Modelo.baseDatos.Datos;

public class Usuario extends Persona{
	protected static String username;
	protected String email;
	protected String contrasena;
	
	
	public Usuario() {
	}

	public Usuario(String nombre, String ced, String tel, 
			String username, String email, String contraseña) {
		super(nombre,ced,tel);
		this.username = username;
		this.email = email;
		this.contrasena = contraseña;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
//	public static String nuevoUsuario(String nombre, String username, String email, String contraseña){
//		Usuario user = new Usuario();
//		user.setNombre(nombre);
//		user.setUsername(username);
//		user.setEmail(email);
//		user.setContrasena(contraseña);
//
//		String [] operations = {"5"};
//		MenuDeConsola.nuevoMenu(user, operations);
//		if(true){
//			Datos.usuarios.put(username,user);
//			return "Ha sido creado";
//		}else{
//			return "No ha sido creado...";
//		}
//	// el metodo crea un Usuario user asignandole los valores correspondientes
//	// y llama al menu consola para informarle al usuario en caso de que
//	// haya creado un nuevo Usuario o el caso contrario
//	}
	public static String editarUsuario(Usuario u,int option, String value){
		switch (option) {
		case 1:	
			u.setNombre(value);
			return "Nombre modificado";
		case 2:
			u.setContrasena(value);
			return "Contraseña modificada";
		default:
			return "Opcion no valida";
		}
	// el metodo permite a un Usuario u el poder cambiar su nombre o contraseña por un 
	// String value elegiendo entre opciones 1 y 2 con option.
	}
	
	public static String borrarUsuario(String username){
		Datos.usuarios.remove(username);
		return "Ha sido eliminado";
	// el metodo permite
	}
	
	public static Usuario getUsuarioPorUsername(String username){
		if(Datos.admins.containsKey(username)) {return Datos.admins.get(username);}
		if(Datos.operarios.containsKey(username)) {return Datos.operarios.get(username);}
		if(Datos.vendedors.containsKey(username)) {return Datos.vendedors.get(username);}
		if(Datos.usuarios.containsKey(username)) {return Datos.usuarios.get(username);}
		return null;
    }
	
    public static void verificarlogin(String username, String contrasena) throws Exception_Informacion_Usuario {
        Usuario u = Usuario.getUsuarioPorUsername(username);        
        if (username.equals("") || contrasena .equals("")){
        	throw new Exception_Informacion_Usuario();
        }
        else {
        	Main.usuario = u;          	
        }
    }
    public static boolean login (String username, String contrasena)  {
        Usuario u = Usuario.getUsuarioPorUsername(username);
        if (u != null){
            if(u.getUsername().equals(username) && u.getContrasena().equals(contrasena)){
            	Main.usuario = u;
                return true;
            }
        }
        return false;       
    }
    public static void verificarcontrasena(String username, String contrasena) throws Exception_Contraseña_Invalida {
        Usuario u = Usuario.getUsuarioPorUsername(username);     
        if (u != null && u.getContrasena().equals("") ) {
        	Main.usuario = u;
        }
        else if (u != null && u.getContrasena().equals(contrasena) ) {
        	Main.usuario = u;
        }
        else if (u != null && u.getContrasena()!=("")){
        	throw new Exception_Contraseña_Invalida(); 
        }
        else {
        	Main.usuario = u;         	         	
        }
    }
    public static void verificarusuario(String username) throws Exception_Usuario_Invalido {
        Usuario u = Usuario.getUsuarioPorUsername(username);
        System.out.println(username);
        if (u == null &&  username != ("")){ 
        	throw new Exception_Usuario_Invalido();  
        }
        else if(u == null  ){
        	Main.usuario = u;
        }
        else { 
        	Main.usuario = u;     	
        }
    }
    public static void signOut(){
    	Main.usuario = null;
    }
}
