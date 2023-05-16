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
public class PowerBand implements Recargable{
    String marca;
    double nivelActual;
    static double cargaMaxima = 500;

    public PowerBand(String marca, double nivelActual) {
        this.marca = marca;
        this.nivelActual = nivelActual;
    }
    
    @Override
    public int getNivelBateria(){
        return (int)nivelActual;
    }
    
    @Override
    public double calcularMinimo(){
        return 50;
    }
    
    
}
