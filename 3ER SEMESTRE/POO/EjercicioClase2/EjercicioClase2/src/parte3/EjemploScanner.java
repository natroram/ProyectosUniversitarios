/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parte3;
import java.util.Scanner;

/**
 *
 * @author rociomera
 */
public class EjemploScanner {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("cadena:"+cadena);
        int entero = sc.nextInt();
        System.out.println("entero:"+entero);

    }
}
