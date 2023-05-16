package Modelo.Infraestructuras;
import java.util.HashMap;

import Modelo.Producto;
import Modelo.Registro;

import java.util.ArrayList;

/**/
public class Tienda extends Infraestructura {
	private double ganancias;
	public HashMap	<Producto,Integer> inventario = new HashMap <Producto,Integer>();
	//Cada tienda tendra una tabla que guardara un producto y su cantidad
	private ArrayList<String> empleados = new ArrayList<>();
	private HashMap<String, Registro> contabilidad = new HashMap<String, Registro>();
	public Tienda(String id, String nom, int gan) {
		super(id, nom);
	}
	
	public void agregarProducto(Producto k, int e) {
		inventario.put(k, e);
		/*Este método recibe dos int, k que es el codigo del producto que se desea agregar y e que es la cantidad que hay de dicho producto
		 *lo que hace es que agrega el producto de código k y su respectiva cantidad e*/
	}
	
	public int consultarInventario(Producto k) {
		return inventario.get(k);
		/*Con este método se busca el producto k y devuelve la cantidad que hay de tal objeto*/ 
	}
	
	public void eliminarProducto(Producto k) {
		inventario.remove(k);
		/*Con este método se elimina el producto de código k del inventario*/ 
	}
	
	public double modificarProducto(Producto k, int v) {
		
		int w = inventario.remove(k);
		w -= v;
		if (w>0) {
			agregarProducto(k, w);
		}
		return v*k.getPrecio();
		/*Se busca y elimina el elemento de código k y se venden v unidades de este luego se agrega con 
		 * la cantidad que queda, al final regresa la cantidad de dinero obtenido por la venta*/
	}
	public double getGanancias() {
		return ganancias;
	}
	public void setGanancias(double ganancias) {
		this.ganancias = ganancias;
	}
	public HashMap<Producto, Integer> getInventario() {
		return inventario;
		//regresa todos los items del inventario
	}
	public void asignarEmpleado(String id) {
		
	}

	public HashMap<String, Registro> getContabilidad() {
		return contabilidad;
	}

	public void setContabilidad(HashMap<String, Registro> contabilidad) {
		this.contabilidad = contabilidad;
	}
	
	
	
}
// Cantidad e del producto k = put (k, e)