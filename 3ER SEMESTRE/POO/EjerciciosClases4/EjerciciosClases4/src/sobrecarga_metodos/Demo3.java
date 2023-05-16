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
public class Demo3 {
    public static void main(String[] args){
        SobrecargaDemo s = new SobrecargaDemo();
        int i = 5;
        s.test(i); //double
        s.test(2.0); //double
    }
}
