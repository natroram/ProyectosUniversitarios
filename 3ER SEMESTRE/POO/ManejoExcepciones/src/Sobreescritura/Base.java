/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sobreescritura;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 *
 * @author rociomera
 */
public class Base{
    public void foo(int i) throws IOException, ClassNotFoundException{
        
        System.out.println("foo en Base");
        if(i==1)
            throw new IOException();
        else if (i==2)
            throw new ClassNotFoundException();
        else 
            throw new RuntimeException();
    }
}

class Deri1 extends Base{
    //FileNotFoundException es hija de IOException
    //el metodo sobre-escrito en el hijo no esta obligado a lanzar todas las 
    //excepciones checked listadas en el metodo de la clase padre
    //puedo agregar o quitar unchecked exception de la firma
    public void foo(int i) throws FileNotFoundException, InputMismatchException{
        System.out.println("foo in deri1");
        if(i==1)
            throw new FileNotFoundException();
        else 
            throw new ArithmeticException();
    }
}




