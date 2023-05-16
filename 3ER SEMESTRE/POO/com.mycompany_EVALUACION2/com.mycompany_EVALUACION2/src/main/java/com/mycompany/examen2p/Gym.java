package com.mycompany.examen2p;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *  @autor:rociomera
 */
public class Gym extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new VentanaEntrenamientos().getRoot(),600,500);
        stage.setTitle("Poli Gym");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}