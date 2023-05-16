/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.espectaculo;

/**
 *
 * @author rociomera
 */
public class Partido extends Espectaculo{
    private String equipo1;
    private String equipo2;
    
    public Partido(String cod, String nombre, String equipo1, String equipo2){
        super(cod, nombre);
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }
    
    
    @Override
    public String toString(){
        return "Partido," + equipo1 + " VS " + equipo2 + "," + super.toString();
    }
    
    
}
