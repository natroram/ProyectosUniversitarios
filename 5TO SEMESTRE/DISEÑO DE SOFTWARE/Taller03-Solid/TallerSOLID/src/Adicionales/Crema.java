/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicionales;

/**
 *
 * @author Natalia Ramirez
 */
public class Crema extends Aderezo{
    
    public Crema(){
        super.nombre = "Crema";
    }
    @Override
    void setNombre(String nombre) {
       super.nombre = nombre;
    }
    
}
