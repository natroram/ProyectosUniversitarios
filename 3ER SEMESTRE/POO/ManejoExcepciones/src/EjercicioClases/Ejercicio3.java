/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

/**
 *
 * @author rociomera
 */
public class Ejercicio3 {
    static String s = "";
    
    public static void main(String[] args) {
    	try { 
            doStuff(args); 
        }catch (IllegalArgumentException  e) { //cmabiar a exception para que la pueda capturar
            s += "e "; 
        }
	s += "x ";
	System.out.println(s);
    }
    
    static void doStuff(String[] args) throws Exception{
    	if(args.length == 0)
            throw new Exception("El arreglo esta vacio");
	s += "d ";
    }
}


/**
 * InputMismatchException - if the next token does not match the Integer regular expression, or is out of range
NoSuchElementException - if input is exhausted
IllegalStateException - if this scanner is closed
public int nextInt() throws InputMismatchException,
                            NoSuchElementException,
                        IllegalStateException{

} 
 
 */

