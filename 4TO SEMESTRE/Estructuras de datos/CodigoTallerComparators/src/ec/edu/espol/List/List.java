package ec.edu.espol.List;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jocellyn Luna
 */


public interface List <E> extends Iterable<E> {
    
   boolean addFirst(E element);
   boolean addLast(E element);
   boolean removeFirst();
   boolean removeLast();
   E getFirst();
   E getLast();
   boolean insert(int index, E element);
   boolean contains(E element);
   E get(int index);
   int indexOf(E element);
   boolean isEmpty();
   E remove(int index);
   boolean remove(E element);
   E set(int index, E element);
   int size();
   
   // encuentra todos los objetos dentro de la lista
   // que comparten un criterio con element.
   // El cumplimiento de ese criterio, es verificado por el 
   // comparador cmp
   public List<E> findAll (Comparator<E> cmp, E element);
   
   /*encuentra todos los objetos de la lista que sean menores al elemento dado*/
   public List<E> findLowerThan(Comparator<E> cmp, E element);
   
   /*encuentra los elementos de la lista que son mayores al elemento dado*/
   public List<E> findGreaterThan(Comparator<E> cmp, E element);
   
   /*retorna elementos de la lista que se encuentra entre el elemento 1 y elemento 2*/
   public List<E> findBetween(Comparator<E> cmp, E elem1, E elem2);
   
}