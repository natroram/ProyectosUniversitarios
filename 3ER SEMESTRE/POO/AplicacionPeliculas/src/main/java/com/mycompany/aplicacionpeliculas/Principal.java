/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacionpeliculas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class Principal extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        VistaPeliculas pn = new VistaPeliculas();
        Scene sc = new Scene(pn.getRoot(),600,600);
        
        primaryStage.setScene(sc);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
