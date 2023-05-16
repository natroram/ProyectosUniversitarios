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
public class EjemploSwitch {
    /**
     * Construir un programa que simule el funcionamiento de una calculadora 
     * que puede realizar las cuatro operaciones aritméticas básicas 
     * (suma, resta, producto y división) con valores numéricos enteros.
     * El usuario debe especificar la operación con el primer carácter del 
     * primer parámetro de la línea de comandos: S o s para la suma, R o r 
     * para la resta, P, p, M o m para el producto y D o d para la división. 
     * Los valores de los operandos se deben indicar en el segundo y tercer 
     * parámetros.
     * @param args 
     */
    public static void main(String[] args){
        String operacion = args[0];
        switch(operacion){
            case "S":
                System.out.println("Suam");
                break;
            case "R":
                System.out.println("Resta");
                break;
            case "M":
                System.out.println("Multiplicacion");
                break;
            case "D":
                System.out.println("Division");
                break;
        }
                
    }
}
