package chainOfResponsibility;

import sistema.Producto;

public class Jefe_Inventario implements IHandler{
     private IHandler siguiente = null;
    
    public Jefe_Inventario (IHandler pSiguiente){
        siguiente = pSiguiente;
    }

    @Override
    public boolean cambiar_Producto(Producto producto, String fallo) {
        boolean cambio = false;
        
        //Si el producto existe bodega para reposición y si el precio de venta de producto supera los 1000 USD 
        if(//){
            if(producto.precio>1000){
                cambio = siguiente.cambiar_Producto(producto, fallo);
            }else{
                cambio = true;
            } 
            return cambio;
        }
        
    }
}

