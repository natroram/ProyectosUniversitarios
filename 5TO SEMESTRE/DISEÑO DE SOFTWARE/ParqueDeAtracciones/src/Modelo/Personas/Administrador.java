package Modelo.Personas;

import Modelo.Registro;
import Modelo.ErroresAplicacion.Exception_Contraseña_Invalida;
import Modelo.ErroresAplicacion.Exception_Informacion_Administrador;
import Modelo.ErroresAplicacion.Exception_Usuario_Invalido;
import Modelo.Infraestructuras.Atraccion;
import Modelo.Infraestructuras.Tienda;
import Modelo.Main.Main;
import Modelo.baseDatos.Datos;

public class Administrador extends Empleado {

	public Administrador() {
		super();
	}
	public Administrador(String nom, String ced, String tel,
    		String username, String email, String contrasena, int sue,String lug) {
		super(nom,ced,tel,username, email, contrasena, sue, lug);
		Datos.admins.put(username,this);
	}

	public static String crearUsuario(String nombre, String cedula, String telefono, String tip, String username,
			String email, String contrasena, int sue, String lug) {
		Administrador admin = new Administrador(nombre, cedula, telefono, username, email, contrasena, sue, lug);
		admin.setUsername(username);
		admin.setEmail(email);
		admin.setContrasena(contrasena);

		String[] operations = { "1", "2", "3", "4", "5", "6" };
		if (true) {
			Datos.admins.put(username, admin);
			return "Ha sido creado";
		} else {
			return "No ha sido creado...";
		}
		// el metodo crea un Administrador asignandole los valores correspondientes
		// y llama al menu consola para informarle al usuario en caso de que
		// haya creado un nuevo Administrador o el caso contrario.
	}

//	public int consultar(Registro a, String b){ 
//		//b seria lo que se desea consultar, los ingresos, los gastos o el balance entre ambos
//		if (b.equals("i")) {
//			return a.getIngresos();
//		}
//		else if (b.equals("g")) {
//			return a.getGastos();
//		}
//		else {
//			int i = a.getIngresos();
//			int g = a.getGastos();
//			return i-g;
//		}
//	}

	public Tienda crearTienda(String id, String nom, int gan) {
		return new Tienda(id, nom, gan);
	}

	public Atraccion crearAtraccion(String id, String nom, int gan, int cap, boolean est) {
		return new Atraccion(id, nom, gan, cap, est);
	}

	public static void verificarloginadmin(String username, String contrasena) throws Exception_Informacion_Administrador {
		Usuario u = Usuario.getUsuarioPorUsername(username);
		if (username.equals("") || contrasena.equals("")) {
			throw new Exception_Informacion_Administrador();
		} else {
			Main.usuario = u;
		}
	}
	public static void verificarusuarioadmin(String username) throws Exception_Usuario_Invalido {
        Usuario u = Usuario.getUsuarioPorUsername(username);
        System.out.println(username);
        System.out.println("");
        if (u == null &&  username.equals("")){ 
        	System.out.println("#O:O"); 
        }
        else if(u == null &&  username != ("")) {
        	Main.usuario = u;
        	System.out.println("Estoy es aqui");
        	throw new Exception_Usuario_Invalido();  
        }
        else { 
        	Main.usuario = u;
        	System.out.println("#n2");      	
        }
    }
	 public static void verificarcontrasenaadmin(String username, String contrasena) throws Exception_Contraseña_Invalida {
	        Usuario u = Usuario.getUsuarioPorUsername(username);
	        if (u != null && u.getContrasena().equals("") ) {
	        	Main.usuario = u;
	        	System.out.println("#s1");
	        }
	        else if (u != null && u.getContrasena().equals(contrasena) ) {
	        	Main.usuario = u;
	        	System.out.println("#s4");
	        }
	        else if (u != null && u.getContrasena()!=("")){
	        	System.out.println("#s2");
	        	throw new Exception_Contraseña_Invalida(); 
	        }
	        else {
	        	System.out.println("#s3");
	        	Main.usuario = u;         	         	
	        }
	    }
//	public void asginarcontraseña(){
//		this.crearEmpleado();
//	} 	
}
