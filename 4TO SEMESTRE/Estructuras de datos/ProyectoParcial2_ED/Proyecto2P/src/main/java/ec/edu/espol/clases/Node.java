/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.clases;

public class Node<E> {

    private E content;
    private Node<E> next;
    
    
    public Node(E cont) {
        content=cont;
        next=null;
    }
    public Node(E cont, Node<E> n){
        content=cont;
        next =n;
    }
    
    public Node<E> getnext(){
        return next;
    }
    public E getcont(){
        return content;
    }
    public void setnext(Node<E> n){
        next=n;
    }
    public void setcont(E e){
        content=e;
    }




}
