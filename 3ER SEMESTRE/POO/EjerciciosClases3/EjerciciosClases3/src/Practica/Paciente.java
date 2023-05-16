/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica;

/**
 *
 * @author computron
 */
public class Paciente {
    String nombre;
    int edad;
    String ced;
    char sexo;
    double peso, altura;
    
    public double calcularIMC(){
        double imc;
        imc = peso/(altura*altura);
        return imc;
    }
    
    public String evaluarIMC(){
        double imc = calcularIMC();
        if (imc <= 18.5){
            return "Bajo peso"; 
        }else if (imc > 18.5 && imc <= 24.9){
            return "Ideal";
        }else{
            return "Sobrepeso";
        
        }
                
    }
}
