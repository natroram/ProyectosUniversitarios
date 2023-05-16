package Postres;

import java.util.ArrayList;
import Adicionales.Aderezo;

/**
 *
 * @author Pedro Mendoza
 */

public class Pastel extends Postre {
	
	public Pastel(String sabor) {
		super.precioParcial = 15.55;
		super.sabor = sabor;
		super.aderezos = new ArrayList<>();
	}
	
        @Override
	public String toString() {
		return "Pastel{" + "sabor=" + sabor + ", precioParcial=" + precioParcial + ", aderezos=" + aderezos + '}';
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

