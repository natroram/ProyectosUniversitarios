/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea02_nataliaramirez;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author Natalia Ramirez
 */
public class MejoresMetodos {
    public Integer[] entradas = {5,10,20,35,50};
    public ArrayList<ArrayList<ArrayList<Integer>>> input;

    public MejoresMetodos() {
        input = new ArrayList();
    }
    
    public void generateInput(){
        ArrayList<ArrayList<ArrayList<Integer>>> h = new ArrayList();
        for(Integer n : entradas){
            ArrayList<ArrayList<Integer>> parejas = new ArrayList();
            ArrayList<Integer> bloqueos = new ArrayList();
            ArrayList<Integer> puntajes = new ArrayList();
            
            for(int i=0; i<n; i++){
                bloqueos.add(alea(1,5));
                puntajes.add(alea(1,30));  
            }          
            parejas.add(puntajes);
            parejas.add(bloqueos);
            
            h.add(parejas);
        }
        
        input = h;
    }
    
    public Integer alea(int m, int n){
        Integer valor = (int)Math.floor(Math.random()*(n-m+1)+m);
        return valor;
    }
    
    public int puntajeMaxMochila(ArrayList<Integer> puntajes, ArrayList<Integer> bloqueos){
        int puntajeMax = 0;
        double[] razon = new double[puntajes.size()];
        
        for(int i =0; i<puntajes.size(); i++){
            double p = puntajes.get(i);
            double b = bloqueos.get(i);
            if( b !=0){
                double ra = (double)(p/b);
                razon[i] = ra;
            }
            else
                razon[i] = p;
        }
        ArrayList<Integer> bloqueados = new ArrayList<Integer>();
        boolean[] val = new boolean[puntajes.size()];
        for(int i =0; i<puntajes.size(); i++){
            double r =0;
            int idx = 0;

            for(int j = 0; j<puntajes.size(); j++){
                if(razon[j] > r){
                    r= razon[j];
                    razon[j] = 0;
                    idx = j;
            }
            }
            int num =0;
            
            while(num!= bloqueos.get(idx)){
                num++;
                if(idx+num < puntajes.size()){
                    if(val[idx+num] == false && !bloqueados.contains(num)){
                        val[idx]= true;

                        bloqueados.add(idx+num);
                    }
                }
            }
        }
        
        for(int h = 0; h< val.length; h++){
            if(val[h])
                puntajeMax += puntajes.get(h);
        }
        
        return puntajeMax;
    }
    
    public int puntajeMaxFuerzaBruta(ArrayList<Integer> puntajes, ArrayList<Integer> bloqueos){
        int totalMax = 0;
        for(int i = 0; i<puntajes.size(); i++){
            int total = 0;
            for(int j = i; j<puntajes.size(); j++){
                total += puntajes.get(j);
                if(bloqueos.get(j)>0){
                    j += bloqueos.get(j);
                }
                System.out.println(total);
            }
            if(totalMax< total)
                totalMax = total;
        }
        
        return totalMax;
    }
    
    public ArrayList<Long> datosMochila(){
        ArrayList resultados = new ArrayList<>();
        for(ArrayList<ArrayList<Integer>> parejas : input){
            long inicio = System.nanoTime();
            int a = puntajeMaxMochila(parejas.get(0), parejas.get(1));

            long fin = System.nanoTime();
            
            long tiempo = fin - inicio;
            resultados.add(tiempo);
        }
        
        return resultados;
    }
    
