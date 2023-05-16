/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import Data.Constants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class VistaInicio {
    public BorderPane root;
    public VBox section;
    public FlowPane panel;
   
    /**
     * Este metodo genera el fondo de la ventana con la imagen marte.jpg que se encuentra en 
     * el paquete recursos, inicializa los contenedores y llama a los metodos para generar
     * cada seccion de la ventana
     * @throws FileNotFoundException checked exception generada por la lectura de un archivo
     */
    
    public VistaInicio() throws FileNotFoundException {
        root = new BorderPane();
        FileInputStream imagen = new FileInputStream(Constants.RESOURCE_FOLDER+"/marte.jpg");
        Image ima = new Image(imagen);
        BackgroundImage myBI= new BackgroundImage(ima, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
        section = new VBox();
        panel= new FlowPane();
        panel.setAlignment(Pos.CENTER);
        root.setCenter(panel);
        sectionCenter();
    }
    
    /**
     * Este metodo crea los botones para ingresar a cada subventana del programa
     * y maneja el evento generando el scene.
     */
    
    
    public void sectionCenter() {
        Button b1= new Button("Explorar");
        Button b2= new Button("Planificar Rutas");
        Button b3= new Button("Ver Reporte");
        Button b4= new Button("Salir");
        section.getChildren().addAll(b1,b2,b3,b4);
        section.setSpacing(20);
        section.setAlignment(Pos.CENTER);
        panel.getChildren().add(section);
        
        //Explorar
        b1.setOnAction(
                (ActionEvent e)->{
                    
                    Stage stage = new Stage();
                    stage.setTitle("Explorando");
                    
                    VistaExplorar exp = new VistaExplorar();
                    Scene scene = new Scene(exp.getRoot(),1150,970);
                    stage.setScene(scene);
                    stage.show();
        
                    
                }
        );
        
        // Planificar
        
        b2.setOnAction((e)-> {
            Stage stage = new Stage();
            stage.setTitle("Planifica tu ruta");
                    VistaPlanificar exp = new VistaPlanificar();
                    Scene scene = new Scene(exp.getRoot(),500,500);
                    stage.setMinWidth(600);
                    stage.setMinHeight(600);
                    
                    stage.setScene(scene);
                    stage.show();
        });
        
        //Reporte
        b3.setOnAction(
                (ActionEvent e)->{
                    Stage stage = new Stage();
                    stage.setMinWidth(800);
                    stage.setMinHeight(600);
                    stage.setTitle("Reporte");
                    VistaReporte exp = new VistaReporte();
                    Scene scene = new Scene(exp.getRoot());
                    stage.setScene(scene);
                    stage.show();
                    
                }
        );
        
        //salir 
        b4.setOnAction((e)-> {
            Stage stage = (Stage) b4.getScene().getWindow();
           stage.close();

        });
    }
 
     /**
     * Este metodo devuelve el contenedor principal de la VistaReporte para generar scene
     * @return Pane retorna el Pane
     */
    
    public Pane getRoot(){
        return root;
    }
    
    
}
