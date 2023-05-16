/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

/**
 *
 * @author rociomera
 */
public class EjemploIf {
    /**
     * Programa que determine si un número es o no es, par positivo. 
     * @param args 
     */
    public static void main(String[] args){
        //ejercicio 1
        int numero = 23;
        if (numero%2==0) {
            System.out.println("NUMERO ES PAR");   
        }else {
            System.out.println("NUMERO ES IMPAR");
        }
        
        System.out.println("ADIOS");
    }
}
