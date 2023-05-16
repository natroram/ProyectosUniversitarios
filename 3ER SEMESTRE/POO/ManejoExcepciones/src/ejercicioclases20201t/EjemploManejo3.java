/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioclases20201t;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author rociomera
 */
public class EjemploManejo3 {
    public static void main(String[] args) {
        System.out.println("Fuera del bloque try");
        try{
            leerArchivo(new File("test.txt"));
            System.out.println("Se termino de leer el archivo");
        }catch(IOException ex){
            System.out.println("Algo ocurrio");
        }
        System.out.println("Fin del programa");
    }
 
    public static void leerArchivo(File file) throws IOException{ 
	RandomAccessFile input = null; 
	String line = null; 
        input = new RandomAccessFile(file, "r"); 
        while ((line = input.readLine()) != null) { 		
                System.out.println(line); 
        }
    }
}
