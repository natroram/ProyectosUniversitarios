package Modelo.Personas;
import java.util.HashMap;

import Modelo.Producto;
import Modelo.Registro;
import Modelo.Infraestructuras.Tienda;
import Modelo.baseDatos.Datos;
public class Vendedor extends Empleado{
	public Vendedor() {
		super();
	}
	
	public static HashMap<String,Vendedor> registroVendedores = new HashMap <>();
	int ingresos=0;
	public Vendedor(String nom, String ced, String tel,
    		String username, String email, String contrasena, int sue,String lug) {
		super(nom,ced,tel,username, email, contrasena, sue, lug);
	}
	
	public int solicitarproducto(Tienda a, Producto b){
		return a.consultarInventario(b);
	// se consulta si el producto solicitado b existe dentro de la tienda a.
	}
	
	public static String crearUsuario(String nombre, String cedula, String telefono,
    		String username, String email, String contrasena, int sue,String lug) {
		Vendedor vend = new Vendedor(nombre,cedula,telefono,username,email,contrasena,sue,lug);
		vend.setUsername(username);
		vend.setEmail(email);
		vend.setContrasena(contrasena);
		
		String [] operations = {"1","2","3","4","5"};
		if(true){
			Datos.vendedors.put(username,vend);
			return "Ha sido creado";
		}else{
			return "No ha sido creado...";
		}
	// el metodo crea un Vendedor vend asignandole los valores correspondientes
	// y llama al menu consola para informarle al usuario en caso de que
	// haya creado un nuevo Vendedor o el caso contrario
	}
	
	public void reportarBalance(Registro a, int ing){
		ing=ingresos;
		a.setIngresos(ing);
	//se añaden ingresos ing al registro a
	}
	
	public int vender(Tienda a, Producto k, int v) {
		return ingresos += a.modificarProducto(k, v);
	}
	
	public Cliente buscarCliente(Cliente a) {
		return a.listaClientes.get(cedula);
		//se recibe un objeto tipo cliente, busca si la cedula del cliente ingresado
		//se encuentra en la lista de clientes, en caso afirmativo devuelve el cliente
		//en caso de que no este esta cedula registrada entonces retorna null
	}			
}
