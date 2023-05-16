/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import Data.CrateresData;
import com.mycompany.mavenproject1.VistaExplorar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.application.Platform;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alesia
 */
public class Rover implements CrateresInterface{
    
    public static double posX;
    public static double posY;
    ImageView imaR;
    static int distancia = 15;
    double puntoX;
    double puntoY;
    double x; 
    double y;
    public double anguloInicial;
    public Thread t1;
    double angulo;
    
    /**
    * Constructor clase Crateres
    * @param imaRover ImageView
    */
    
    public Rover(ImageView imaRover) {
        this.imaR=imaRover; 
        this.posX = imaR.getLayoutX();
        this.posY = imaR.getLayoutY();
    }

    public Double getPosX() {
        return posX;
    }

    public void setPosX(Double posX) {
        this.posX = posX;
    }

    public Double getPosY() {
        return posY;
    }

    public void setPosY(Double posY) {
        this.posY = posY;
    }

    public ImageView getImaR() {
        return imaR;
    }

    public void setImaR(ImageView imaR) {
        this.imaR = imaR;
    }
    
    /**
     * Metodo avanzar(i) recibe un Integer
     * Recibe el angulo al que se encuentra el rover y realiza calculos para generar un valor
     * @param i cantidad de pixeles que se mueve el rover
    */
    
    @Override
    public void avanzar(Integer i){
        double x = 0;
        double y = 0;
        
        x = (Math.cos(Math.toRadians((int)i))*distancia);
        y = (Math.sin(Math.toRadians((int)i))*distancia);
        
        this.posX = this.posX+x;
        this.posY = this.posY+y;
        
        this.imaR.setLayoutX(this.getPosX());
        this.imaR.setLayoutY(this.getPosY());
    }
    
    /**
     * Metodo girar() 
     * recibe un valor de angulo al que se quiere girar el rover
     * y genera este movimiento
     * @param giro angulo de giro
    */
    
    @Override
    public void girar (double giro) {
        this.imaR.setRotate(imaR.getRotate()+giro);
        this.anguloInicial += giro;
    }
    
    /**
     * Metodo dirigirse(x,y) que recibe un double en x y y que corresponden a coordenadas
     * Realiza calculos para encontrar la mejor ruta para dirigirse a ese punto
     * crea dos hilos que le generan el moviento al rover
     * @param x coordenada en x donde se debe mover el rover
     * @param y coordenada en y donde se debe mover el rover
    */
    
    @Override
    public void dirigirse(double x, double y) {
        this.x = x;
        this.y = y;
        double deltaX = x- getPosX();
        double deltaY = y- getPosY();
        
        if(deltaX> 0 && deltaY>0){
            angulo += Math.toDegrees(Math.atan(Math.abs(deltaY/deltaX))); 
        }else if(deltaX< 0 && deltaY>0){
            angulo = 180 - Math.toDegrees(Math.atan(Math.abs(deltaY/deltaX)));
        }else if(deltaX> 0 && deltaY<0){
            angulo =360 - Math.toDegrees(Math.atan(Math.abs(deltaY/deltaX)));
        }else if(deltaX< 0 && deltaY<0){
            angulo = 180 + Math.toDegrees(Math.atan(Math.abs(deltaY/deltaX)));
        }        
        double distance = Math.hypot(deltaX, deltaY);
        
        puntoY = (y - this.getPosY())/2;
        puntoX = (x - this.getPosX())/2;
        int valor = 10;
        for(int i = 0; i < valor;i++){
            puntoX = puntoX/2; 
            
            puntoY = puntoY/2 ;
            
        }
        t1 = new Thread(new moverDirigirsegirar());
        t1.start();
        Thread t2 = new Thread(new moverDirigirseAvanzar());
        t2.start();
    }

    /**
     * Metodo sensar()
     * Retorna un string con minerales separados por un / encontrados en el crater
     *de forma aleatorea en caso de no presentar materiales retorna null.
     * @return String
    */
    
    @Override
    public String sensar() {
        try(BufferedReader br = new BufferedReader(new FileReader(CrateresData.MINERALES))){
            ArrayList<String> minerales = new ArrayList();
            String linea;
            
            while((linea = br.readLine())!= null){
            minerales.add(linea.trim());
            }
            Random num = new Random();
            int rd = num.nextInt(minerales.size());
            Collections.shuffle(minerales);
            List<String> explor = minerales.subList(0, rd);          
            String result = String.join("/",explor);
            
            return result;
        
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
        
    }
    
    class moverDirigirsegirar implements Runnable{
        /**
        * Metodo run()
        * gira el rover a el angulo necesario para iniciar el moviento 
        * en la mejor ruta
        */

        @Override
        public void run() {
            Platform.runLater(new Runnable(){
                        @Override
                public void run() {
                    girar(angulo - anguloInicial);
                    
                }
            });
        }
        
    }
    
    class moverDirigirseAvanzar implements Runnable{

        /**
        * Metodo run()
        * mueve el rover del punto donde se encuentra al punto al que se quiere llegar
        * y lo devuelve a su angulo dejandolo en la posicion orginal
        */
        
        @Override
        public void run() {
            double errorx = 1;
            double errory = 1;
            
            while( errorx> 0.000001|| errory> 0.000001){
                errorx = Math.abs(posX-x);
                errory = Math.abs(posY-y);
                        
                try {
                    
                    posX = posX + puntoX;
                    posY = posY + puntoY;
                    
                    /*imaR.setLayoutX(posX);
                    imaR.setLayoutY(posY);*/
                    
                    Thread.sleep(5);
                    Platform.runLater(new Runnable(){
                        @Override
                        public void run() {
                            
                            imaR.setLayoutX(posX);
                            imaR.setLayoutY(posY);
                        }
                        
                    });
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
         
            VistaExplorar.t1.setDisable(false);
            Platform.runLater(new Runnable(){
                        @Override
                public void run() {
                    girar(-angulo);
                    angulo=0;
                    anguloInicial=0;
                }
            });
        }
    }
  
  
}
