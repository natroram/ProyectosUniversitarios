package com.mycompany.tallercontrolgastosp1;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        
        HBox seccionlabel = new HBox();
        Label l = new Label("Formulario de gastos");
        seccionlabel.getChildren().add(l);
        root.getChildren().add(seccionlabel);
        seccionlabel.setAlignment(Pos.CENTER);
        
        GridPane formularioBox = new GridPane();
        formularioBox.add(new Label("Categoria"), 0, 0);
        List<String> categorias = Arrays.asList("SALUD", "COMIDA", "TRANSPORTE");
        ComboBox<String> combocategorias = new ComboBox(FXCollections.observableArrayList(categorias));
        formularioBox.add(combocategorias, 1, 0);
        
        TextField textmonto = new TextField();
        textmonto.setMaxSize(400, 70);
        formularioBox.addRow(1, new Label("Monto"), textmonto);
        
        TextArea textdescripcion = new TextArea();
        textdescripcion.setMaxSize(400,140);
        formularioBox.addRow(2, new Label("Description"), textdescripcion);
        
        formularioBox.setHgap(15);
        formularioBox.setVgap(15);
        root.getChildren().add(formularioBox);
        
        //Tarea 4
        HBox botonacciones = new HBox();
        Button btn1 = new Button("Limpiar");
        Button btn2 = new Button("Guardar");
        Button btn3 = new Button("Cancelar");
        
        btn1.setAlignment(Pos.CENTER);
        btn2.setAlignment(Pos.CENTER);
        btn3.setAlignment(Pos.CENTER);
        
        botonacciones.getChildren().add(btn1);
        botonacciones.getChildren().add(btn2);
        botonacciones.getChildren().add(btn3);
        
        botonacciones.setSpacing(10);
        root.getChildren().add(botonacciones);
        
        //Tarea 5
        HBox mensaje = new HBox();
        Label inicial = new Label("Bienvenido");
        mensaje.getChildren().add(inicial);
        inicial.setAlignment(Pos.BASELINE_RIGHT);
        root.getChildren().add(mensaje);
        
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Aplicacion Gastos");
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}