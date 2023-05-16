package Postres;

import java.util.ArrayList;

import Adicionales.Aderezo;
import Procesos.*;

public abstract class Postre {
	protected ArrayList<Aderezo> aderezos;
	protected double precioParcial;
	protected String sabor;
	

	public ArrayList<Aderezo> getAderezos() {
        return aderezos;
    }
	
	public double getPrecioParcial() {
		return this.precioParcial;
	}
	
	public String getSabor() {
		return this.sabor;
	}
        
        public void addAderezos(Aderezo aderezo){
            this.aderezos.add(aderezo);
        }
        
        public void removeAderezo(Aderezo aderezo){
            this.aderezos.remove(aderezo);
        }
}
