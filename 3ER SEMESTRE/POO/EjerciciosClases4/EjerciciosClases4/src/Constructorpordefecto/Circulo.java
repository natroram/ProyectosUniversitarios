/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructorpordefecto;

import Constructores1.*;

/**
 *
 * @author rociomera
 */
public class Circulo {
    public double radio;
    public double calcularArea(){
        double area = Math.PI * radio * radio;
        return area;
    }
    public double calcularPerimetro(){
        return 2 * Math.PI * radio;
    }
}
