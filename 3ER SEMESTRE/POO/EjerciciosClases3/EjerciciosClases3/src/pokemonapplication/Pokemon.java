/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * clases que reprsenta un pokemon
 * @author rociomera
 */
package pokemonapplication;
public class Pokemon{
    //variables de instancia de la clase
    public String especie;
    public String nombre;
    public int puntosSalud;
    public int puntosCombate; 
    
    /**
     * Metodo que muestra la informacion de un pokemon
     */
    public void mostrarInformacion(){
        System.out.printf("especie: %s\nnombre: %s\n"
                + "puntosSalud: %d\npuntosCombate: %d\n",
                especie,nombre,puntosSalud,puntosCombate);      
    }
    public void saludar(int veces){
        for (int i = 0; i < veces+1; i++){
            System.out.println(nombre);
        }
    }
    public boolean esquivar(){
        double x = (100*Math.random()+1);
        
        return x < 50;  
    }
    
}

