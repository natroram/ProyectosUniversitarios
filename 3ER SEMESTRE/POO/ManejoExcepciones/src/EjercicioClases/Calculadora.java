/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rociomera
 */
public class Calculadora {
    static Scanner scanner;
    public static void main(String[] args){
        try{
            scanner = new Scanner(System.in);
            division();
        }catch(Exception ex){
            System.out.println("Algo raro ocurrio");
        }
        System.out.println("Fin del programa");
    }
    public static int pedirnumero(String msg){
        boolean continuar = true;
        int valor=0;
        while(continuar){
            try{
                System.out.print(msg);
                //
                valor = Integer.parseInt(scanner.nextLine())  ;//throw java.util.InputMismatchException
                                              //thow IllegalArfumentException
                continuar = false;
            }catch(NumberFormatException ex){
                System.out.println("Debes ingreser un valor solo con numeros");
                //scanner.nextLine();
            }
        }
        return valor;
    }
    public static void division(){
        try{
            int numerator = pedirnumero("Por favor ingrese un entero numerador: ");  		
            int denominator = pedirnumero("Por favor ingrese un entero denominador: ");        
            int result = numerator / denominator;       
            System.out.printf("\nResult: %d / %d = %d\n", numerator, 
                    denominator, result );    
            System.out.printf("Fin del programa");
        }catch(ArithmeticException ex){
            System.out.printf("Operacion invalida");
        }
    }
}
//main()
//   division()
//       pedirNumero()


