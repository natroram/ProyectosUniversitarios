/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.ArrayList;

/**
 *
 * @author Jocellyn Luna
 */
public interface Queue<E> {
    //FIFO (Fisrt In, First Out)
    boolean offer(E element); //Poner un elemeto en la cola
    E poll(); //Saca el primer elemetno de la cola
    E peek(); // Mira cual es el elemento que va a sacar sin sacarlo
    boolean isEmpty(); 
}

