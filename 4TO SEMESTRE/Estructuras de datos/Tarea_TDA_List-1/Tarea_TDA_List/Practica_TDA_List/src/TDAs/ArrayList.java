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
public class ArrayList<E> implements List<E>{
    
    private E[] elements; //arreglo donde se harán insercion y remocion de los elementos
    private int effective_size = 0; //indica el tamaño del arreglo (cuantos elementos hay actualmente)
    private int capacity = 100; //indica el tamaño maximo de todos los arreglos al ser instanciados

    public ArrayList() {
        //Java VM no permite instancias arreglos de genericos - unico caso donde se ademite casting
        this.elements = (E[]) new Object[this.capacity];
    }

    @Override
    public boolean addFirst(E e) {
        //se realiza bit shifting - mover los elementos dados por effective_size - validar si hay espacio
        if(isFull()){
            //1. Hacer espacio en arreglo
            addCapacity();
        }
        //2. Iterar para mover los elementos hacia la derecha
        for(int i = effective_size -1; i >= 0; i--){
            //desplazando valores hacia la derecha
            elements[i+1] = elements[i];
        }
        //3. Insertar valor al inicio
        elements[0] = e;
        effective_size++;
        return true;
        
    }

    @Override
    public boolean addLast(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return effective_size;
    }

    @Override
    public boolean isEmpty() {
        return effective_size == 0;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, Object element) {
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
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isFull() {
        return effective_size == capacity;
    }
    
    private void addCapacity() {
        //crear copia de arreglo vacio con doble capacidad inicial
        E[] copy = (E[]) new Object[capacity*2];
        //copiar elementos del arreglo original al vacio
        for(int i = 0; i < effective_size; i++){
            copy[i] = elements[i];
        }
        //reemplazar con copia
        this.elements = copy;
        //actualizar capacidad del nuevo arreglo
        this.capacity = capacity*2;
    }

    @Override
    public Node getPrevious(Node p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
