/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicap2;

import java.util.ArrayList;
import modelo.Persona;

/**
 * Ejemplo de operaciones con ArrayList 
 * @author rociomera
 */
public class Ejercicio5 {
    public static void main(String[] args){
        
        //notacion de diamente -> ponemos el tipo de objeto que queremo
        //alamacenar en el arreglo
        ArrayList<Persona> personas = new ArrayList();
        
        personas.add(new Persona("rocio",1.59));
        personas.add(new Persona("carlos",1.78));
        personas.add(new Persona("alavro",1.72));
        
        //2. mostrar altura promedio de las persona en el arreglo
        
        
        //4. mostrar nombre y altura de la persona mas alta
        
        
    }
    
    /**
     * Encuentra y retorna la altura promedio en una lista de personas.
     * @param p : ArrayList de tipo Persona
     * @return : altura promedio de la personas en la lista
     */
    public static double encontrarPromedioAltura(ArrayList<Persona> lista){
        return 0;
    }
    
    /**
     * Encuentra y retorna la persona mas alta
     * @param p : ArrayList de tipo Persona
     * @return : persona mas alta de la lista
     */
    public static Persona encontrarPersonaMasAlta(ArrayList<Persona> lista){
        //obtenemos el primer elemento de la lista y asumismo que  
        //que esa es la persona de menor altura, a media que iteremos
        //sobre el arreglo p cambiara si encontramos una persona con
        //menor altura
        Persona p = new Persona("",Double.MIN_VALUE);
        
        
        //para que le compilador no se queje retornamos null
        //debe cambiar esto por la persona mas alta
        return null; 
    }
}
