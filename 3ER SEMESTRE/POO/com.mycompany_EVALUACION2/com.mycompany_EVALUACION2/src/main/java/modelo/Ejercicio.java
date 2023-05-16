/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 * @autor: rociomera
 */
public class Ejercicio {
    private String nombre;
    private int repeticiones;
    private List<String> imagenes;
    
    public Ejercicio(String nombre, int repeticiones, List<String> imagenes){
        this.nombre = nombre;
        this.repeticiones = repeticiones;
        this.imagenes = imagenes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    @Override
    public String toString() {
        return "Ejercicio{" + "nombre=" + nombre + ", repeticiones=" + repeticiones + ", imagenes=" + imagenes + '}';
    }
    
    
}
