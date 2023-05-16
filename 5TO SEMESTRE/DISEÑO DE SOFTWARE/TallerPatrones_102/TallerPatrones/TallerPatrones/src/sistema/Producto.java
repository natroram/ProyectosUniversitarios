package sistema;

public abstract class Producto {
	private double precio;
	private Bodega bodega;
	private String codigo;
	private Garantia garantia;
	private Comprador comprador;
	
	public Producto(double precio, Bodega bodega, String codigo, Garantia garantia, Comprador comprador) {
		this.precio = precio;
		this.bodega = bodega;
		this.codigo = codigo;
		this.setGarantia(garantia);
		this.comprador = comprador;
	}
	
	public boolean estaEnGarantia() {
		return false;
	}
	
	public boolean verificarGarantia() {
		return false;
	}

	public Garantia getGarantia() {
		return garantia;
	}

	public void setGarantia(Garantia garantia) {
		this.garantia = garantia;
	}
	
	
}
