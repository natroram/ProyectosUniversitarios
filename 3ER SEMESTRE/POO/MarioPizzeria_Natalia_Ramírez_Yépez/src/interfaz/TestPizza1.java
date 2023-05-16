/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Pizzeria.Pizza;
import Pizzeria.TamanioPizza;


public class TestPizza1 {
    public static void main(String[] args){
        Pizza pz0 = new Pizza();
        System.out.println("pz0");
        System.out.println(pz0);

        //creamos una nueva pizza con el constructor que
        //recibe el tamanio y nuero de toppings
        Pizza pz1= new Pizza(TamanioPizza.GRANDE,3);
        System.out.println("pz1");
        System.out.println(pz1);
        
        //creamos nueva pizza con el constructor que recibe tamanio
        //de la pizza y fija el numero de ingredientes a 2
        Pizza pz2 = new Pizza(TamanioPizza.MEDIANA);
        System.out.println("pz2");
        System.out.println(pz2);
        
        //se crea una nueva referencia a pz2
        Pizza pz3 = pz2;
        pz3.SetIngred(5);
        System.out.println("pz2");
        System.out.println(pz2);
        System.out.println("pz3");
        System.out.println(pz3);
    }
}
