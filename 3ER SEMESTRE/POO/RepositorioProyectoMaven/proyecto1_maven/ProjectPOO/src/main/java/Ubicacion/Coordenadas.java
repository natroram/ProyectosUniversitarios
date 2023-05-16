/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ubicacion;

import General.Comprador;
import General.Personas;
import Pago.MetododePago;
import Pago.PagoPaypal;

/**
 *
 * @author User
 */
public class Coordenadas {
        private double latitud,longitud;
        static double Radio_tierra=6378.137;
        
        public Coordenadas(double latitud,double longitud){
            this.latitud=latitud;
            this.longitud=longitud;
        }

        
    @Override
    public String toString() {
        return "Coordenadas:" + "Latitud:\t" + latitud + ", Longitud:\t" + longitud + '}';
    }
        
        
        
        public double getLatitud() {
            return latitud;
        }
        public void setLatitud(double latitud) {
            this.latitud = latitud;
        }
        public double getLongitud() {
            return longitud;
        }
        public void setLongitud(double longitud) {
            this.longitud = longitud;
        }
        /**
         * Calcula la distancia  entre dos personas
         * @param Cliente coordenadas del cliente 
         * @param Proveedor Coordenadas del proveedor
         * @return la distancia en km entre ambas Personas.
         */
        
        
        public static double calcularDistanciaDosPuntos(Coordenadas Cliente,Coordenadas Proveedor){
            
            double dlat=Cliente.latitud-Proveedor.latitud;
            double dlon=Cliente.longitud-Proveedor.longitud;
            double a =Math.pow(Math.sin(Math.toRadians(dlat)/2),2)+
                    Math.cos(Math.toRadians(Cliente.latitud))*
                    Math.cos(Math.toRadians(Proveedor.latitud))*
                    Math.pow(Math.sin(Math.toRadians(dlon)/2),2);
            double c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
            return Radio_tierra*c;
        }
        
}



