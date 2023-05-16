package sistema;

import java.util.Date;

public class Garantia {
	private Date inicio;
	private Date fin;
	private Fallo[] fallos_permitidos;
	
	public Garantia(Date inicio, Date fin, Fallo[] fallos_perm) {
		this.inicio = inicio;
		this.fin = fin;
		this.setFallos_permitidos(fallos_perm);
	}

	public Fallo[] getFallos_permitidos() {
		return fallos_permitidos;
	}

	public void setFallos_permitidos(Fallo[] fallos_permitidos) {
		this.fallos_permitidos = fallos_permitidos;
	}
	
	
}
