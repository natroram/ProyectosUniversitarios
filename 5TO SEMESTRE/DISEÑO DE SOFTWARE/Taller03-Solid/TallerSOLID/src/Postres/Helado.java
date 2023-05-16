package Postres;

import java.util.ArrayList;
import Adicionales.Aderezo;

/**
 *
 * @author Pedro Mendoza
 */

public class Helado extends Postre {
	
	public Helado(String sabor) {
		super.precioParcial = 7.85;
		super.sabor = sabor;
		super.aderezos= new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return "Helado{" + "sabor=" + sabor + ", precioParcial=" + precioParcial + ", aderezos=" + aderezos + '}';
	}
        
        @Override
        public void addAderezos(Aderezo aderezo){
            super.aderezos.add(aderezo);
        }
        
        @Override
        public void removeAderezo(Aderezo aderezo){
            this.aderezos.remove(aderezo);
        }
}

