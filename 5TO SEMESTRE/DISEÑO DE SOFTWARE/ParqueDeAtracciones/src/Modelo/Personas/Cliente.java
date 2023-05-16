package Modelo.Personas;
import java.util.HashMap;

import Modelo.Boleta;
import Modelo.baseDatos.Datos;
public class Cliente extends Usuario {	
	public static HashMap	<String,Cliente> listaClientes = new HashMap <>();
	private int saldo= 50000;
	public Cliente() {		
	}
	public Cliente(String nombre, String ced, String tel, 
			String username, String email, String contraseña) {	
		super(nombre,ced,tel,username,email,contraseña);
		Datos.usuarios.put(username,this);
	}	
//	public static void registrar(String nom, String ced, String tel) {
//		Cliente a = new Cliente (nom, ced, tel);
//		if(listaClientes.containsKey(ced) == false) {
//			listaClientes.put(ced, a);
//			//se crea un nuevo cliente si la cedula de este no se encuentra en
//			//la lista de clientes entonces lo agrega a esta en caso contrario no hace nada
//		}
//	}
	
	public static boolean verificarRegistro(String ced) {
		return listaClientes.containsKey(ced);
		//busca el cliente con la cedula ingresada, en caso de encontrarlo devuelve true, 
		//si no lo encuentra devuelve false
	}
	
	public static Boleta comprarBoleta(String ced, String categori){
		if(verificarRegistro(ced) == true) {
			Boleta a= Boleta.crearboleta(categori);			
			if(a.pagodeboleta(listaClientes.get(ced), a) == true) {
				a.pagodeboleta(listaClientes.get(ced), a);
				return a;
			}
			else{
				return null;
			}
			//si la cedula esta registrada se crea una nueva boleta con los parametros proporcionados, luego de esto se hace el pago de la boleta descontando saldo del cliente
			//al que pertenece la cedula ingresada y se asigna este usuario a la boleta creada y se retorna la boleta comprada			
		}
		else {
			return null;
		}
	}
	public int getSaldo() {
		return saldo;
	}
	public static HashMap<String, Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setsaldo(int saldo) {
		this.saldo = saldo;
	}
	public String toString (){
        String mensaje="El empleado se llama "+ getNombre() +" "+" con cedula "+getCedula()+" y telefono  " +
        		getTelefono() + " y un salario de "+ getSaldo();
        return mensaje;
    }
}
