/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.espectaculo;

/**
 *
 * @author Natalia Ramirez
 */
public class Concierto extends Espectaculo{
    private String banda;
    
    public Concierto(String codigo, String nombre, String banda){
        super(codigo, nombre);
        this.banda = banda;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
    
    
    @Override
    public String toString(){
        return "Concierto,"+banda+super.toString();
    }
    
    
}
