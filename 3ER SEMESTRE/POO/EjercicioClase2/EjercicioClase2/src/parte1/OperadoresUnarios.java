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
public class OperadoresUnarios {
    public static void main(String[] args){
        int a = 20, b = 10, c = 0;
        
        // operador de pre-incremento
        // a = a+1 y entonces c = a;
        c = ++a;
        System.out.println("Valor de c (++a) = " + c);
        // operador de post-incremento
        // c=b entonces b=b+1 (b pasa a ser 11)
        c = b++;
        System.out.println("Valor de c (b++) = " + c);
        // operador de pre-decremento
        // a=a-1 entonces c=a
        c = --a;
        System.out.println("Valor de c (--a) = " + c);
        // operador de post-decremento
        // c=b entonces b=b-1 (b pasa a ser 39)
        c = b--;
        System.out.println("Valor de c (b--) = " + c);

    }
}
