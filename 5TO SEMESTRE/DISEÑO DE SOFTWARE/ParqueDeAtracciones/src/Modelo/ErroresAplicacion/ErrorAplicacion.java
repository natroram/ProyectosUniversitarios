package Modelo.ErroresAplicacion;

public class ErrorAplicacion extends Exception {
	public ErrorAplicacion() {
		super("Manejo de errores de la Aplicación");
	}
	public ErrorAplicacion(String e) {
		super("Manejo de errores de la Aplicación: " + e);
	}

}
