/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import Data.Constants;
import Data.CrateresData;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import utilidades.Crateres;
import utilidades.ManejadorCrateres;
import utilidades.Rover;

/**
 *
 * @author Natalia
 */
public class VistaExplorar {
    public BorderPane root;     //public HBox central;
    public VBox lateral;
    public Pane c;
    public HBox hboxC;
    public Rover R;
    KeyCode k;
    private HashSet<ManejadorCrateres> manejardor;

    /**
     * Constructor de la clase VistaExplorar
    */
        
    public VistaExplorar(){
        //central=new HBox();
        root = new BorderPane();
      manejardor=new HashSet<>();
        seccionCentral();
        seccionBotton();

    } 
    
    /**
     * Metodo seccionCentral que inicializa la vista y crea la superficie, y coloca componentes en la parte derecha
     * y en la parte central
     */
    
    public void seccionCentral(){
        
        //Seccion Ingreso de comandos
        crearVista();
        root.setRight(lateral);
        lateral.setPadding(new Insets(20));
        
        //Seccion de Navegacion
        crearSuperficie();
        root.setCenter(c);
        c.setPadding(new Insets(20));
        
    }
    /**
     * Metodo encargado de crear la superficie junto con el rover
     */
    
    public void crearSuperficie(){
        c=new Pane();
        
        
        //Insertando imagen de la Superficie
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(Constants.RESOURCE_FOLDER+"/"+"superficie.jpg");
            //fil =new FileInputStream(Constants.RESOURCE_FOLDER+"/"+"superficie.jpg");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        ImageView ima= new ImageView(new Image(fis));
        ima.setFitWidth(890);
        ima.setFitHeight(660);
        c.setPadding(new Insets(20));
       
        FileInputStream rover = null;
        try {
            rover = new FileInputStream(Constants.RESOURCE_FOLDER+"/rover.png");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        ImageView imaRover= new ImageView(new Image(rover));
        imaRover.getLayoutX();
        imaRover.getLayoutY();
        imaRover.setFitWidth(80);
        imaRover.setFitHeight(80);
        
        
        
        R = new Rover(imaRover);
        
        c.getChildren().add(ima);
        
        generarCrateres();
        c.getChildren().add(imaRover);
    }
    
    /**
     * Metodo encargado de mostrar las coordenadas en la cual nos encontramos
    */
    public void seccionBotton(){
        //posicion del cursor sobre la Superficie
        hboxC = new HBox();
        
        Label lM= new Label();
        c.setOnMouseMoved(
                (MouseEvent me)->{
                    lM.setText(String.valueOf(me.getX())+" ; "+String.valueOf(me.getY()));
                });
        hboxC.getChildren().add(lM);
        lM.setAlignment(Pos.CENTER);
        root.setBottom(hboxC);
    }
    
    public static TextField t1;
    
    /**
     * Metodo encargado de crear la vista principal la cual permite la interaccion con el rover
     */
    public void crearVista(){
        lateral = new VBox();
        lateral.setAlignment(Pos.TOP_LEFT);
        Label l1 = new Label("Ingrese comandos:");
        Label l2 = new Label("Comandos ingresados:");
        t1 = new TextField();
        t1.setMaxWidth(120);
        TextArea t2 = new TextArea();
        //t2.setMaxWidth(120);
        t2.setMaxSize(200,2000);
        //Label lO = new Label("Insertando..");
        lateral.getChildren().addAll(l1,t1,l2,t2);
        //Controlador
        EventHandler eh = new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent ev){
                if (ev.getCode().equals(KeyCode.ENTER)) {
                    if (t1.getText().toLowerCase().equals("go")) {
                        opcionAvanzar(t2);
                    }
                    else if(t1.getText().toLowerCase().contains("girar")){
                        opcionGirar(t2);
                    }else if(t1.getText().toLowerCase().contains("dirigirse:")){
                        opcionDirigirse(t2);
                    }else if(t1.getText().toLowerCase().contains("sensar")){
                        try {
                            opcionSensar(t2);
                        } catch (IOException ex) {
                            Logger.getLogger(VistaExplorar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        t2.appendText("Ingrese correctamente el comando" + "\n");
                    }
                }
            }};
        t1.setOnKeyPressed(eh);
    }
    
    /**
     * Metodo encargado de generar los crateres
     */
    public void generarCrateres(){
        try {
            for(Crateres cr: CrateresData.arregloCrateres()){
                Circle circu= cr.getCirculo();
                manejardor.add(new ManejadorCrateres(cr,circu,root));
                cr.setCirculo(circu);
                circu.setStroke (Color.CORAL);
                circu.setFill(Color.rgb (255, 127, 80, 0.5));
                cr.circulo.setStrokeWidth (3);
                c.getChildren().add(circu);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Metodo encargado de poder avanzar el rover en una direccion 
     * @param t2 TextArea que contiene la informacion de todo los comandos 
     */
    
    public void opcionAvanzar(TextArea t2){
        double  angulo1 = R.anguloInicial;
        R.avanzar((int)angulo1);
        t2.appendText(t1.getText()+ "\n");
        t1.setText("");
    }
    
    /**
     * Metodo encargado de hacer girar el rover
     * @param t2 TextArea que contiene la informacion de todo los comandos 
     */
    public void opcionGirar(TextArea t2){
        
        String[] L = null;
        if(t1.getText().contains(":")){
            L = t1.getText().split(":");
        }
        if (L != null) {
            System.out.println("en if len");
            if(isNumeric(L[1])){
                double numero = Double.parseDouble(L[1]);
                R.girar(numero);
                t2.appendText(t1.getText() + "\n");
            }else{
                t2.appendText("Lo ingresado despues de los ':' no es un numero" + "\n");
            }
            t1.setText("");
        }
        else{
            t2.appendText("No se ingresó los ':' " + "\n");
        }
    }
    
    /**
     * Metodo encargado de permitir al rover obtener lo ingresado por el usuario y dirigirse a una coordenada especifica
     * @param t2 TextArea que contiene la informacion de todo los comandos 
     */
    public void opcionDirigirse(TextArea t2){
        t1.setDisable(true);
        String[] texto; 
        String[] texto2 = null;
        if(t1.getText().contains(":")){
            texto = t1.getText().toLowerCase().split(":");
            texto2 = texto[1].trim().split(",");
        }
        if((texto2 != null) && isNumeric(texto2[0])){
            if(Double.parseDouble(texto2[0])< 890 && Double.parseDouble(texto2[1])<660){
                t2.appendText(t1.getText() + "\n");
                R.dirigirse(Double.parseDouble(texto2[0]),Double.parseDouble(texto2[1]));                         
            }else{
                t2.appendText("su coordenada No se encuentra visible en el mapa " + "\n");
                t1.setDisable(false);
            }
        }else{
            t2.appendText("No se esta ingresando un valor numerico luego de los dos puntos" + "\n" );
            t1.setDisable(false);
        }
        t1.setText("");
    }

    /**
     * Metodo que permite identificar si hay interseccion entre circulos
     * @param cir recibe un objeto circulo
     * @return true en caso de haber interseccion false caso contrario
     */
    public boolean detectarIntersec(Circle cir){
        double limXsup = cir.getRadius() + cir.getCenterX();
        double limXinf = cir.getCenterX() - cir.getRadius();
        if(R.getPosX() >= limXinf && R.getPosX()<= limXsup){
            
            double limYsup = cir.getCenterY()+ Math.sqrt(Math.pow(cir.getRadius(), 2) - Math.pow((R.getPosX()-cir.getCenterX()),2));
            double limYinf = cir.getCenterY() - Math.sqrt(Math.pow(cir.getRadius(), 2) - Math.pow((R.getPosX()-cir.getCenterX()),2));
            
            if(R.getPosY() >= limYinf && R.getPosY() <= limYsup){
                return true;
            }
        }
        return false;        
    }
    
    /**
     * Metodo encargado de sensar un crater
     * @param t2 TextArea que contiene la informacion de todo los comandos 
     * @throws IOException excepcion generada por la lectura de un archivo
     */
    public void opcionSensar(TextArea t2) throws IOException{
        boolean val = false;
        String mensaje = "";
        for(ManejadorCrateres m1: manejardor){
            Crateres c1=m1.getCr();
            val = detectarIntersec(c1.getCirculo());
            if(val){
                String minerales= R.sensar();
                String mine = c1.getMinerales();
                c1.setVisitado(true);
                if(c1.getMinerales() != null){
                    String[] mins = minerales.split("/");
                    for(String m : mins){
                        if(!(mine.contains(m))){
                            mine = mine+ "/" + m;
                        }
                    }
                    c1.setMinerales(mine);
                }
                else{
                    c1.setMinerales(minerales);
                }
                LocalDateTime ldt = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String fecha = ldt.format(formatter);
                String nombre = c1.getNombre();
                try (BufferedWriter bw=(new BufferedWriter(new FileWriter(Constants.nombre,true)))) {
                        bw.write(nombre+","+fecha+","+minerales+"\n");
                }
                mensaje = "Sensar: "+R.getPosX()+", "+R.getPosY()+"\n";
                break;

            }else{
                mensaje = "No se encuentra en la ubicacion correcta para sensar"+ "\n";
            } 
        }
        t1.setText("");
        t2.appendText(mensaje);
    }
    
    /**
     * Metodo que permite saber si un string es de tipo numerico 
     * @param str String el cual se desea saber si es un numero o no
     * @return true en caso de que el string se puede convertir a numero
     */
    public static boolean isNumeric(String str) { 
        try {  
            Double.parseDouble(str);  
            return true;
        } catch(NumberFormatException e){  
            return false;  
        }  
    }
    
    /**
     * Metodo que retorna el Pane general
     * @return root general
     */
    public Pane getRoot(){
        return root;
    }
    
}
