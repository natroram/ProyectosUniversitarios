/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;
import java.util.LinkedList;//borra esto al terminar
/**
 *
 * @author F. Lopez
 */
public class Nodo<T,K> {
    private T valor;
    private K clave;
    private LinkedList<Arbol> children;
    
    public Nodo(T content,K clav){
        this.valor=content;
        this.children=new LinkedList();
        clave=clav;
    }
    
    public void setValor(T val){
        valor=val;
    }
    public void setClave(K clav){
        clave=clav;
    }
    public T getValor(){
        return valor;
    }
    public K getClave(){
        return clave;
    }
    public void setHijos(LinkedList<Arbol> hijos){
        children = hijos;
    }
    public int getCantHijos(){
        return children.size();
    }
    public LinkedList<Arbol> getHijos(){
        return children;
    }
    
    public void AddHijo(Arbol<T,K> hijo){
        children.addLast(hijo);
    }
    
    
    
    
}
