package chainOfResponsibility;

import sistema.Fallo;
import sistema.Producto;

public interface IHandler {

	boolean cambiar_Producto(Producto producto, Fallo fallo);

}
