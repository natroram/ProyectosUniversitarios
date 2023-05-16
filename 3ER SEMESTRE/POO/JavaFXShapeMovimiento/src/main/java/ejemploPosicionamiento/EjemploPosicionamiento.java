/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploPosicionamiento;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class EjemploPosicionamiento extends Application{

    public void init(){
        System.out.println("Inicio");
    }
    
    public void stop(){
        System.out.println("fin");
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        Label l = new Label("label");
        TextField t = new TextField("");
        Button b = new Button("boton");
        
        l.setLayoutX(40);
        l.setLayoutY(60);
        
        t.setLayoutX(-80);
        t.setLayoutY(120);

        //HBox hb = new HBox(l,t,b);
        //hb.setStyle("-fx-spacing: 10px;"+
        //            "-fx-padding: 20px");
        //hb.getStyleClass().add("hbox");
        //VBox vb = new VBox(l,t,b);
        
        //FlowPane fp = new FlowPane(l,t,b);
        //StackPane st = new StackPane(l,t,b);
        Pane p = new Pane(l,t,b);
        
        Scene sc = new Scene(p,600,600);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
