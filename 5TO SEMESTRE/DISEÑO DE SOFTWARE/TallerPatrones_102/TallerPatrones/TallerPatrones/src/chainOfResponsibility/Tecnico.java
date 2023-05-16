package chainOfResponsibility;

import sistema.Fallo;
import sistema.Producto;

public class Tecnico implements IHandler{
    private IHandler siguiente = null;
    
    public Tecnico (IHandler pSiguiente){
        siguiente = pSiguiente;
    }

    public boolean cambiar_Producto(Producto producto, Fallo fallo) {
        boolean cambio = false;
        //verificar que el producto se encuentra en periodo de garantía
        if(producto.getGarantia().getFallos_permitidos().contains(fallo)){
            cambio = siguiente.cambiar_Producto(producto, fallo);
        }else{
            return cambio;
        }
    }
    
    
}