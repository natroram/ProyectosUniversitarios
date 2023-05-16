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
    private String nombre;
    private double altura;
    public Persona(String nombre,double peso){
        this.nombre = nombre;
        this.altura = peso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", peso=" + altura + '}';
    }
    
    //si no defino el metodo equals java lo define por mi
    //y compararia referencias
    /**
     * public boolean equals(Object ob){
     *    return this == ob;
     * }
     */
    
    public boolean equals(Object ob){
        if(ob!=null && ob instanceof Persona){
            Persona p2 = (Persona)ob;
            if(this.nombre.equals(p2.nombre) && 
                    this.altura==p2.altura){
                return true;
            }
        }
        return false;
    }
}

