/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import modelo.espectaculo.Espectaculo;

/**
 *
 * @author rociomera
 */
public class Funcion {
    private LocalDateTime fecha;
    private double precio;
    private int capacidad;
    private Espectaculo espectaculo;
    
    public Funcion(LocalDateTime fecha, double precio, int capacidad, Espectaculo
            e){
        this.fecha = fecha;
        this.precio = precio;
        this.capacidad = capacidad;
        this.espectaculo = e;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }

    public void setEspectaculo(Espectaculo espectaculo) {
        this.espectaculo = espectaculo;
    }
    
    @Override
    public String toString(){
        String dateFormatter= "dd-MM-yyyy HH:mm";
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern(dateFormatter);
        return "Fecha y hora: "+formatter.format(fecha)+ "Precio: "+ precio+ "Capacidad: "+capacidad;
        
    }
    
    @Override
    public boolean equals(Object obj){
      if (obj != null){
        if (obj instanceof Funcion){
            //downcasting
            Funcion funcion = (Funcion)obj;
            if(funcion.espectaculo.equals(espectaculo) && funcion.fecha.equals(fecha)){
                return true;
            }
        }
      }
      return false;
    }
}
