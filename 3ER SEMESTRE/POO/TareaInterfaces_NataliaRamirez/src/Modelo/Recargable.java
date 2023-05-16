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
public interface Recargable {
    
    public abstract int getNivelBateria();
    
    default double calcularMinimo(){
        return 100;
    }
    
    static double calcularPorcentaje(double nivelactual, double nivelMaximo){
        return nivelactual/nivelMaximo;
    }
    
}
