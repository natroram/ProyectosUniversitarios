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
public class testSobrecarga {
    public static void main(String args[]) {
        SobrecargaDemo ob = new SobrecargaDemo();
        double result;
        // call all versions of test()
        ob.test(); //llama al metodo test sin parametros
        ob.test(10); //lama al metodo test que tiene como parametro un int
        ob.test(10, 20); //llama al metod test que tiene como parametro dos enteros
        result = ob.test(123.25); //llama al metodo test que tiene como paramatro
        System.out.println("Resultado de ob.test(123.25): " + result);
    }
}
