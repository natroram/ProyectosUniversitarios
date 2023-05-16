/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Hp Corporations
 */
public class Pregunta implements Serializable{
    private String texto;
    private List<String> opciones;
    private String respuesta;
    
    public Pregunta(String t, List<String> op, String r){
        texto = t;
        opciones = op;
        respuesta = r;
    }

    public String getTexto() {
        return texto;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public String getRespuesta() {
        return respuesta;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "texto=" + texto + ", opciones=" + opciones + ", respuesta=" + respuesta + '}';
    }
    
    
}
