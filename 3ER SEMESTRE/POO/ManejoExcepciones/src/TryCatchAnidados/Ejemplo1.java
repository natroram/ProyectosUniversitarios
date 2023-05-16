/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TryCatchAnidados;

import java.util.Scanner;

/**
 *
 * @author rociomera
 */
// Ejemplo de bloques try anidados
class NestTry {
    public static void main(String args[]) {
        try {
            Scanner sc = new Scanner(System.in);
            /* Si el usuario ingresa 0 se produciría una excepcion 
               aritmetica por dividir para cero. */
            int a = sc.nextInt(); 
            int b = 42 / a;
            System.out.println("a = " + a);
            try { // bloque try anidado
                /* Si el usuario ingresa 1 se produciría un ArithmeticException. */
                if(a==1){
                    int r = 1 /(a-a); // division para 0
                } 
                    
                /* Si el usuario ingresa 2. */
                if(a==2) {
                    int c[] = { 1 };
                    c[42] = 99; // genera  out-of-bounds exception
                }
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("Array index out-of-bounds: " + e.getMessage());
            }
        } catch(ArithmeticException e) {
            System.out.println("Divide by 0: " + e.getMessage());
        } 
    }
}
