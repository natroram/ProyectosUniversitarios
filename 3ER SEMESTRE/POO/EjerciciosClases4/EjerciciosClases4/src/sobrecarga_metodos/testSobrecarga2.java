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
public class testSobrecarga2 {
    public static void main(String args[]) {
        SobrecargaDemo ob = new SobrecargaDemo();
        int i = 88;
        ob.test();
        ob.test(10, 20);
        ob.test(i); // llama al metodo test(double)
        ob.test(123.2); // llama al metodo test(double)
    }
}
