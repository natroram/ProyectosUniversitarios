/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores1;

public class Rectangulo {
    String color;
    double ancho;
    double alto;
   //constructor 1 
    public Rectangulo(double w, double h){
        color = "negro";
        ancho = w;
        alto = h;
    }
    //constructor 2
    public Rectangulo(double w, double h, String colorp){
        color = colorp;
        ancho = w;
        alto = h;
    }
}

