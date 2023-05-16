/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author rociomera
 */
public class Calculadora{
    //metodo que retorna algo
    public double multiplicar(int cantidad, double valor) {
        //use la setencia return para devolver el resultado
        return cantidad*valor;
    }
    //metodo que no retorna nada
    public void imprimirOperacionesBasicas() {
        //se usa como tipo de dato de retorno void 
        //cuando un metodo no retorna nada y solo imprime en 
        //pantalla 
        System.out.println("Suma");
        System.out.println("Resta");
        System.out.println("Multiplicacion");
        System.out.println("Division");
    }
    
    public static void main(String[] args){
        Calculadora c = new Calculadora();
        c.imprimirOperacionesBasicas();
        double t = c.multiplicar(5,2.0);
        System.out.println(t);
    }
}

