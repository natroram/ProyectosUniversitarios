/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sobrecarga_metodos;

/**
 *
 * @author rociomera
 */
public class SobrecargaDemo2 {
    /**
     * Metodo que imprime mensaje Método sin parámetros
     */
    public void test() {
        System.out.println("Método sin parámetros");
    }   
     /** Meodo que recibe dos parametros y los imprime en pantalla
     * @param a
     * @param b 
     */
    void test(int a, int b) {
        System.out.println("a y b: " + a + " " + b);
    }
    /**
     * Medodo que recibe un parametro double, lo imprime en pantalla y retorna su
     * cuadrado
     * @param a
     * @return 
     */
    double test(double a) {
        System.out.println("double a: " + a);
        return a*a; 
    }
}

