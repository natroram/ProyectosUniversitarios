package Modelo.Infraestructuras;

public class Atraccion extends Infraestructura{
	private int capacidad;
	private boolean estado;
	public Atraccion(String id,String nom,int gan, int cap,boolean est) {
		super(id,nom);
		capacidad=cap;
		estado=est;	
	}
	
	/*public Atraccion crearAtraccion() {
		return new Atraccion(ID, nombre, ganancias, capacidad, estado);
	}*/
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean e) {
		estado=e;
	}
	public void cerrarAtraccion() {
		estado = false;
	}
	
	public void abrirAtraccion() {
		estado = true;
	}
	
	public boolean consultarEstado() {
		return estado;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public void setCapacidad(int cap) {
		this.capacidad = cap;
	}
	
}