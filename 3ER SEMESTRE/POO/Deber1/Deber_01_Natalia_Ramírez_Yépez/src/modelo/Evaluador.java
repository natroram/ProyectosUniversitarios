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
public class Evaluador {
    private Persona p1;
    private Persona p2;
    
    public Evaluador(Persona p1, Persona p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    /**
     * retorna veradadero si dos personas tienen al menos un interés en común,
     * la diferencia de edad no es mayor que 10 anios 
     * y viven a no más de 100 km de distancia
     * @return 
     */
    
    public boolean sonCompatibles(){
        //calcular la distancia entre la ubicacion de las dos personas
        //use el metodo calculardistancia de la clase Coordenada
        //recuerde que calculardistancia es estatico. Para llamarlo 
        //usamos el nombre de la clase
        //Coordenada.calcularDistancia( persona1.getCoordena(), persona2.getCoordena());
        double distancia = Coordenada.calcularDistanciaDosPuntos(p1.Get_ubic(), 
                p2.Get_ubic());
        int dif_edad = Math.abs((p1.Get_edad())-(p2.Get_edad()));
        boolean interComun;
        for(String a: p1.Get_intereses()){
            String interes1 = a;
            for(String b: p2.Get_intereses()){
                if (interes1.equalsIgnoreCase(b)){
                        interComun = true;
                        break;
                }
                else{
                    interComun = false;
                }
            }
        }
        if ((distancia <= 100.0) && (dif_edad <= 10) && (interComun == true)){
            return true;
        }
        else{
            return false;
        }
        
        
        
    }
    
    
}
