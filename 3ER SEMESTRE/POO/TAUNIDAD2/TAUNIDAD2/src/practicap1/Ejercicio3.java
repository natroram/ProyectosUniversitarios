/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicap1;

/**
 * 
 * @author 
 */

//1.- Revisa el códgo y predice cuál será la salida
//2.- Ejecuta el código y compara las respuestas. Existió algún proceso de autoboxing?
//3.- Comenta el método writeValue(int a, double b).
//4.- Ejecuta el código y reflexiona acerca de la salida obtenida
public class Ejercicio3 {
    public void writeValue(int a, byte b) {
        System.out.println("int byte " + a +","+ b);
    }
    public void writeValue(int a, short b) {
        System.out.println("int short" + a +","+ b);
    }
    public void writeValue(int a, Integer b) {
        System.out.println("int integer " + a +","+ b);
    }
    public void writeValue(int a, double b) {
        System.out.println("int double " + a +","+ b);
    }
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        Integer c = 5;
        
        new Ejercicio3().writeValue(a, b);
        
        new Ejercicio3().writeValue(a, c);
    }
}
