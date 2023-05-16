/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author Natalia Ramirez
 */
public class LinkedList<E> implements List<E> {
    
    private Node<E> first; //referencia linkeada al primer elemento del list
    private Node<E> last; //referencia linkeada al ultimo elemento del list
    private int size; //se actualiza al añadir o remover elementos (opcional)

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    @Override
    public boolean addFirst(E e) {
        Node<E> nuevo = new Node<>(e);
        
        if(isEmpty()){
             first = nuevo;
             last = nuevo;
         }
        else{
            nuevo.setNext(first);
            first = nuevo;
        }
        return true;
    }

    @Override
    public boolean addLast(E e) {
         Node<E> nuevo = new Node<>(e);
         
         if(isEmpty()){
             first = nuevo;
             last = nuevo;
         }
         else{
            last.setNext(nuevo);
            last = nuevo;
         }
         return true;
    }

    @Override
    public E removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        int count = 0;
        //para el for inicializar un nodo que apunta al first (nodo viajero)
        for(Node<E> p = first; p != null ;p = p.getNext()){
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null; 
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node getPrevious(Node p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

