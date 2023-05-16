/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte1;

/**
 *
 * @author rociomera
 */
public class OperadoresAritmeticos {
    public static void main(String[] args){
        int a = 20, b = 10, c = 0;
        float d = 20.0f, e = 40.0f, f = 30.0f;
        String x = "Muchas", y = "gracias";

        // Operador + y - 
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        
        // El operador + si se usa con strings
        // concatena las cadenas dadas.
        System.out.println("x + y = " + x + y);
        
        // Operador * y /
        // promoción aritmética el resultado se convierte en float
        System.out.println("a * d = " + (a * d));
        System.out.println("e / b = " + (e / b));
        
        // operador de módulo da el residuo
        // de dividir el primer operando con el segundo
        System.out.println("e % f = " + (e % f));
    }
}
