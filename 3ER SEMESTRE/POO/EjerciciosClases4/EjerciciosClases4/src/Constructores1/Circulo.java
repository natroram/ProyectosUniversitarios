/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores1;

/**
 *
 * @author rociomera
 */
public class Circulo {
    public double radio;
    public Circulo(double radio){
        this.radio = radio;
    }
    public double calcularArea(){
        double area = Math.PI * radio * radio;
        return area;
    }
    public double calcularPerimetro(){
        return 2 * Math.PI * radio;
    }
}
