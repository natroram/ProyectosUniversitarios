/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas_linkedlist;

/**
 *
 * @author david
 */
public class NodeList<E>{
    private E data;
    private NodeList<E> next, previous;
    
    /**
     * constructor que crea el nodo solo con el contenido
     * @param data 
     */
    public NodeList(E data){
        this.data = data;
        next = previous = null;
    }

    /**
     * 
     * @return retorna el contenido del nodo
     */
    public E getData() {
        return data;
    }

    /**
     * 
     * @param data cambia el contenido
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * 
     * @return retorna el nodo siguiente 
     */
    public NodeList<E> getNext() {
        return next;
    }

    /**
     * 
     * @param next cambia el nodo siguiente 
     */
    public void setNext(NodeList<E> next) {
        this.next = next;
    }

    /**
     * 
     * @return retorna el nodo anterior 
     */
    public NodeList<E> getPrevious() {
        return previous;
    }

    /**
     * 
     * @param next cambia el nodo anterior 
     */
    public void setPrevious(NodeList<E> previous) {
        this.previous = previous;
    }
}
