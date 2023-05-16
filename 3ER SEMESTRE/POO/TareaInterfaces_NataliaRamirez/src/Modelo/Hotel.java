/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Natalia Ramirez
 */
public class Hotel implements HuellaElectrica, Comparable{
    int numhuespedes;
    double consumoelectricidad;

    public Hotel(int numhuesped, double consumoelectricidad) {
        this.numhuespedes = numhuesped;
        this.consumoelectricidad = consumoelectricidad;
    }
    
    @Override
    public double getEficienciaElectrica(){
        return consumoelectricidad/numhuespedes;
    }
    
    @Override
    public int compareTo(Object o){
        int comp = -2;
        if(o instanceof Hotel){
            Hotel h = (Hotel)o;
            if(h.numhuespedes > numhuespedes){
                comp = -1;
            }
            else if(h.numhuespedes < numhuespedes){
                comp = 1;
            }
            else{
                comp =  0;
            }
        }
        return comp;
    }

    @Override
    public String toString() {
        return "Hotel: " + "numhuespedes=" + numhuespedes + ", consumoelectricidad=" + consumoelectricidad;
    }
    
    
}
