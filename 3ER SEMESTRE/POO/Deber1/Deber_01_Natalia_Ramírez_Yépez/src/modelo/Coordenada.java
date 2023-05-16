/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rociomera
 */
public class Coordenada {
    private double latitud;
    private double longitud;
    public static double RadioTierra = 6378.137;
    
    /** Constructor de clase coordenada que recibe latitud y longitud*/
    public Coordenada(double latitud, double longitud){
        this.latitud = latitud;
        this.longitud = longitud;             
    }
    
    /*Setter de latitud de clase coordenada*/
    public void Set_lat(double latitud){
        this.latitud = latitud;
    }
    
    /*Setter de longitud para clase coordenada*/
    public void Set_long(double longitud){
        this.longitud = longitud;
    }
    /*Getter de latitud de clase coordenada*/
    public double Obtener_lat(){
        return this.latitud;
    }
    
    /*Getter de longitud de clase coordenada*/
    public double Obtener_long(){
        return this.longitud;
    }
    
    /*Metodo que recibe dos objetos de la clase coordenada y calcula la distancia
    entre los dos puntos
    */
    public static double calcularDistanciaDosPuntos(Coordenada c1, Coordenada c2){
        double dif_lat = c2.latitud - c1.latitud;
        double dif_long = c2.longitud - c1.longitud;
        double a = Math.pow(Math.sin(Math.toRadians(dif_lat)/2), 2) + 
                Math.cos(Math.toRadians(c1.latitud))*
                Math.cos(Math.toRadians(c2.latitud))*
                Math.pow(Math.sin(Math.toRadians(dif_long)/2), 2);
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return RadioTierra*c;
    }
    
    
}
