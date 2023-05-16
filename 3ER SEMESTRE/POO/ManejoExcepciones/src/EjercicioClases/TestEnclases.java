/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rociomera
 */
public class TestEnclases {
    static Scanner sc = new Scanner(System.in);
    
    public static int pedirNumero() throws NegativeNumberException{
        int valor = sc.nextInt();
        if(valor<0)
            throw new NegativeNumberException("Numero menor a 0");
        return valor;
    }
    
    
    
    
    public static void main(String[] args){
        //pedir numeros hasta que no sea cero
        ArrayList<Integer> numerospositivos = new ArrayList<>();
        
        
        System.out.println(numerospositivos);
    }
}
