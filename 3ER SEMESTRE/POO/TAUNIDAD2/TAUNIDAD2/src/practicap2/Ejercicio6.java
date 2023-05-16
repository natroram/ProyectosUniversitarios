/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicap2;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Persona;

/**
 *
 * @author rociomera
 */
public class Ejercicio6 {
    
    //eliminarla del arreglo de personas
    public static void main(String[] args){
        
        //notacion de diamente -> ponemos el tipo de objeto que queremo
        //alamacenar en el arreglo
        ArrayList<Persona> personas = new ArrayList();
        
        personas.add(new Persona("rocio",1.59));
        personas.add(new Persona("carlos",1.78));
        personas.add(new Persona("alavro",1.72));
        
        //2. pedir el nombre de una persona a buscar
        Scanner sc = new Scanner(System.in);
        //String nombre = sc.nextLine();
        
        //Persona p = buscarPorNombre(personas,nombre)
        
        //si el valor devuelto por buscarPorNombre es distintos de null
        //mostrar la altura de esa persona, caso contrario 
        //muestre persona no existe
        
    }
    
    /**
     * Retorna el objeto persona cuyo nombre es igual al parametro n
     * @param lista - lista de personas sobre la que se hara la busqueda
     * @param n - nombre de la persona que se busca
     * @return La persona cuyo nombre es igual a n, null sino existe
     */
    public static Persona buscarPorNombre(ArrayList<Persona> lista, String n){
        
        return null;
    }
}
