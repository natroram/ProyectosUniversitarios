/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkedVsUnchecked;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rociomera
 */
public class UncheckedDemo {
    public static void main(String args[]) {
        try{
            System.out.println("llamo al metod test");
            System.out.println(test(2));
            
            System.out.println("llamo al metod test2");
            System.out.println(test2("HOLA"));
            
            System.out.println("accedo al arreglo");
            int num[] = {1, 2, 3, 4};
            System.out.println(num[5]);
            System.out.println("fin del try");
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("ArrayIndexOutOfBoundsException");
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println("Errorrrr");
            System.err.println(ex.getMessage());
        }
        System.out.println("Final del programa");
    }
    
    public static double test(int divisor){
        int a = 5;
        if(divisor==0){
            throw new ArithmeticException("El argumento no puede ser cero");
        }
        return (a / divisor);
    }
    
    public static String test2(String s) 
            throws Exception{
        if(s == null){
            throw new Exception("La cadena esta vacia");
        }
        return s.toLowerCase();
    }
    
    public static String test3() throws Exception{
        return test2("HOLA");
    }
    
    
}
