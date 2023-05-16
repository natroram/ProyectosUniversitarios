/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.excepciones;

/**
 *
 * @author Natalia Ramirez
 */
public class NoHayFondosExcepcion extends Exception{
    
    public NoHayFondosExcepcion(){
        
    }
    
    public NoHayFondosExcepcion(String mensaje){
        super(mensaje);
    }
}
