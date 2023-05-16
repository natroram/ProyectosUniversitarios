package sistema;

public class Bodega {
	private String ciudad;
	private String provincia;
	private String calle;
	private Producto[] inventario;
	private int id;
	private Sucursal sucursal;
	
	public Bodega(String ciudad, String provincia, String calle, Producto[] inventario, int id, Sucursal sucursal) {
		super();
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.calle = calle;
		this.inventario = inventario;
		this.id = id;
		this.sucursal = sucursal;
	}
	
	public Bodega() {
		
	}
	
	public Producto[] filtrarProductos(String filtro) {
		Producto[] a = {};
		return a;
	}
	
	public boolean verificarProducto(Producto producto) {
		return false;
	}
	
	public void addProducto(Producto producto) {
		
	}
	
	public void removeProducto(Producto producto) {
		
	}
	
	public void editarProducto(Producto producto) {
		
	}
	
}
