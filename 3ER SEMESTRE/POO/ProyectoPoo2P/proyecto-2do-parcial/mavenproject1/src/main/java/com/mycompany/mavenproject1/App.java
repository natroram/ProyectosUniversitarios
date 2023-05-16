package com.mycompany.mavenproject1;

import Data.Constants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VistaInicio vi = null;
        try {
            vi = new VistaInicio();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
        Scene scene = new Scene(vi.getRoot(),800,640);
        
        try {
            stage.setMinWidth(800);
            stage.setMinHeight(640);
            stage.setMaxHeight(640);
            stage.setMaxWidth(920);

            stage.setScene(scene);
            stage.setResizable(false);
            Image icono = new Image(new FileInputStream(Constants.RESOURCE_FOLDER+"/logonasa.png"));
            
            stage.getIcons().add(icono);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }

    public static void main(String[] args) {
        launch();
    } 

}
