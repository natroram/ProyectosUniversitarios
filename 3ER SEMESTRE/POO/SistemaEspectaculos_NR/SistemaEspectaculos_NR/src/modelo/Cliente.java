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
public class Cliente {
    private String nombre;
    private String cedula;
    public Cliente(String nombre, String cedula){
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", cedula=" + cedula + '}';
    }

    /**
     * retorna verdadero si deos clientes son iguales
     * dos clientes son iguales si tienen la misma cedula
     * @param obj
     * @return 
     */
    public boolean equals(Object obj){
        if(obj!=null){
            if(obj instanceof Cliente){
                Cliente c = (Cliente)obj;
                if(c.getCedula().equals(cedula)){
                    return true;
                }
            }
        }
        return false;
    }
    
}
