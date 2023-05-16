package com.mycompany.tareaarbolesexpresion_nataliaramirez;

import App.VistaApp;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        VistaApp vista = new VistaApp();
        
        stage.setScene(new Scene(vista.getRoot(),700,500));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}