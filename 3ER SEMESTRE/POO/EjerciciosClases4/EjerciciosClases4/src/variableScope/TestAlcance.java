/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variableScope;

/**
 *
 * @author rociomera
 */
public class TestAlcance {
    int x;
    double y;
    public double metodo1(){
        //x hace referencia a la variable de instancia
        //y hace refrencia a la variable de instancia
        int c = 15; //variable local
        return x+y+c;
    }
    public double metodo2(){
        int x; //se declara una variable local llamada x
        x = 5; //se asigna a la variable local el valor de 5
        //no tenemos acceso a c 
        return x+y; //retorna la suma de la variable local 'x' y la 
                    //variable de instancia y
    } 
    public static void main(String[] args){
        TestAlcance t = new TestAlcance();
        t.x = 10;
        t.y = 15;
        System.out.println(t.metodo1()); //cual es la salida
        System.out.println(t.metodo2()); //cual es la salida
    }
}
