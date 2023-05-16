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
public class TestEficienciaElectrica {
    
    public static boolean esEficiente(HuellaElectrica e){
        if(e.getEficienciaElectrica() < HuellaElectrica.LIMITECONSUMO){
            return true;
        }
        else{
            return false;
        }
    }
    
}
