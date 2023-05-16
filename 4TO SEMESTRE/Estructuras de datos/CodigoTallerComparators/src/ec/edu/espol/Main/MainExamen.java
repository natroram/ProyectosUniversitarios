/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/**
 *
 * @author Natalia Ramirez
 */
public class MainExamen {
    
    public static void main (String[] args){
        ArrayList<Integer> matriz = new ArrayList<>();
        Integer[] m2 = {1,2,3,4};
       
    }
    
    public static ArrayList<Casilla> encontrarCamino(ArrayList<Integer> laberinto, int indexFila, int indexColumna){
        ArrayList<Casilla> casillas = new ArrayList<>();
        int maxColumna;
        int maxFila;
        int currentValue = -1;
        Casilla currentCell = new Casilla();
        Stack<Casilla> pila = new Stack<>();
        while(currentValue < 2){
            if(pila.empty()){
                currentCell.setX(indexColumna);
                currentCell.setY(indexFila);
            }
            else{
                //currentValue = laberinto[currentCell.getY(),currentCell.getX()];
                
                if(currentValue == 0){
                    pila.push(currentCell);
                    
                    if((laberinto[currentCell.getY()-1,currentCell.getX()) == 0){
                    
                    }
                    if((laberinto[currentCell.getY()+1,currentCell.getX()) == 0){
                    
                    }
                    if((laberinto[currentCell.getY(),currentCell.getX()-1) == 0){
                    
                    }
                    if((laberinto[currentCell.getY()-1,currentCell.getX()+1) == 0){
                    
                    }
                }
                else if(currentValue == 1){
                    while(currentValue!=0){
                        currentCell = pila.pop();
                        currentValue = laberinto[pila.peek().getY(), pila.peek().getX()];
                    }
                    
                }
            }
            
            
        }
        Stack<Casilla> pila2 = new Stack<>();
        for(int i = 0; i < pila.size(); i++){
            pila2.push(pila.pop());
        }
        for(int i = 0; i < pila2.size(); i++){
            casillas.add(pila2.pop());
        }
        return casillas;
    }
    
    public static void asignarPedidos (Queue<Pedidos> pedidos, Map<String, Integer> distancias){
        ArrayList<Pedidos> pedidosRepartidor = new ArrayList<>();
        for(int i =0; i<3; i++ ){
            pedidosRepartidor.add(pedidos.poll());
        }
        
        
    }
    public static class Casilla {
        
        private int x;
        private int y;

        public Casilla() {
        }

        public Casilla(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
        
        
    }
}
