/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructoresthis;

import Constructores1.*;

public class Rectangulo {
    double ancho;
    double alto;
    String color;
    //constructor 2
    public Rectangulo(double ancho, double alto, String color){
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }
    //constructor 1 
    public Rectangulo(double ancho, double alto){
        this(ancho,alto,"negro");
    }
    
}

