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
public class Laptop extends Computadora implements Recargable{
    double consumoelectricidad;
    double nivelActual;
    public static double cargaMaxima = 1000;

    public Laptop(double consumoelectricidad, double nivelActual, int numeroNucleos) {
        super(numeroNucleos);
        this.consumoelectricidad = consumoelectricidad;
        this.nivelActual = nivelActual;
    }
    
    @Override
    public void printDescription(){
        System.out.println("Laptop");
    }
    
    public void printDescription(String valor){
        System.out.println(valor);
    }
    
    @Override
    public int getNivelBateria(){
        return (int)nivelActual;
    }
    
    @Override
    public double getEficienciaElectrica(){
        return consumoelectricidad/this.getNumeroNucleos();
    }
    
}
