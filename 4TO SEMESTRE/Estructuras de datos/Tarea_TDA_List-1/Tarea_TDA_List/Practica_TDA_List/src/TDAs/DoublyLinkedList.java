/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author Natalia Ramirez
 */
public class DoublyLinkedList<E> implements List<E>,Iterable<E>{
    private Node<E> first;
    private Node<E> last;
    private int current;
    
    public int size(){
        return current;
    }
    
    
    @Override
    public Iterator<E> iterator() {
        
        Iterator <E> it = new Iterator<E>() {
            private Node<E> viajero = first;
            @Override
            public boolean hasNext() {
                return viajero!= null;
            }

            @Override
            public E next() {
                E temp = viajero.data;
                viajero= viajero.next;
                return temp;
            }
        };
        return it;
    }
    
    private Node<E> nodeIndex (int index){
        if(isEmpty() || index>= current || index <0 ) return null;
        Node<E> p = first;
        int i=0;
        while (i<index){
            p = p.next;
            i++;
            }
        return p;
    }
    
    public ListIterator<E> listIterator(int index){
        ListIterator<E> it;
        it = new ListIterator<E>() {
            private Node<E> i = nodeIndex(index);
            private int c=index;
            @Override
            public boolean hasNext() {
                return i!=null;
            }

            @Override
            public E next() {
                E temp = i.data;
                i= i.next;
                c++;
                return temp;
            }

            @Override
            public boolean hasPrevious() {
                return i!=null;
            }

            @Override
            public E previous() {
                E temp = i.data;
                i= i.prev;
                c--;
                return temp;
            }

            @Override
            public int nextIndex() {
                return c+1;
            }

            @Override
            public int previousIndex() {
                return c-1;
            }

            @Override
            public void remove() {
                System.out.println("HOLAMUNDO");
                Node<E> temp = i;
                if ( i.next.equals(last)){
                    if (first==last){
                        first.data=null;
                        first=last=null;
                    }
                    else {
                        last.data=null;
                        Node<E> n = last.prev;
                        n.next=null;
                        last.prev=null;
                        last=n;
                    }
                    System.out.println("IF" + i.data);
                }
                else if ( i.equals(first) ) {
                    System.out.println("elseif"+ i.data);
                    first= first.next;
                    first.prev=null;
                    
                }
                else {
                    i.next=i.next.next;
                    i.next.next = i;
                    System.out.println("ELSE" + i.data);
                }
            }

            @Override
            public void set(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(E e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
            public String toString(){
            //if (isEmpty())return "[]";
                StringBuilder sb= new StringBuilder();
                sb.append("[");
                for ( Node<E> nodo=i; nodo!= last;nodo=nodo.next){
                        sb.append(nodo.data);
                        sb.append(",");
                }
                sb.append(last.data);
                sb.append("]");
                return sb.toString();
            }
            
            
            
            
            
        };
    
        return it;
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
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TDAs.Node getPrevious(TDAs.Node p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
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
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;
        public Node (E data){
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }
        
        
    }

    @Override
    public boolean addFirst(E element) {
        if(element==null) return  false;
        Node <E> n = new Node<>(element);
        if(isEmpty()){
            first = last = n;
        }
        else {
            n.next=first;
            first.prev=n;
            first=n;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        if( element == null) return false;
        Node<E> temp = new Node<> (element);
        if (isEmpty()){
            first= last= temp;
        }
        else {
            temp.prev=last;
            last.next=temp;
            last=temp;
        }
        current++;
        return true;
    }

    public boolean add(E element, int index) {
        if (isEmpty() || index>=current || index<0) return false;
        Node <E> n = new Node<>(element);
        Node <E> viajero = first;
        for(int c=1;c<index;c++ ){
            viajero= viajero.next;
        }
        System.out.println(viajero.data);
        n.prev=viajero;
        n.next=viajero.next;
        viajero.next=n;
        
        return true;
    }

    @Override
    public E get(int index) {
        if (isEmpty() || index>current || index<0) return null;
        Node <E> viajero = first;
        for(int c=0;c<index;c++ ){
            viajero= viajero.next;
        }
        return viajero.data;
    }

//    @Override
//    public boolean remove(int index) {
//        if (isEmpty() || index>=current || index<0) return false;
//        
//         if (index == 0)
//            return removeFirst();
//        if (index == current - 1)
//            return removeLast();
//        Node <E> viajero = first;
//        for(int c=0;c<index;c++ ){
//            viajero= viajero.next;
//        }
//        viajero.prev.next = viajero.next;
//        viajero.next.prev = viajero.prev;
//        viajero.next = viajero.prev = null;
//        viajero.data = null;
//        current--;
//        return true;
//    }
    
   /*public boolean remove(int index) {
        if (index < 0 || index >= current)
            return false;
        if (index == 0)
            return removeFirst();
        if (index == current - 1)
            return removeLast();
        int i = 0;
        Nodo<E> f = first;
        while (i != index) {
            f = f.next;
            i++;
        }
        f.previous.next = f.next;
        f.next.previous = f.previous;
        f.next = f.previous = null;
        f.data = null;
        current--;
        return true;
    }*/

    public boolean contains(E element) {
        if (isEmpty()) return false;
        for (Node<E> i= first; i!=null;i=i.next){
            Node <E> n = new Node<>(element);
            if (i.data.equals(n.data) )return true;
        }
        return false;
    }

//    @Override
//    public boolean removeFirst() {
//        if (isEmpty()) return false;
//        first= first.next;
//        first.prev=null;
//        return true ;
//    }
//
//    @Override
//    public boolean removeLast(){
//        if (isEmpty()) return false;
//        if (first==last){
//            first.data=null;
//            first=last=null;
//        }
//        else {
//            last.data=null;
//            Node<E> n = last.prev;
//            n.next=null;
//            last.prev=null;
//            last=n;
//        }
//        current--;
//        return true;
//    }

    public E getFirst() {
        return (E)first.data;
    }

    public E getLast() {
        return (E)last.data;
    }

    @Override
    public boolean isEmpty() {
        return (current==0);
    }
    
    public void reverseArray() {
        reverseArray(first, last);
    }
    
    private void reverseArray (Node<E> low,Node<E> high) {
        if (!(low==high  || low.prev==high)) { 
            E temp= low.data;
            low.data=high.data;
            high.data=temp;
            reverseArray(low.next,high.prev);
        }  
    }
    
      
    /**
     * EJERCICIO 3
     * @return 
     */
    public boolean esPalíndromoRecursivo(){return esPalíndromoRecursivo(first, last);}
    /**
     * 
     * @param left
     * @return 
     */
    private boolean esPalíndromoRecursivo(Node<E> left,Node<E> high){
        if (!left.data.equals(high.data)) 
            return false;
        else if(!(left==high  || left.prev==high)) 
            return esPalíndromoRecursivo(left.next,high.prev);
        return true;
    }
    
    public void removeAllite(E elemento){
        int cont =0;
        for (Node<E> i=first , j=last; i!=j && i.prev!=j ; i=i.next, j=j.prev){
            if ( i.data.equals(elemento) || j.data.equals(elemento) ){
                System.out.println(i.data+ "   "+j.data);
            }
        }
    }
    
    public void removeAll (E element){
        for (int i=0;i<current;i++){
            Node<E> p = nodeIndex(i);
            if ( p.data.equals(element)){
                this.remove(i);
            }
        }
    }
    
    /*public boolean removeAll(){
       if(isEmpty()) return true;
       removeFirst();
       if(!(first==null || last==null) ) {
           removeFirst();
           removeLast();
           removeAll();  
       }
       return true;     
    } */          
        
    
    
    public boolean isReverse(DoublyLinkedList<E> elem){
        return isReverse(elem.first, elem.last,first,last);
    }
    
    private boolean isReverse (Node<E> firste,Node<E> laste,Node<E> first, Node<E> last ){
        if (!first.data.equals(laste.data)  ||  !firste.data.equals(last.data)  ) {
            return false;}
        else if(!(  (first==last  || first.prev==last)|| (firste==laste || firste.prev==laste) )) {
            return isReverse(firste.next,laste.prev,first.next,last.prev);
        }
        return true;
    } 
    
    public DoublyLinkedList<E> slicing(int start,int end){
        DoublyLinkedList<E> result= new DoublyLinkedList<>();
        if(start<0 || end > this.size()-1) return result;
        Node<E> inicio = nodeIndex(start);
        Node<E> fin = nodeIndex(end);
        
        for (Node<E> i=inicio;i!=fin.next;i=i.next){
                result.addLast(i.data);
        }
    return result;
    }
    
    
    // EJERCICIO 6 FALTA
    public  DoublyLinkedList<E> elementosComunes(DoublyLinkedList<Integer> desc){
        DoublyLinkedList<E> result = new DoublyLinkedList<>();
        if (this.size()<desc.size()) {
            for (E e: this) 
                if (desc.contains((Integer)e))
                    result.addLast(e);
        }
        else {
            int n =Integer.MIN_VALUE;
            for (Integer e: desc) 
                if (this.contains((E) e)) {
                    if (e > n){
                        result.addLast((E)e);
                        n = e;
                    }
                    else{
                        result.addFirst((E)e);
                    }
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
    if (isEmpty())return "[]";
    StringBuilder sb= new StringBuilder();
    sb.append("[");
    for ( Node<E> nodo=first; nodo!= last;nodo=nodo.next){
            sb.append(nodo.data);
            sb.append(",");
    }
    sb.append(last.data);
    sb.append("]");
    return sb.toString();
    }
    
    
    public void removeNode (){
        
    
    }
    
    public Map<E,Integer> generateFrequencyTable(){
        Map<E,Integer> mapa = new HashMap<>();
        Set<E> conjunto = new HashSet<>();
        Iterator it = this.iterator();
        while(it.hasNext()){
            conjunto.add((E)it.next());
        }
        mapa.keySet().addAll(conjunto);
        
        for(Entry<E,Integer> entry : mapa.entrySet()){
            Integer value = entry.getValue();
            while(it.hasNext()){
                if(entry.getKey().equals(it.next())){
                    entry.setValue(value++);
                }
            }
        }
        
        return mapa;
    }
}



