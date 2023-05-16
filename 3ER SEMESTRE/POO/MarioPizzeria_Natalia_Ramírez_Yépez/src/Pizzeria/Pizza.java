/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pizzeria;

/**
 *
 * @author computron
 */
public class Pizza {
    private TamanioPizza tamanio;
    private int ingredientes;
    
    /**Constructor que recibe tamaño e ingredientes de la pizza*/
    public Pizza(TamanioPizza tamanio, int ingredientes){
        this.tamanio = tamanio;
        this.ingredientes = ingredientes;
    }
    
    /**Constructor que recibe el tamaño de la pizza y pone ingredientes a 2*/
    public Pizza(TamanioPizza tamanio){
        this(tamanio, 2);
    }
    /**Constructor sin parametros*/
    public Pizza(){
        
    }
    /**setter variable tamaño*/
    public void SetTamanio(TamanioPizza tamanio){
        this.tamanio = tamanio;
    }
    
    /**Setter variable ingredientes*/
    public void SetIngred(int ingredientes){
        this.ingredientes = ingredientes;
    }
    
    /**Getter variable tamanio*/
    public TamanioPizza GetTamanio(){
        return this.tamanio;
    }  
    
    /**Getetr variable ingredientes*/
    public int GetIngred(){
        return this.ingredientes;
    }
    
    /**Metodo para obtener costo de la pizza*/
    public int calcularCosto(){
        int base = 0;
        if (tamanio != null){
            switch (tamanio){
                case PEQUENIA:
                    base = 10;
                    break;
                case MEDIANA:
                    base = 12;
                    break;
                case GRANDE:
                    base = 14;
                    break;
                default:
                    base = 0;
                    break;
            }
            return base + (ingredientes*2);
        }
        else{
            return 0;
        }
    }
    
    /**metodo que muestra el tamaño, ingredientes y costo de pizza*/
    public String toString(){
        return "Tamaño: " + tamanio + ", ingredientes: " + ingredientes +
                ", costo: " + calcularCosto();
    }
    
}
