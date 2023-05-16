/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import modelo.Coordenada;
import static modelo.Coordenada.calcularDistanciaDosPuntos;

/**
 *
 * @author computron
 */
public class TestCoordenada {
    public static void main(String[] args){
        Coordenada c1 = new Coordenada(-2.1326226, -79.948085);
        Coordenada c2 = new Coordenada(-2.1939161, -79.8886304);
        double distancia = calcularDistanciaDosPuntos(c1, c2);
        System.out.println("La distancia entre c1 y c2 es: " + distancia);
        
    }
    
}
