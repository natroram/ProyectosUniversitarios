

package ec.edu.espol.clases;


import java.util.Comparator;
import java.util.Objects;




public class LinkedList<E> implements List<E> {
    
    private Node<E> first;
    private Node<E> last;
    private int capacity=0;
    
    public LinkedList(){
        first=null;
        last=null;
        capacity=0;        
    }
    

    @Override
    public boolean addFirst(E e) {
        Node <E> nn=new Node(e);
        if(this.isEmpty()){
            nn.setnext(first);
            first=nn;
            last=nn;
        }
        else{
            nn.setnext(first);
            first=nn;
        }
        capacity++;
        return true;
    
    }

    @Override
    public boolean addLast(E e) {
        Node <E> nn=new Node(e);
        if(this.isEmpty()){
            first=nn;
            last=nn;
        }
        else{
            last.setnext(nn);
            last=nn;            
        }       
        capacity++;
        return true;
    }

    @Override
    public E removeFirst() {
        E conte=first.getcont();
        if(this.isEmpty())
            return first.getcont();
        Node<E> ns=first.getnext();
        first=ns;
        capacity--;        
        return conte;
    }

    @Override
    public E removeLast() {
        
        E conte=first.getcont();  
        
        if(capacity>1){
            int cont=0;
            conte=last.getcont();
            for(Node<E> nv=first;nv!=null;nv=nv.getnext()){
                if(cont==capacity-2){                      
                    nv.setnext(null);
                    last=nv;                    
                }
                cont++;
            }
        }
        capacity--;        
        return conte;        
    }

    @Override
    public int size() {          
        return capacity;    
    }

    @Override
    public boolean isEmpty() {
        return first==null && last==null;
    }

    @Override
    public void clear() {
        first=null;
        last=null;
        capacity=0;        
    }
    
    public boolean add(E element){
        Node <E> nn=new Node(element);
        if(this.isEmpty()){
            first=nn;
            last=nn;
        }
        else{
            last.setnext(nn);
            last=nn;            
        }       
        capacity++;
        return true;
    }
    
    public void add(int index, E element){/////
        if(index<=0)
            this.addFirst(element);        
        else if(index<capacity){
            int cont=0;
            Node<E> nn=new Node(element);
            for(Node<E> nv=first;nv!=null;nv=nv.getnext()){
                if(cont==index-1)    {              
                    nv.setnext(nn);
                    nn.setnext(nv.getnext());
                }

                cont++;
            }
        }
        else
            this.addLast(element);
        capacity++;

    }// inserta element en la posición index

    public E remove(int index){
         E conte=first.getcont();
        
        if(index<=0){
            this.removeFirst();
            return conte;
        }
        else if(index<capacity){
            int cont=0;
           
            for(Node<E> nv=first;nv!=null;nv=nv.getnext()){
                if(cont==index-1)   {         
                    conte=nv.getnext().getcont();
                    nv.setnext(nv.getnext().getnext());
                }                                   
                cont++;
            }
            capacity--;
            return conte;
        }
        else{
            this.removeLast();
            return null;
        }
    }// remueve y retorna el elemento en la posición index

    public E get(int index){
        E conte=first.getcont();
        if(index<=0)
            return conte;
        else if(index<capacity){
            int cont=0;
            for(Node<E> nv=first;nv!=null;nv=nv.getnext()){     
                if(cont==index)
                    conte=nv.getcont();
                cont++;
            }
            return conte;
        }
        else
            return last.getcont();
    }

    public E set(int index, E element){
        E conte=first.getcont();
        
        if(index<=0){
            first.setcont(element);
        }
        else if(index<capacity){
            int cont=0;
            Node<E> nn=new Node(element);
            for(Node<E> nv=first;nv!=null;nv=nv.getnext()){
                if(cont==index){
                    nv.setcont(element);                    
                    nv=null;
                }
                cont++;
            }
            return conte;
        }
        else{
            conte=last.getcont();
            last.setcont(element);
        }
            
        return conte;
    }// setea el element en la posición index
    
    public String toString(){
        String cad="[";
        for(Node<E> nv=first;nv!=null;nv=nv.getnext()){ 
            if(!Objects.equals(null, nv.getcont()))
                cad=cad.concat(nv.getcont().toString()+",");
        }
        return cad.substring(0,cad.length()-1).concat("]");      
    }// retorna una cadena de caracteres representando los elementos que la lista contiene*/

    
    
    public List<E> findAll(Comparator<E> cmp,E elem){
        List<E> results=new LinkedList<>();
        Iterator<E> it=this.iterator();
        while(it.hasNext()){
            E e=it.next();
            if(cmp.compare(e, elem)==0)
                results.addLast(e);
        }
        return results;           
    } 
    /*
    public int igual(Obj1,Obj2){
        
        
        (Obj1,Obj2)->{
            if(Obj1>Obj2)
                return 1;
            else if(Obj1==Obj2)
                return 0;
            else
                return -1;        
            }
                
                }*/

    @Override
    public Iterator<E> iterator(){
        Iterator<E> it= new Iterator<E>() {            
            Node<E> point=first;//puntero
            //con valor inicial first
            @Override
            public boolean hasNext() {
                return point!=null;
            }
            @Override
            public E next() {
                E valor=point.getcont();
                point=point.getnext();
                return valor;            
            }            
        };
        return it;
    }
    
}
