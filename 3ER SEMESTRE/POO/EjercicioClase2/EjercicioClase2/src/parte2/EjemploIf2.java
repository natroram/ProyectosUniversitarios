/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte2;

/**
 *
 * @author rociomera
 */
public class EjemploIf2 {
    /**
     * Programa que recibe la nota de un examen 
     * (un número entero entre 0 y 10) e imprime por pantalla la calificación
     * en formato 
     * “Reprueba”, si la nota es menor que  5,
     * “Aprobado” si esta entre 5 y 7 sin incluirlo, 
     * “Notable” si esta entre 7 y 9 sin incluirlo,  
     * “Sobresaliente” si esta entre 9 y 10 sin incluirlo y
     * “Excelente”  si la nota es igual a 10*/
    public static void main(String[] args){
        double nota = 8;
        if (nota < 5) {
            System.out.println("La nota es :" + nota + " , reprueba");
        } else if (nota >=5 && nota < 7) {
            System.out.println("La nota es :" + nota + " , aprobado");
        } else if (nota >= 7 && nota < 9) {
            System.out.println("La nota es :" + nota + " , notable");
        } else if (nota >= 9 && nota < 10) {
            System.out.println("La nota es :" + nota + " , sobresaliente");
        } else if (nota == 10) {
            System.out.println("La nota es :" + nota + " , excelente");
       } else {
            System.out.println("La nota está fuera de rango");
       }

    }
}
