/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primitivovsreferencia;

import pokemonapplication.Pokemon;

/**
 *
 * @author rociomera
 */
public class referencia {
    public static void main(String[] args){
        Pokemon pk1 = new Pokemon(); //pk es una varaiable de tipo referencia
        pk1.especie = "Pikachu";
        Pokemon pk2 = new Pokemon(); //pk es una varaiable de tipo referencia
        pk2.especie = "Charizard";
        
        System.out.println("pk1");
        pk1.mostrarInformacion();
        System.out.println("pk2");
        pk2.mostrarInformacion();
        
        /*
        //NO se crea un nuevo objeto
        //se copia en pk4 la refencia que esta en pk1
        Pokemon pk4 = pk1;
        System.out.println("pk4");
        pk4.mostrarInformacion();*/
        
        /*
        //pk1 y pk4 almacenan la misma referencia
        System.out.println(pk1);
        System.out.println(pk4);
        */
        
        /*
        pk4.nombre = "pika pika"; 
        System.out.println("pk1.nombre: "+pk1.nombre);
        System.out.println("pk4.nombre: "+pk4.nombre);
        */

        
        
    }
}
