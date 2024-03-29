package TDAs;

public interface List<E> {
    
    /*** Métodos que deben ser implementados en la clase ArrayList como PRÁCTICA y en la clase LinkedList como TAREA ****/

    public boolean addFirst(E e); // inserta el elemento e al inicio

    public boolean addLast(E e); // inserta el elemento e al final

    public E removeFirst(); // remueve el elemento al inicio de la lista

    public E removeLast(); // remueve el elemento al final de la lista

    public int size();

    public boolean isEmpty();

    public void clear();
    
    
    /*********************************************************************************************/
    /*** Métodos que deben ser implementados en las clases ArrayList y LinkedList como TAREA ****/
    /*********************************************************************************************/

    public void add(int index, E element); // inserta element en la posición index

    public E remove(int index); // remueve y retorna el elemento en la posición index

    public E get(int index); // retorna el elemento ubicado en la posición index

    public E set(int index, E element); // setea el element en la posición index
    
    public String toString(); // retorna una cadena de caracteres representando los elementos que la lista contiene
    
    public Node getPrevious(Node p);

}
