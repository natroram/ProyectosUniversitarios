/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author rociomera
 */
package pokemonapplication;
public class PokemonAplicacion {
    /**
     * Metodo main que sera el punto de partida de la aplicacion
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creacion de un nuevo objeto de tipo pokemon
        //pk1 es una instancia de la clase Pokemon
        Pokemon pk1 = new Pokemon();
        System.out.println("pk1.mostrarInformacion()");
        pk1.mostrarInformacion();
        
        /*
        //para acceder a las variables del objeto se usa la notacion de punto
        int pc = pk1.puntosCombate;
        System.out.println(pc);*/
        
        /*
        //fijamos el valor la propiedad "especie" del objeto pk1 en "Pikachu"
        pk1.especie = "Pikachu";
        */
        
        
        /*
        //fijamos el valor la propiedad "nombre" del objeto pk1 en "Pikachu"
        pk1.nombre = "Sparky";
        pk1.puntosCombate = 1200;
        pk1.puntosSalud = 100;
        System.out.println("Pokemon 1");
        pk1.mostrarInformacion();
        */
    }
}
