/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdas_linkedlist;

import tdas_linkedlist.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 *
 * @author david
 */
public class CircularLinkedList<E> implements List<E>, Iterable<E> {

    private NodeList<E> last;
    private int efectivo;

    /**
     * Constructor sin parámetros de CircularLinkedList
     */
    public CircularLinkedList () {
        last = null;
        efectivo = 0;
    }
    
    /**
     * 
     * @param element elemento que se quiere añadir al inicio de la lista
     * @return retorna boolean el cual es true si se añadio el elemento con exito, caso contrario false
     */
    @Override
    public boolean addFirst (E element) {
        NodeList<E> nodo = new NodeList<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            last = nodo;
            nodo.setNext(nodo);
            nodo.setPrevious(nodo);
        } else {
            nodo.setNext(last.getNext());
            nodo.setPrevious(last);
            last.getNext().setPrevious(nodo);
            nodo.setNext(last.getNext());
            last.setNext(nodo);
        }
        efectivo++;
        return true;
    }

    /**
     * 
     * @param element elemento que se quiere añadir al final de la lista
     * @return retorna boolean el cual es true si se añadio correctamente, caso contrario es false
     */
    @Override
    public boolean addLast(E element) {
        NodeList<E> nodo = new NodeList<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            nodo.setNext(nodo);
            nodo.setPrevious(nodo);
            last = nodo;
        } else {
            nodo.setNext(last.getNext());
            last.getNext().setPrevious(nodo);
            nodo.setPrevious(last);
            last.setNext(nodo);
            last = nodo;
        }
        efectivo++;
        return true;
    }

    /**
     * 
     * @return retorna boolean el cual es true si se pudo remover el primer elemento correctamente, caso contrario es false
     */
    @Override
    public boolean removeFirst () {
        if (isEmpty()) {
            return false;
        }

        NodeList<E> newFirst = last.getNext().getNext();
        last.getNext().setData(null);
        last.getNext().setNext(null);
        last.setNext(newFirst);
        efectivo--;
        return true;
    }

    /**
     * 
     * @return retorna boolean el cual es true si se removió correctamente el último elemento, caso contrario es false
     */
    @Override
    public boolean removeLast () {
        if (isEmpty()) {
            return false;
        }
        if (last.getNext() == last) {
            last.setData(null); 
            last.setNext(last); 
            last = null;
        } else {
            last.setData(null); 
            NodeList<E> prev = last.getPrevious();
            prev.setNext(last.getNext());
            last = prev;
        }
        efectivo--;
        return true;
    }

    /**
     * 
     * @return retorna el valor del primer nodo de la lista, si la lista esta vacía lanza excepción
     */
    @Override
    public E getFirst () {
        if(isEmpty()){
            throw new IllegalStateException("Error: La lista está vacía");
        }
        else{
            return last.getNext().getData();
        }
    }

    /**
     * 
     * @return retorna el valor del último nodo de la lista, si la lista esta vacía lanza excepción
     */
    @Override
    public E getLast () {
        if(isEmpty()){
            throw new IllegalStateException("Error: La lista está vacía");
        }
        else{
            return last.getData();
        }
    }

    /**
     * 
     * @param index entero el cual representa la posición de la lista donde se desea insertar el elemento
     * @param element el elemento que se quiere insertar en una posición específica de la lista
     * @return retorna boolean el cual es true si insertó el elemento en la posición dada correctamente, caso contrario false
     */
    @Override
    public boolean insert (int index, E element) {
        if (index > efectivo || index < 0) {
            throw new IndexOutOfBoundsException("Error: El indice pedido supera el tamaño de la lista");
        }
        if (element == null || isEmpty()) {
            return false;
        }
        if (index == 0) {
            return addFirst(element);
        }
        if (index == efectivo) {
            return addLast(element);
        }
        NodeList<E> nodo = new NodeList(element);
        NodeList<E> prev = getNodo(index - 1);
        NodeList<E> siguiente = prev.getNext();
        prev.setNext(nodo);
        nodo.setNext(siguiente);
        efectivo++;
        return true;
    }

    /**
     * 
     * @param element elemento el cual se quiere saber si está contenido en la lista
     * @return retorna boolean el cual es true si existe al menos un nodo que contiene el elemento dado como valor, caso contrario es false
     */
    @Override
    public boolean contains (E element) {
        NodeList<E> nodo = last.getNext();
        do {
            if (nodo.getData().equals(element)) {
                return true;
            }
            nodo = nodo.getNext();
        } while (nodo != last.getNext());
        return false;
    }
    
    /**
     * 
     * @param index entero que representa posición de índice que se quiere obtener
     * @return retorna nodo ubicado en el índice dado
     */
    public NodeList<E> getNodo(int index) {
        if (index == efectivo - 1) {
            return last;
        }
        NodeList<E> nodo = last.getNext();
        for (int i = 0; i < index; i++) {
            nodo = nodo.getNext();
        }
        return nodo;
    }
    
    /**
     * 
     * @param index entero que representa la posicion en la lista de donde se quiere obtener el valor
     * @return retorna el valor del nodo con posición index en la lista
     */
    @Override
    public E get(int index){
        if (index < 0 || index >= efectivo) {
            throw new IndexOutOfBoundsException("Error: El indice esta fuera del limite de la lista");
        }
        if (index == efectivo - 1) {
            return last.getData();
        } else {
            NodeList<E> nodo = getNodo(index);
            return nodo.getData();
        }
    }
    
    /**
     * 
     * @param element elemento del cual se desea saber su posición en la lista
     * @return retorna un entero el cual es -1  si la lista está vacía o no se encontró el elemento,
     * si el elemento es encontrado devuelve el índica del primer nodo el cual posee ese valor
     */
    @Override
    public int indexOf (E element) {
        if (element == null || isEmpty()) {
            return -1;
        }
        NodeList<E> nodo = last.getNext();
        for (int i = 0; i < efectivo; i++) {
            if (nodo.getData().equals(element)) {
                return i;
            }
            nodo = nodo.getNext();
        }
        return -1;
    }

    /**
     * 
     * @return retorna boolean el cual es true si la lista está vacía, caso contrario false
     */
    @Override
    public boolean isEmpty () {
        return last == null;
    }

    /**
     * 
     * @param index entero que representa la posicion de la lista de la cual se quiere remover el nodo
     * @return retorna boolean el cual es true si el nodo se removió con exito de la posicion, caso contrario es false
     */
    @Override
    public boolean remove (int index) {
        if (index < 0 || index >= efectivo) {
            return false;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == efectivo - 1) {
            return removeLast();
        }

        NodeList<E> nodo1 = getNodo(index - 1);
        NodeList<E> nodo2 = nodo1.getNext();
        nodo2.setData(null);
        nodo2.setNext(null); 

        nodo1.setNext(nodo2.getNext());
        efectivo--;
        return true;
    }

    @Override
    public boolean remove (E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param index entero que representa la posición de la lista en donde se quiere actualizar el valor de un nodo
     * @param element elemento el cual será el nuevo valor del nodo en la posición dada
     * @return retorna boolean el cual es true si se actualizó con éxito el valor del nodo en la posición 
     * dada, caso contrario es false
     */
    @Override
    public boolean set (int index, E element) {
        if (element == null) {
            return false;
        }
        if (index >= efectivo || index < 0) {
            throw new IndexOutOfBoundsException("Indice fuera del limite");
        }
        if (index == efectivo - 1) {
            last.setData(element);
        } else {
            NodeList<E> nodo = getNodo(index);
            nodo.setData(element);
        }
        return true;
    }

    /**
     * 
     * @return devuelve entero el cual representa el tamaño de la lista 
     */
    @Override
    public int size () {
        return efectivo;
    }

    /**
     * @param index
     * @return 
     */
    public ListIterator<E> listIterator (int index) {
        if(last == null || index > efectivo)
            return null;
        
        ListIterator<E> it;
        it = new ListIterator<E>() {

            private NodeList<E> p = jump();
            private NodeList<E> p2=jump2();
            private int currentIndex = index;
            
            private NodeList<E> jump(){
                NodeList<E> nodoSalto = last.getNext();
                for(int i= 0; i !=index; i++){
                    nodoSalto = nodoSalto.getNext();
                }
                return nodoSalto;
            }
            
            private NodeList<E> jump2(){
                NodeList<E> nodoSalto = last.getPrevious();
                for(int i= 0; i !=index; i++){
                    nodoSalto = nodoSalto.getPrevious();
                }
                return nodoSalto;
            }
            
            @Override
            public boolean hasNext () {
                return currentIndex < efectivo;
            }

            @Override
            public E next () {
                E tmp = p.getData();
                p = p.getNext();
                currentIndex++;
                return tmp;
            }

            @Override
            public boolean hasPrevious () {
                return currentIndex > 0;
            }

            @Override
            public E previous () {
                E tmp = p2.getData();
                p2 = p2.getPrevious();
                currentIndex --;
                return tmp;
            }

            @Override
            public int nextIndex () {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int previousIndex () {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remove () {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void set (E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add (E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        return it;
    }

     @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>(){
            
            private NodeList<E> p = last.getNext();
            private int currentIndex = 0;

            @Override
            public boolean hasNext () {
                return currentIndex < efectivo;
            }

            @Override
            public E next () {
                E tmp = p.getData();
                p = p.getNext();
                currentIndex++;
                return tmp;
            }
        };
        
        return it;
    }
}