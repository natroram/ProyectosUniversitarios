/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ubicacion;

import com.byteowls.jopencage.JOpenCageGeocoder;
import com.byteowls.jopencage.model.JOpenCageForwardRequest;
import com.byteowls.jopencage.model.JOpenCageLatLng;
import com.byteowls.jopencage.model.JOpenCageResponse;
import com.byteowls.jopencage.model.JOpenCageReverseRequest;

/**
 *
 * @author User
 */
public class Geocoding {
    private String direccion;
    private double latitud;
    private double longitud;

    public String getDireccion() {
        return direccion;
    }

    
    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Constructor de la clase Geocoding
     * @param direccion Direccion de la cual se desea saber sus coordenadas de ubicacion
     */
    
    public Geocoding(String direccion){
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("9a9aca071b2944b299fdc3fc531d25f8");
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(direccion);
        
        request.setRestrictToCountryCode("ec");
    
        JOpenCageResponse response = jOpenCageGeocoder.forward(request);
        JOpenCageLatLng firstResultLatLng=null;
            if (response != null && response.getResults() != null && !response.getResults().isEmpty()) {
            JOpenCageLatLng coordinates = response.getFirstPosition();
            //System.out.println(coordinates.getLat().toString() + "," + coordinates.getLng().toString());
            this.latitud = coordinates.getLat();
            this.longitud = coordinates.getLng();
            } else {
            System.out.println("Direccion erronea");
            }
          try {
            Thread.sleep(1000); //
          } catch (InterruptedException e) {
            e.printStackTrace();
        
        
        }
/*        if (response==null){
            throw new NullPointerException("No hay respuesta del API");
        }
        else {
        firstResultLatLng = ;
            if(firstResultLatLng == null){
                throw new NullPointerException("El objeto referido esta vacio");
            }else{
                this.latitud = firstResultLatLng.getLat();
                this.longitud = firstResultLatLng.getLng();
        }
        }*/
    }
    
    /**
     * metodo  para pasar de coordenadas a direccion
     * @param latitud double requerido para el JopenCageReverse
     * @param longitud double requerido para el JopenCageReverse
     * @return String direccion en 
     */
    
    /*public static String Ubicar(double latitud, double longitud){
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder("890eac8e8a7b4ba8960778b0b971c9ed");
        JOpenCageReverseRequest request = new JOpenCageReverseRequest(latitud, longitud);
        request.setLanguage("es"); // prioritize results in a specific language using an IETF format language code
        request.setNoDedupe(true); // don't return duplicate results
        request.setLimit(5); // only return the first 5 results (default is 10)
        request.setNoAnnotations(true); // exclude additional info such as calling code, timezone, and currency
        request.setMinConfidence(3); // restrict to results with a confidence rating of at least 3 (out of 10)
        JOpenCageResponse response = jOpenCageGeocoder.reverse(request);
        // get the formatted address of the first result:
        String formattedAddress = response.getResults().get(0).getFormatted(); 
        return formattedAddress;
    }*/
    
}
