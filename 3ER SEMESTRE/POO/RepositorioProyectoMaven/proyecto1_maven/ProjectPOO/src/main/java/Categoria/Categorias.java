/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Categoria;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author User
 */
public enum Categorias {
    CARNICOS,
    VEGETALES,
    FRUTAS,
    LACTEOS,
    CONSERVAS;
    
    private final static Set<String> values = new HashSet<String>(Categorias.values().length);
    
    /**
     * Metodo statico que que agrega los valores del enum a un Set
     */
    
    static{
        for(Categorias cat: Categorias.values())
            values.add(cat.name());
    }
    
    /**
     * Metodo que verifica que si un valor esta o no dentro del enum
     * @param value String que contiene la informacion que se desea verificar
     * @return true si el string esta en el set
     */
    public static boolean contains( String value ){
        return values.contains(value.toUpperCase().trim());
    }
}
