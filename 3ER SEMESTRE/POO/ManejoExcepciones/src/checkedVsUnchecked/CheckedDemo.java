/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkedVsUnchecked;

import java.io.File;
import java.io.FileReader;

/**
 *
 * @author rociomera
 */
public class CheckedDemo {
    public static void main(String args[]) {		
      File file = new File("file.txt");
      //No podre compilar el codigo porque no 
      //he manejado la excepcion que lanza el metodo
      //
      FileReader fr = new FileReader(file); 
                                            
   }
}
