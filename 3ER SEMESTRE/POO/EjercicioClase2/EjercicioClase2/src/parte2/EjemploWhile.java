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
public class EjemploWhile {
    public static void main(String[] args){
        int n =  234;
        System.out.println("El numero es " + n);
        int cantidad = 0;
        while (n > 0) {
            n = n/10;
            cantidad++;
        }
        System.out.println("La cantidad de digitos que tiene es " + cantidad);

    }
}
