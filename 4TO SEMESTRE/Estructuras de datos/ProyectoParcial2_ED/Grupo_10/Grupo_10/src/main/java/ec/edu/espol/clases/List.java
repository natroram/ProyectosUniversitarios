package ec.edu.espol.clases;

public interface List<E> {
    


    public boolean addFirst(E e);

    public boolean addLast(E e);

    public E removeFirst();

    public E removeLast(); 

    public int size();

    public boolean isEmpty();

    public void clear();
    public Iterator<E> iterator();
    

}
