/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicap1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Ejercicio de práctica de clases Wrapper y proceso de boxing y unboxing
 *
 * @author 
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int dato;
        //1. solicitar números enteros y agregarlos a la lista
        while ((numeros.size()) < 10){
            System.out.println("Ingrese numero: ");
            dato = sc.nextInt();
            sc.nextLine();
            numeros.add(dato);
        } 
        //3. llamar el metodo maximoValor y mostrar cual es el
        System.out.println(maximoValor(numeros));
        //valor maximo de la lista
        //5. llamar a la función suma pares y mostrar el valor de la suma
        System.out.println(sumaPares(numeros));
    }

    
    
    /**
     * Encuentre el valor maximo entro los elmentos en la lista
     * pasada como parametro
     * @param lista
     * @return 
     */
    public static int maximoValor(ArrayList<Integer> lista) {
        //la variable valormaximo tendra el maximo valor de la lista
        //inicializamos esta variable con un valor muy muy pequeno para
        //que cualquier otro valor en la lista sea mayor
        int valormaximo = Integer.MIN_VALUE; 
        //recorre la lista de valores
        for (Integer i : lista) {
            //2. completar código para sumar solo los números pares
            //si "i" es mayor que el valor actual en "valormaximo" actualizarlo
            if (i > valormaximo){
                valormaximo = i;
            }
        }
        return valormaximo;
    }
    
    /**
     * Encuentra la suma de los valores pares en el arreglo lista
     * @param lista
     * @return 
     */
    public static int sumaPares(ArrayList<Integer> lista) {
        int sum = 0;//acumulador
        for (Integer i : lista) {
            //4. completar código para sumar solo los números pares
            if ((i%2) == 0){
                sum += i;
            }
        }
        return sum;
    }

}
