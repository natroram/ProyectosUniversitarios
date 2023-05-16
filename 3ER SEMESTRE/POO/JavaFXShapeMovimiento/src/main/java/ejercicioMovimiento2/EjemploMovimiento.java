/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioMovimiento2;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class EjemploMovimiento extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        VistaPrincipal mv = new VistaPrincipal();
        Scene scene = new Scene(mv.getRoot(),Constants.APP_WIDTH, Constants.APP_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MovingShape!");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}


