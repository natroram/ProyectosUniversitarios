/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.util.Iterator;
import java.util.ListIterator;
import soldado.Soldado;
import tdas_linkedlist.CircularLinkedList;



/**
 *
 * @author Gabriel
 */
public class Sistema extends Thread {
    CircularLinkedList<Soldado> soldados;
    int cantidadSoldados;
    int cantidadVivos;
    VistaPantalla vista;
    
    public Sistema(VistaPantalla vista) {
        this.vista = vista;
    }
    
    @Override
    public void run() {
            try {
                
                double primero = vista.getPosicionInicio().getValue();
                int contador = 0;
                /**
                 * caso con sentido horario
                 */
                if (vista.getGrupoDirec().getSelectedToggle() == vista.getDerecha()) {
                    ListIterator<Soldado> li = soldados.listIterator((int)vista.getPosicionInicio().getValue());
                    while (contador < ((int)vista.getCantidadSoldados().getValue()) - 1) {
                        Soldado atacante = new Soldado(1);
                        Soldado victima = new Soldado(2);
                        boolean hecho = false;
                        if ((atacante = li.next()).isAlive()) {
                            while (hecho == false) {
                                if ((victima = li.next()).isAlive()) {
                                    /**
                                     * animacion del atacante
                                     * que simulara cuando este en guardia y cuando ejecuta el asesinato
                                     */
                                    atacante.preparado();
                                    Thread.sleep(500);
                                    atacante.ataque_der();
                                    Thread.sleep(500);
                                    atacante.normal();
                                    /**
                                     * animacion de la victima
                                     * que simulara cuando ocurre su muerte
                                     */
                                    victima.setEstado(false);
                                    contador++;
                                    hecho = true;
                                }
                            }
                        }
                        Thread.sleep(1000);
                    }
                } 
                /**
                 * caso con sentido antihorario
                 */
                else if (vista.getGrupoDirec().getSelectedToggle() == vista.getIzquierda()) {
                    ListIterator<Soldado> li = soldados.listIterator((int)vista.getPosicionInicio().getValue());
                    while (contador < ((int)vista.getCantidadSoldados().getValue()) - 1) {
                        Soldado atacante;
                        Soldado victima;
                        boolean hecho = false;
                        if ((atacante = li.previous()).isAlive()) {
                            while (hecho == false) {
                                if ((victima = li.previous()).isAlive()) {
                                    //animando
                                    atacante.preparado();
                                    Thread.sleep(500);
                                    atacante.ataque_izq();
                                    Thread.sleep(500);
                                    atacante.normal();
                                    //fin de la animacion
                                    victima.setEstado(false);
                                    contador++;
                                    hecho = true;
                                }
                            }
                        }
                        Thread.sleep(1000);
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    
    //Este metodo crea la lista circular con tantos soldados como sean requeridos.
    //Se debe haber fijado una cantidad de soldados previamente para que funcione.
    public void iniciarCirculo(int cantidad){
        cantidadSoldados = cantidad;
        soldados = new CircularLinkedList<> ();
        for(int i = 1; i <= cantidadSoldados; i++) {
            soldados.addLast(new Soldado(i));
        }
    }
    
//    public void ejecucion() {
//        Iterator it = soldados.listIterator(0);
//        Soldado actual;
//        boolean interruptor = true;
//        cantidadVivos = cantidadSoldados;
//        System.out.println(soldados.size());
//        while(interruptor) {
//            actual = (Soldado) it.next();
//            System.out.println(actual);
//            System.out.println("soldado numero " + actual.getID() + " asesina a: ");
//            actual = (Soldado) it.next();
//            if(actual.isAlive()){
//                actual.matar(actual);
//                cantidadVivos--;
//                System.out.println("vivos: " + cantidadVivos);
//            }
//            if (cantidadVivos == 1) {
//                interruptor = false;
//            }
//        }
//        System.out.println("resultado final");
//        for(Soldado soldado: soldados){
//            System.out.println(soldado);
//        }
//    }
//    

    

    
    
    
}
