/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.util.Iterator;
import soldado.Soldado;
import tdas_linkedlist.CircularLinkedList;



/**
 *
 * @author Gabriel
 */
public class Sistema extends Thread {
    CircularLinkedList<Soldado> soldados;
    int cantidadSoldados;
    
    @Override
    public void run() {

        
    }
    
    //Este metodo crea la lista circular con tantos soldados como sean requeridos.
    //Se debe haber fijado una cantidad de soldados previamente para que funcione.
    public void iniciarCirculo(int cantidad){
        cantidadSoldados = cantidad;
        soldados = new CircularLinkedList<> ();
        for(int i = 0; i<= cantidadSoldados; i++) {
            soldados.addLast(new Soldado(i));
        }
    }
    
    public void ejecucion() {
//        Soldado asesino;
//        for(Soldado soldado: soldados){
//            asesino = soldado;
//            if(soldado != asesino){
//                if(soldado.isAlive()){
//                    asesino.matar(soldado);
//                }
//            }
//        }
        
        Iterator it = soldados.listIterator(0);
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    

    
    
    
}
