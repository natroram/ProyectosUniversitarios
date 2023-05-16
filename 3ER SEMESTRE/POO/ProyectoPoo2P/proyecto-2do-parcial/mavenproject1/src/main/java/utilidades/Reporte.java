/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author nicolepilco
 */
public class Reporte implements Comparable<Reporte>{
    public LocalDate fechaExploracion;
    public String nombre;
    public String mineral;
    
    

     /**
    * Constructor clase Crateres
    * @param nombre String
    * @param fechaExploracion LocalDate
    * @param minerales String
    */
    
    public Reporte(LocalDate fechaExploracion, String nombre, String minerales) {
        this.fechaExploracion = fechaExploracion;
        this.nombre = nombre;
        this.mineral = minerales;
    }

    public LocalDate getFechaExploracion() {
        return fechaExploracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMineral() {
        return mineral;
    }

    public void setFechaExploracion(LocalDate fechaExploracion) {
        this.fechaExploracion = fechaExploracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMineral(String mineral) {
        this.mineral = mineral;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Metodo equals clase Reporte
     * Permite verificar si dos Reportes son iguales
     * @param obj recibe el objeto Reporte a comparar
     * @return true si tienen el mismo codigo
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reporte other = (Reporte) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.mineral, other.mineral)) {
            return false;
        }
        if (!Objects.equals(this.fechaExploracion, other.fechaExploracion)) {
            return false;
        }
        return true;
    }

    
    /**
     * Metodo toString() de Reporte
     * @return muestra la informacion detallada de cada reporte
     */
    
    @Override
    public String toString() {
        return "Reporte{" + "fechaExploracion=" + fechaExploracion + ", nombre=" + nombre + ", mineral=" + mineral + '}';
    }
    

    /**
     * Metodo compareTo() de Reporte
     * compara cada cadena y devuelve un entero dependiendo cual es es lexicográficamente el primero
     * Si el entero que devuelve es mayor a cero el valor pasado como parametro va antes.
     * @return int indice
     */
    
    @Override
    public int compareTo(Reporte o) {
        return this.getNombre().compareToIgnoreCase(o.getNombre());
    }
}
