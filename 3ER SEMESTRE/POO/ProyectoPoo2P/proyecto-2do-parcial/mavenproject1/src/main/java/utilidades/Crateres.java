/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.Objects;
import javafx.scene.shape.Circle;

/**
 *
 * @author nicolepilco
 */
public class Crateres{
    private int idCrater;
    private String nombre;
    private double radio;
    private double latitud;
    private double longitud;
    private boolean visitado;
    private String minerales;
    public Circle circulo;
    
    /**
    * Constructor clase Crateres
    * @param nombre string
    */

    public Crateres(String nombre) {
        this.nombre = nombre;
    }

    /**
    * Constructor clase Crateres
    * @param nombre string
    * @param idCrater int
    * @param radio double
    * @param latitud double
    * @param longitud double
    */
    
    public Crateres(int idCrater, String nombre, double radio, double latitud, double longitud) {
        this.idCrater = idCrater;
        this.nombre = nombre;
        this.radio = radio;
        this.latitud = latitud;
        this.longitud = longitud;
        this.circulo= new Circle(latitud, longitud,radio);
    }
    
    /**
    * Constructor clase Crateres
    * @param latitud double
    * @param longitud double
    */

    public Crateres(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
    public int getIdCrater() {
        return idCrater;
    }

    public String getNombre() {
        return nombre;
    }

    public double getRadio() {
        return radio;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setIdCrater(int idCrater) {
        this.idCrater = idCrater;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String getMinerales() {
        return minerales;
    }

    public void setMinerales(String minerales) {
        this.minerales = minerales;
    }

    public Circle getCirculo() {
        return circulo;
    }

    public void setCirculo(Circle circulo) {
        this.circulo = circulo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        return hash + nombre.hashCode();
    }

    /**
     * Metodo equals clase Crateres
     * Permite verificar si dos Crateres son iguales
     * @param obj recibe el objeto Crateres a comparar
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
        final Crateres other = (Crateres) obj;
        
        return Objects.equals(this.nombre.toLowerCase(), other.nombre.toLowerCase());
    }

    /**
     * Metodo toString() de Crateres
     * @return muestra la informacion detallada de cada Crater
     */
    
    @Override
    public String toString() {
        return "Crateres{" + "idCrater=" + idCrater + ", nombre=" + nombre + ", radio=" + radio + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }
  
}
