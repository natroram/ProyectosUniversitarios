/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioclases20201t;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author rociomera
 */
class DivisionDosNumeros {    
    public static void main(String[] args){ 
        
        try{
            Scanner scanner = new Scanner( System.in ); // scanner for input        		
            System.out.print( "Por favor ingrese un entero numerador: " ); 
            int numerator = scanner.nextInt();  //error si el usuario ingresa algo diferente q un nuneo      
            System.out.print( "Por favor ingrese un entero denominador: " ); 			
            int denominator = scanner.nextInt(); //error si el usuario ingresa algo diferente q un nuneo      
            int result = numerator / denominator; //error si el valor del denomindor sea cero      
            System.out.printf("\nResult: %d / %d = %d\n", numerator, denominator, result );    
        }catch(ArithmeticException ex){
            //lo que voy en caso qeu ocurra un ArithmeticException exception
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("El valor del denominador debe np puede ser 0");
        }catch(InputMismatchException ex){
            //lo que voy en caso qeu ocurra un InputMismatchException exception
            //System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Los valores deben ser numerico");
        }catch(Exception ex){
            System.out.println("Algo sucedio");
        }
        
        System.out.printf("Fin del programa");
        
    }
}
