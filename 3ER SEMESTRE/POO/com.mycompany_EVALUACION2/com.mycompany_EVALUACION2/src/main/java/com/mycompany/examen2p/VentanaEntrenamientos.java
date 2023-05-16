/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen2p;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.CONSTANTS;
import modelo.Ejercicio;
import modelo.Entrenamiento;
import modelo.GymException;

/**
 * @autor:rociomera
 */
public class VentanaEntrenamientos {
    //contenedor raiz de la aplicacion
    private VBox root; 
    //label que contiene mensajae que se muestra en la parte superior
    private Label labelMensaje; 
    
    public VBox getRoot() {
        return root;
    }
    
    public VentanaEntrenamientos(){
        root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(10);
        crearSeccionMensaje();
        try{
            crearSeccionCombo();
        }catch(GymException|NullPointerException ge){
            root.getChildren().clear();
            root.getChildren().add(new Label(ge.getMessage()));
        }
    }
    
    public void crearSeccionMensaje(){
        labelMensaje = new Label("Seleccione un entrenamiento");
        HBox seccionmensaje= new HBox(labelMensaje);
        root.getChildren().add(seccionmensaje);
    }
    
    public void crearSeccionCombo() throws GymException{
       
        ComboBox<Entrenamiento> comboentrenamiento = new ComboBox((ObservableList) Entrenamiento.cargarEntrenamientos("entrenamientos.txt"));
        
        HBox seccionCombo = new HBox(new Label("Entrenamiento"),comboentrenamiento);
        seccionCombo.setSpacing(10);
        root.getChildren().add(seccionCombo);
        //TODO: cargar la lista en el combo
        
        
        //TODO: fijar una accion al combo
        comboentrenamiento.setOnAction(
                (ActionEvent e)->{
                    Entrenamiento entrenamiento = comboentrenamiento.getValue();
                    List<Ejercicio> ejercicios = entrenamiento.getEjercicios();
                    
                    BorderPane seccionEjercicios = new BorderPane();
                    VBox contBotones = new VBox();
                    for(Ejercicio ejer : ejercicios){
                        Button bt = new Button(ejer.getNombre());
                        contBotones.getChildren().add(bt);
                        seccionEjercicios.setLeft(contBotones);
                        
                        //Fijar accion a los ejercicios para mostrar las imagenes
                        bt.setOnMouseClicked(
                                (MouseEvent eh)->{
                                    String nomEjer = bt.getText();
                                    Ejercicio ej1 = null;
                                    for(Ejercicio ej : ejercicios){
                                        if(ej.getNombre().equals(nomEjer)){
                                            ej1 = ej;
                                        }
                                    }
                                    //Obteniendo imagenes y creando los imageviews
                                    List<String> images = ej1.getImagenes();
                                    
                                    if(!images.isEmpty()){
                                        ImageView img1 = new ImageView(new Image(CONSTANTS.path+images.get(0)));
                                        ImageView img2 = new ImageView(new Image(CONSTANTS.path+images.get(1)));
                                    
                                    }
                                    
                                }
                        );
                    }
                    
                    
                }
        );
        
        
        
        
    }
}
