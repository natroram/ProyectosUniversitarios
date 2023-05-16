/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.espectaculo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import modelo.Funcion;

/**
 *
 * @author rociomera
 */
public abstract class Espectaculo {
    private String codigo;
    private String nombre;
    private ArrayList<Funcion> funciones;
    
    public Espectaculo(String cod, String nombre){
        this.codigo = cod;
        this.nombre = nombre;
        this.funciones = new ArrayList();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
    
    public void agregarFuncion(LocalDateTime fecha, double precio, int capacidad){
        Funcion funcion = new Funcion(fecha, precio, capacidad, this);
        funciones.add(funcion);
    }
    
    public Funcion obtenerFuncion(LocalDateTime fecha){
        for (Funcion f : funciones){
            if (f.getFecha().equals(fecha)){
                return f;
                
            }
        }
        return null;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj != null){
            if(obj instanceof Espectaculo){
                Espectaculo esp = (Espectaculo)obj;
                if(esp.codigo.equals(codigo)){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return codigo+","+nombre;
    }
    
    
}
