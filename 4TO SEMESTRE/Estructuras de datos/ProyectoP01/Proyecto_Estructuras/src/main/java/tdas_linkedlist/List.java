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
public interface List<E> extends Iterable<E> {
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
   boolean remove(int index);
   boolean remove(E element);
   boolean set(int index, E element);
   int size();
}
