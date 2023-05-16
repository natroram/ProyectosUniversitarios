/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemonapplication;

/**
 *
 * @author rociomera
 */
public class SimularBatalla {
    public static void main(String[] args){
        //pk1 es una instancia de la clase Pokemon
        Pokemon pk1 = new Pokemon("Pikachu","Pikachu",1200,300); 
        
        //pk1 es una instancia de la clase Pokemon
        Pokemon pk2= new Pokemon("Charizard","cha",1500,350);
        
        System.out.println(pk1.nombre+" ataca "+pk2.nombre);
        pk1.atacar(pk2);
        System.out.println(pk2.nombre+" "+pk2.puntosSalud);
        System.out.println(pk2.nombre+" ataca "+pk1.nombre);
        pk2.atacar(pk1);
        System.out.println(pk1.nombre+" "+pk1.puntosSalud);
        
    }
}
