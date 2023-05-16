/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte1;

/**
 *
 * @author rociomera
 */
public class OperadoresRelacionalesyLogicos {
    public static void main(String[] args){
        int a = 20; //declaracion y asiganacion variable a de tipo int
        int b = 10, c = 0; //declaracion de varias variables en la misma linea
        //operadores relaciones
        System.out.println("a == b :" + (a == b));
        System.out.println("a < b :" + (a < b));
        System.out.println("a <= b :" + (a <= b));
        System.out.println("a > b :" + (a > b));
        System.out.println("a >= b :" + (a >= b));
        System.out.println("a != b :" + (a != b));
        
        /*
        //operadores logicos
        int vMin = 0, vMax = 10;
        //operador &&
        boolean resultado1 = a >= vMin && a <= vMax;
        System.out.println("resultado=" + resultado1);
        
        //operador ||
        boolean vacaciones = false;
        boolean diasDescanso = true;
        System.out.println("vacaciones o descanso = " + (vacaciones || diasDescanso));

        // Operador lógico not
        System.out.println("Valor de !vacaciones = " + !vacaciones);*/

        

    }
}
