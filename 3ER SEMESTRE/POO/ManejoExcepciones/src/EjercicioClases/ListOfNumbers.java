/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioClases;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ListOfNumbers {

    private List<Integer> list;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(i);
        }
    }

    public void writeList() {
        try{
            // El constructro FileWriter puede lanzar una excepcion de tipo IOException .
            BufferedWriter out = new BufferedWriter(new FileWriter("OutFile.txt"));

            for (int i = 0; i < SIZE; i++) {
                // El metodo get(int) puede lanzar una excepcion 
                //de tipo IndexOutOfBoundsException
                System.out.println("Value at: " + i + " = " + list.get(i));
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static void main(String[] args){
        ListOfNumbers l = new ListOfNumbers();
        l.writeList();
        System.out.println("fin del programa");
    }
}