    public ArrayList<Long> datosFuerzaBruta(){
        ArrayList resultados = new ArrayList<>();
        for(ArrayList<ArrayList<Integer>> parejas : input){
            long inicio = System.nanoTime();
            int a = puntajeMaxFuerzaBruta(parejas.get(0), parejas.get(1));

            long fin = System.nanoTime();
            
            long tiempo = fin - inicio;
            resultados.add(tiempo);
        }
        
        return resultados;
    }
    
    
//    public int maxSubarray_bruteForce(Integer[] A){
//        int max = 0;
//        
//        for(int i = 0; i<A.length; i++){
//            int current = 0;
//            for(int j = 0; j <A.length; j++){
//                current+= A[j];
//                if(current>max){
//                    max = current;
//                }
//            }
//        }
//        
//        return max;
//    }
    
//    public ArrayList<Long> datosBrute(){
//        ArrayList resultados = new ArrayList<>();
//        for(Integer[] lista : input){
////            System.out.println(lista.length);
//            long inicio = System.nanoTime();
//            int a = maxSubarray_bruteForce(lista);
////            System.out.println(a + " - tamaño: " + lista.length);
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        
//        return resultados;
//    }
    
//    public int maxSubarray_dividir(Integer[] A, int lower, int medium, int high){
//        int suma = 0;
//        int izq_suma = Integer.MIN_VALUE;
//        for (int i = medium; i > lower; i--) {
//            suma = suma + A[i];
//            if (suma > izq_suma)
//                izq_suma = suma;
//        }
// 
//        
//        suma = 0;
//        int dere_suma = Integer.MIN_VALUE;
//        for (int i = medium + 1; i < high; i++) {
//            suma = suma + A[i];
//            if (suma > dere_suma)
//                dere_suma = suma;
//        }
//        
//        return Math.max(izq_suma + dere_suma,
//                        Math.max(izq_suma, dere_suma));
//        
//    }
    
//    public ArrayList<Long> datosDividir(){
//        ArrayList resultados = new ArrayList<>();
//        for(Integer[] lista : input){
//            long inicio = System.nanoTime();
//            int a = maxSubarray_dividir(lista, 0, lista.length/2, lista.length);
////            System.out.println(a + " - tamaño: " + lista.length);
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        
//        return resultados;
//    }
    
//    public void ambosOrdenados(Integer[] A, Integer[] B){
//        ArrayList<Integer> R = new ArrayList();
//        Arrays.sort(A);
//        Arrays.sort(B);
//        int i=0;
//        int j=0;
//        while(i< A.length && j< B.length){
//            if(A[i] < B[j]){
//                i++;
//            }
//            if(B[j] < A[i]){
//                j++;
//            }
//            else{
//                R.add(B[j++]);
//                i++;
//            }
//        }
//        
//    }
//    
//    public void usandoHeap(Integer[] A, Integer[] B){
//        ArrayList<Integer> R = new ArrayList();
//        PriorityQueue<Integer> cola = new PriorityQueue();
//        for(Integer n : A){
//            cola.offer(n);
//        }
//        for(Integer m : B){
//            if(cola.contains(m)){
//                R.add(m);
//            }
//        }
//    }
//    
//    public void usandoMapa(Integer[] A, Integer[] B){
//        ArrayList<Integer> R = new ArrayList();
//        Map<Integer,Integer> mapa = new HashMap();
//        for(int i=0; i<A.length; i++){
//            mapa.putIfAbsent(i, A[i]);
//        }
//        for(Integer m : B){
//            if(mapa.containsValue(m)){
//                R.add(m);
//            }
//        }
//        
//    }
    
//    public ArrayList<Long> datosOrdenarDos(){
//        ArrayList resultados = new ArrayList<>();
//        for(ArrayList<Integer[]> lista : this.input){
//            long inicio = System.nanoTime();
//            ambosOrdenados(lista.get(0), lista.get(1));
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        return resultados;
//    }
//    
//    public ArrayList<Long> datosHeaps(){
//        ArrayList resultados = new ArrayList<>();
//        for(ArrayList<Integer[]> lista : this.input){
//            long inicio = System.nanoTime();
//            usandoHeap(lista.get(0), lista.get(1));
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        return resultados;
//    }
//    
//    public ArrayList<Long> datosMapas(){
//        ArrayList resultados = new ArrayList<>();
//        for(ArrayList<Integer[]> lista : this.input){
//            long inicio = System.nanoTime();
//            usandoMapa(lista.get(0), lista.get(1));
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        return resultados;
//    }
    

}

    
//    public int f_recursivo(int n){
//        if ((n==0) || (n==1)){
//            return n;
//        }
//        else{
//            return f_recursivo(n-1) + f_recursivo(n-2);
//        }
//    }
//    
//    public int f_iterativo(int n){
//        int preNum_ante;
//        int numAnte = 0;
//        int num = 1;
//        
//        for (int i = 1; i < n; i++){
//            preNum_ante = numAnte;
//            numAnte = num;
//            num = preNum_ante + numAnte;
//        }
//        
//        return num;
//    }
//    
//    public ArrayList<Long> ejecucionRecursivo(){
//        ArrayList resultados = new ArrayList<>();
//        
//        for (Integer n : entradas){
//            long inicio = System.nanoTime();
//            int valor = f_recursivo(n);
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        
//        return resultados;
//    }
//    
//    public ArrayList<Long> ejecucionIterativo(){
//        ArrayList resultados = new ArrayList<>();
//        
//        for (Integer n : entradas){
//            long inicio = System.nanoTime();
//            int valor = f_iterativo(n);
//            long fin = System.nanoTime();
//            
//            long tiempo = fin - inicio;
//            resultados.add(tiempo);
//        }
//        
//        return resultados;
//    }
//    
