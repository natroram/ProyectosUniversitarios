/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.excepciones;

import java.io.IOException;

/**
 *
 * @author rociomera
 */
public class ProblemasConArchivoException extends IOException{
    //String message; -> heredo de exception
    private String nombre_archivo;
    public ProblemasConArchivoException(String nombre_archivo, String msg){
        super(msg);//llamo al constructor de mi clase padre que fija la variable
                    //de instancia message
        this.nombre_archivo = nombre_archivo;
    }
    public String getNombre_archivo(){
        return nombre_archivo;
    }
}
