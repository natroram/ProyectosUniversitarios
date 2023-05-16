/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicap1;

import java.util.Random;
import modelo.Persona;

/**
 * 
 * @author rociomera
 */
public class Ejercicio4 {
    public static void main(String[] args){
        
        //se cree un arreglo de tipo Persona con capacidad 
        //de 3 personas inicializadas en null 
        Persona[] personas = new Persona[3];
        System.out.println("valores iniciales en el arreglo");
        mostrar(personas); 
        //rellenar el arreglo
        System.out.println("llenando el arreglo con valores iniciales");
        for(Persona p: personas){
            //lleno todos los elemntos del arreglo con valores al azar
            p = new Persona("",0);
        }
        //mostramos el resultado de realizar la operacion
        System.out.println("desupues de llamar a rellenarArreglo");
        mostrar(personas); 
        
        /*
        System.out.println("modificando las alturas de las personas"
                + "con un valor aleatorio");
        Random r = new Random();
        for(Persona p : personas){
            //r.nextDouble()*100 + 100 -> 
            //genera un valor aleatorio entre 100 y 200
            p.setAltura(r.nextDouble()*100 + 100);
        }
        System.out.println("desupues de llamar a modificarAltura");
        mostrar(personas); */
        
    }
    
    public static void mostrar(Persona[] personas){
        //mostrar el contenido del arreglo
        for(Persona p : personas){
            System.out.println(p);
        }
    }
    
}
