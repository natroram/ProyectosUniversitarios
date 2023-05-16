/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.examen.principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.examen.principal.VistaExamen;

/**
 *
 * @author Hp Corporations
 */
public class Principal extends Application {    
    //private static Map<Categoria, List<Pregunta>> lista = new HashMap<>();
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new VistaExamen().getRoot(), 800, 550);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        launch(args);
        
    }
    


  
}
