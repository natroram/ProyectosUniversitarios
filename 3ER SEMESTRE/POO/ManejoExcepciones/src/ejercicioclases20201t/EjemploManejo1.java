/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioclases20201t;

import java.util.ArrayList;

/**
 *
 * @author rociomera
 */
public class EjemploManejo1 {
    public static void main(String[] args){
        try{
            ArrayList<Integer> numeros = null;
            /*ArrayList<Integer> numeros = new ArrayList<>();
            numeros.add(5);//indice 0
            numeros.add(-8);//inidce 1*/
            double raiz = raizCuadrada(numeros,1);
            System.out.println(raiz);
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Indice fuera de rango");
        }catch(NullPointerException ex){
            System.out.println("el arreglo ha sido inicializado con null");
        }
        System.out.println("Adios");
    }
    
    public static double raizCuadrada(ArrayList<Integer> valores, int indice){
        //Metodo get(int) puede lanzar throw IndexOutOfBoundsException 
        //if the index is out of range (index < 0 || index >= size())
        //                valores(10)
        //     new IndexOutOfBoundsException()
        //     thrown new IndexOutOfBoundsException()
        //     thrown new NullPointerException()
        return Math.sqrt(valores.get(indice));
    }
}
