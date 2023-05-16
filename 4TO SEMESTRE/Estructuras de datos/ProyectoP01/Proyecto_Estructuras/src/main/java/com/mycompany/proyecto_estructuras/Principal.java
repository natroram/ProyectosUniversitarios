/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_estructuras;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pantallas.VistaPantalla;

/**
 *
 * @author david
 */
public class Principal extends Application {

    
    
    @Override
    public void start(Stage stage) throws Exception {
        VistaPantalla vista = new VistaPantalla();
        stage.setScene(new Scene(vista.getMenu_inicio()));
        stage.show();
    }
    
    public static void main(String args[]){
        Application.launch(args);
    }
}
