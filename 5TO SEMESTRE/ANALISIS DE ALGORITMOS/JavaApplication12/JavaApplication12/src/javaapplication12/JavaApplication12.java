/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author jorge
 */
public class JavaApplication12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n = 10;
        int[] puntaje = {1,2,1,3,4,1,2,1,3,2};
        int[] bloqueos ={1,0,2,2,0,1,2,1,0,0};
        int puntajeMax =0;
        ArrayList<Integer> puntajes = new ArrayList<Integer>();
        
        double[] razon = new double[10];
        
        for(int i =0; i<n; i++){
            double p = puntaje[i];
            double b = bloqueos[i];
            if( b !=0){
                double ra = (double)(p/b);
                razon[i] = ra;
            }
            else
                razon[i] = p;
        }
        ArrayList<Integer> bloqueados = new ArrayList<Integer>();
        boolean[] val = new boolean[10];
        for(int i =0; i<n; i++){
            double r =0;
            int idx = 0;

            for(int j = 0; j<n; j++){
                if(razon[j] > r){
                    r= razon[j];
                    razon[j] = 0;
                    idx = j;
            }
            }
            int num =0;
            
            while(num!= bloqueos[idx]){
                num++;
                if(val[idx+num] == false && !bloqueados.contains(num)){
                    val[idx]= true;

                    bloqueados.add(idx+num);
                }
            }
        }
        
        for(int h = 0; h< val.length; h++){
            if(val[h])
                puntajeMax += puntaje[h];
        }
        
        
        
        
        //fuerza bruta
        int totalMax = 0;
        for(int i = 0; i<puntaje.length; i++){
            int total = 0;
            for(int j = i; j<puntaje.length; j++){
                total += puntaje[j];
                if(bloqueos[j]>0){
                    j += bloqueos[j];
                }
                System.out.println(total);
            }
            if(totalMax< total)
                totalMax = total;
        }
        System.out.println(totalMax);
    }
    
}
