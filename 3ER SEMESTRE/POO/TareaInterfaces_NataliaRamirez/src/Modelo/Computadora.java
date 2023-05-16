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
public abstract class Computadora implements HuellaElectrica{
    private int numeroNucleos;

    public Computadora(int numeroNucleos) {
        this.numeroNucleos = numeroNucleos;
    }

    public int getNumeroNucleos() {
        return numeroNucleos;
    }

    public void setNumeroNucleos(int numeroNucleos) {
        this.numeroNucleos = numeroNucleos;
    }
    
    public void printDescription(){
        System.out.println("Computadora");
    }
    
    
}
