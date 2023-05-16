/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.espectaculo;

import java.util.ArrayList;

/**
 *
 * @author Natalia Ramirez
 */
public class Teatro extends Espectaculo{
    private ArrayList<String> artistas;
    
    public Teatro(String cod, String nom, ArrayList artistas){
        super(cod, nom);
        this.artistas = artistas;
    }

    public ArrayList<String> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<String> artistas) {
        this.artistas = artistas;
    }
    
    @Override
    public String toString(){
        return "Teatro,"+super.toString();
    }
    
}
