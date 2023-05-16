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
public class CircularLinkedList<E> implements List<E> {
    private Node<E> last;

    @Override
    public boolean addFirst(E e) {
        Node<E> nuevo = new Node<>(e);
        if(isEmpty()){
            last = nuevo;
            last.setNext(nuevo);
        }
        else{
            nuevo.setNext(last.getNext());
            last.setNext(nuevo);
        }
        return true;
    }

    @Override
    public boolean addLast(E e) {
        Node<E> nuevo = new Node<>(e);
        if(isEmpty()){
            last = nuevo;
            last.setNext(nuevo);
        }
        else{
            nuevo.setNext(last.getNext());
            last.setNext(nuevo);
        }
        last = nuevo;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
       Node q = null;
       
       if(!this.isEmpty()){
           q = this.last.getNext();
       
           while(q.getNext() != p){
                q = q.getNext();
           }
       }
       return q;
    }
    
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        } else {
            return last.next.data;
        }
    }

    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        } else {
            return last.data;
        }
    }

    public int indexOf(E e) {
        if (e == null || isEmpty()) {
            return -1;
        }
        Node<E> q = last.next;
        for (int i = 0; i < current; i++) {
            if (q.data.equals(e)) {
                return i;
            }
            q = q.next;
        }
        return -1;
    }

    public int size() {
        return current;
    }

    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        }

        Node<E> newFirst = last.next.next;
        last.next.data = null;
        last.next.next = null;
        last.next = newFirst;
        current--;
        return true;
    }

    private Node<E> getNode(int index) {
        if (index == current - 1) {
            return last;
        }
        Node<E> n = last.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    public boolean insert(int index, E e) {
        if (index > current || index < 0) {
            throw new IndexOutOfBoundsException("El indice pedido supera el tamaño de la lista.");
        }
        if (e == null || isEmpty()) {
            return false;
        }
        if (index == 0) {
            return addFirst(e);
        }
        if (index == current) {
            return addLast(e);
        }
        Node<E> q = new Node(e);
        Node<E> prev = getNode(index - 1);
        Node<E> sgte = prev.next;
        prev.next = q;
        q.next = sgte;
        current++;
        return true;
    }

    public boolean set(int index, E e) {
        if (e == null) {
            return false;
        }
        if (index >= current || index < 0) {
            throw new IndexOutOfBoundsException("Indice fuera del limite");
        }
        if (index == current - 1) {
            last.data = e;
        } else {
            Node<E> q = getNode(index);
            q.data = e;
        }
        return true;
    }

    public boolean isEmpty() {
        return last == null;
    }

    public E get(int index) {
        if (index < 0 || index >= current) {
            throw new IndexOutOfBoundsException("El indice esta fuera del limite");
        }
        if (index == current - 1) {
            return last.data;
        } else {
            Node<E> p = getNode(index);
            return p.data;
        }
    }

    public boolean contains(E e) {
        Node<E> p = last.next;
        do {
            if (p.data.equals(e)) {
                return true;
            }
            p = p.next;
        } while (p != last.next);
        return false;
    }

 
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> p = last.next;
        for (int i = 0; i < current - 1; i++)// hasta el penultimo
        {
            sb.append(p.data);
            sb.append(",");
            p = p.next;

        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}

    

