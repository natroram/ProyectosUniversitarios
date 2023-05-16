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
public class Persona {
    private int edad;
    private String[] intereses;
    private Coordenada ubicacion;
    
    /*Constructor que define edad, intereses y ubicacion de la clase persona*/
    public Persona(int edad, String[] intereses, Coordenada ubicacion){
        this.edad = edad;
        this.intereses = intereses;
        this.ubicacion = ubicacion;
    }
    
    /*Setter de edad para clase persona*/
    public void Set_edad(int edad){
        this.edad = edad;
    }    
    /*Setter de arreglo intereses para clase persona*/
    public void Set_intereses(String[] intereses){
        this.intereses = intereses;
    }
    /*Setter de ubicacion para clase persona*/
    public void Set_ubic(Coordenada ubicacion){
        this.ubicacion = ubicacion;
    }
    
    /*Getter de edad para clase persona*/
    public int Get_edad(){
        return this.edad;
    }
    /*Getter de arreglo intereses para clase persona*/
    public String[] Get_intereses(){
        return this.intereses;
    }
    /*Getetr de Coordenada ubicacion para clase persona*/
    public Coordenada Get_ubic(){
        return this.ubicacion;
    }
    
}
