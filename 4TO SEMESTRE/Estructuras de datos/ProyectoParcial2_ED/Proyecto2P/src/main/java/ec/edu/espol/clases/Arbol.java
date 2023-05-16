/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

/**
 *
 * @author F. Lopez
 */
public class Arbol<T,K> {
    Nodo<T,K> root;
    
    public Arbol(Nodo<T,K> rootNode){//Constructor tradicional
        this.root=rootNode;
    }
    
    public Arbol(T content,K clav){//Constructor tradicional
        this.root= new Nodo(content,clav);
    }
    
    public Arbol(String ruta){//Funcion que crea un arbol a partir de un directorio sin subdirectorios(sin carpetas) solo con archivos
        //Escaneo de la carpta para obtener el peso de esta y el nombre para crear el respectivo nodo
        root=null;
    }
    
    public Arbol<T,K> crearArbolDir(String ruta){//Funcion recursiva que va creando el arbol final que contiene la info todos los subdirectorios
        
        //Pseudocodigo
        /*si no tiene subdirectorios devuelvo la info del directorio
        caso contrario hago la llamada recursiva y voy armando el arbol
        */
        return null;
    }
    
    public  Nodo<T,K> getRoot(){
        return root;
    }
    public void setRoot( Nodo<T,K> raiz){
        root=raiz;
    }
    
    public boolean isLeaf(){
        return root.getHijos().size()==0;
    }

    public void vaciarArbol(){
        root=null;
    }    
    public int getCanHijos(){
        return root.getCantHijos();
    }
    
    /*
    public int getTam(Arbol<Integer> ab){//Funcion que me devuelve el tamaño/peso del arbol
        //Hay que realizar la forma recursiva para obtener de todos los hijos
        return ab.getRoot().getValor();
    }
    */
    
    public Arbol<T,K> buscarNodo(Arbol<T,K> nodo){//Funcion que busca y retorna un nodo usando la etiqueta del nodo como parametor de busqueda
        return null;
    }
    public void AddHijoEsp(Arbol<T,K> busq,Arbol<T,K> nodo){//Funcion que agrega hijo a un arbol/subarbol especifco
        buscarNodo(busq).getRoot().AddHijo(nodo);   
    }
    public void AddHijo(Arbol<T,K> hijo){//Agrega hijo al arbol actual
        root.AddHijo(hijo);
    }

    public String toStringClaveValor(){
        String str = "";
        str = str.concat("k:"+this.getClave()+" T:"+this.getValor());
        str = str.concat("{");
        for(int i= 0; i<root.getCantHijos(); i++){
            String str2 ="{";
            str2=str2.concat(root.getHijos().get(i).toStringClaveValor());
            str2=str2.concat("}");
            str=  str.concat(str2);
        }
        return str;
    }
    
    public T getValor(){
        return root.getValor();
    }
    
    public K getClave(){
        return root.getClave();
    }
    
    public void setClave(K key){
        root.setClave(key);
    }
    
    public void setValor(T value){
        root.setValor(value);
    }
    
}
