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
public class NegativeNumberException extends Exception{
    public NegativeNumberException(String s){
        super(s);
    }
    public NegativeNumberException(){
        super("El numero no puede ser negativo");
    }
}
