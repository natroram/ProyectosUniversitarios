/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

import java.io.IOException;
import manejoExcepcionesClase.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import manejoexcepciones.*;

/**
 *
 * @author rociomera
 */
public class Ejercicio2 {
    static void demoCheked() throws IOException{
        System.out.println("dentro demoCheked: ");
        throw new IOException("demoCheked"); //excepcion de tipo checked
    }
    
    static void demoUnchecked() {
        System.out.println("dentro demoUnchecked: ");
        throw new NullPointerException("demoUnchecked");  //excepcion de tipo unchecked
    } 
    
    public static void main(String args[]) {
        try{
            demoCheked();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        demoUnchecked();
        System.out.println("Fin");
    }
}
