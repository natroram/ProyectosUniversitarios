package Procesos;

import java.util.*;
import Adicionales.*;
import Postres.Postre;

public class ManejadorDePrecio {
	private static double precioFinal;

	private static Postre p;
	
	public ManejadorDePrecio(Postre p) {
		this.p = p;
	}
	
	public static double calcularPrecioFinal(Postre p){
        precioFinal= p.getPrecioParcial() + (p.getPrecioParcial()*0.12) + (p.getAderezos().size()*0.50);
        return precioFinal;
        
	}
	
	public static String showPrecioFinal(Postre p){
        return "Precio Final: $ " + calcularPrecioFinal(p);
    }
}
