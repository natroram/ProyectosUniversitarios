/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

/**
 * Java usa las excepciones para indicar que ocurrio algo inesperado en tiempo 
 * de ejecucion
 * Cuando ocurre algo inesperado
 *    1. Se crea un objeto de tipo de excepcion que tiene la informacion de lo que sucedio
 *    2. Se lanza la lanzo la excepcion
 *    3. Se busca al manejador de la excepcion que que se lanzo - sino se encunetra
 *       ninguno actua el manejador por defecto de java (muestra la excepcion 
 *       ocurrida y termina el programa el forma abrupta)
 * @author rociomera
 */
public class Ejercicio1 {
    public static void main(String []args) {
        try {
            int n = Integer.parseInt("wertyu"); //NumberFormatExcpetion
            int i = 10/n; 
            System.out.println("in try -> ");
        } catch(ArithmeticException ae) {
            System.out.println("in catch -> ");
        } finally {
            System.out.println("in finally -> ");
        } 
        System.out.println("after everything");
    }
    
}


//main()

//test()