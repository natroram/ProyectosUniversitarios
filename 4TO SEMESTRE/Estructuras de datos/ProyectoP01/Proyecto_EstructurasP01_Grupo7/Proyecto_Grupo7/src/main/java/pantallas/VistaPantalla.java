/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import com.mycompany.proyecto_grupo7.App;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import soldado.Soldado;
import tdas_linkedlist.CircularLinkedList;

/**
 *
 * @author david
 */
public class VistaPantalla {
    //Sistema sis = new Sistema();
    private BorderPane root;
    private HBox base_inicio;
    //private ImageView fondo;
    private Button empezar;
    
    private Pane contenido;
    private Label titulo;
    private CircularLinkedList<Soldado> soldados;
    private Slider cantidadSoldados;
    private Label cantidadSelec;
    private Slider posicionInicio;
    private Pane imagenesSoldado;
    private HBox opciones;
    private HBox direccion;
    private Label direc = new Label("Escoger direccion:");
    private ToggleGroup grupoDirec = new ToggleGroup();
    private RadioButton izquierda = new RadioButton("Izquierda");
    private RadioButton derecha = new RadioButton("Derecha");
    private ImageView fondo2;
    private Button simular;
    private ToggleButton goLeft;
    private ToggleButton goRight;
    private StackPane stack;
    
    
    public VistaPantalla() {
        try {
            ImageView fondo = new ImageView(new Image(new FileInputStream("src/Imagenes/fondo.jpg"),700,600,false,false));
            root = new BorderPane();
            root.setPadding(new Insets(10, 10, 10, 10));
            base_inicio = new HBox();
            this.base_inicio.setAlignment(Pos.TOP_CENTER);
            cantidadSoldados = new Slider(2, 20, 5);
            cantidadSoldados.setMajorTickUnit(1);
            cantidadSoldados.setShowTickLabels(true);
            cantidadSoldados.setShowTickMarks(true);
            cantidadSoldados.setSnapToTicks(true);
            cantidadSelec = new Label("Número de soldados: ");
            posicionInicio = new Slider(1, 5, 1);
            base_inicio.getChildren().addAll(cantidadSelec, cantidadSoldados);
            direccion = new HBox(5);
            direccion.setAlignment(Pos.CENTER);
            ToggleGroup toogles = new ToggleGroup();
            goLeft = new ToggleButton("Izquierda");
            goRight = new ToggleButton("Derecha");
            goLeft.setToggleGroup(toogles);
            goRight.setToggleGroup(toogles);
            direccion.getChildren().addAll(goLeft, goRight);
            VBox panel = new VBox();
            panel.setAlignment(Pos.TOP_CENTER);
            panel.setSpacing(20);
            panel.setPadding(new Insets(10,10,10,10));
            panel.getChildren().addAll(base_inicio, empezar,direccion);
            
            stack = new StackPane();
            stack.getChildren().addAll(fondo);
            root.setCenter(stack);
            root.setRight(panel);
            empezar = new Button("Empezar");
            empezar.setOnMouseClicked(e -> {
                Sistema sis = new Sistema(this);
                sis.start();
                
            });
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontró el archivo");;
        }
        
            
        soldados = new CircularLinkedList<>();
        imagenesSoldado = new Pane();
        if(imagenesSoldado.getChildren() == null){
        imagenesSoldado.getChildren().clear();
        }
        double centrox = 0;
        double centroy = 125;
        double espacio = 360 / cantidadSoldados.getValue();
        int c = 0;
        int tamx = 0, tamy = 0;
        System.out.println(cantidadSoldados.getValue());
        
        
        if (cantidadSoldados.getValue() <= 5) {
            tamx = 150;
            tamy = 150;
        } else if (cantidadSoldados.getValue() <= 10) {
            tamx = 100;
            tamy = 100;
        } else if (cantidadSoldados.getValue() <= 15) {
            tamx = 75;
            tamy = 75;
        } else {
            tamx = 50;
            tamy = 50;
        }
        
        
        //agregando soldados a la lista
        for (int i = 0; i < cantidadSoldados.getValue(); i++) {
            Soldado soldado = new Soldado(centrox, centroy, tamx, tamy);
            soldados.addLast(soldado);
        }
        System.out.println(soldados.size());
        
        //agregando soldados en rotacion
        for (Soldado sol : soldados) {
            
            //System.out.println(sol.isAlive());
            Rotate eje = new Rotate();
            eje.setPivotX(centrox);
            eje.setPivotY(centroy);
            eje.setAngle(espacio);

            sol.getCuerpo().setLayoutX(0);
            sol.getCuerpo().setLayoutY(50);

            sol.getCuerpo().getTransforms().add(eje);
            eje.setAngle(eje.getAngle() * c);
 
            c++;
            imagenesSoldado.getChildren().add(sol.getCuerpo());

        }
        
        stack.getChildren().add(imagenesSoldado);
        
        
        
    }

    /**
     * retorna el nodo principal que se presentara en la escena principal
     * @return 
     */
    public BorderPane getRoot() {
        return root;
    }

    
    public void Empezar(){
        //Principal.stage.setScene(new Scene(sis.getContenido(),1000,500));
    }
    
    public void agregarContenido() {
        
        soldados = new CircularLinkedList<>();
        imagenesSoldado.getChildren().clear();
        
        double centrox = 0;
        double centroy = 125;
        double espacio = 360 / Integer.parseInt(cantidadSelec.getText());
        int c = 0;
        int tamx = 0, tamy = 0;

        System.out.println(cantidadSelec.getText());
        
        
        if (Integer.parseInt(cantidadSelec.getText()) <= 5) {
            tamx = 150;
            tamy = 150;
        } else if (Integer.parseInt(cantidadSelec.getText()) <= 10) {
            tamx = 100;
            tamy = 100;
        } else if (Integer.parseInt(cantidadSelec.getText()) <= 15) {
            tamx = 75;
            tamy = 75;
        } else {
            tamx = 50;
            tamy = 50;
        }
        
        
        //agregando soldados a la lista
        for (int i = 0; i < Integer.parseInt(cantidadSelec.getText()); i++) {
            Soldado soldado = new Soldado(centrox, centroy, tamx, tamy);
            soldados.addLast(soldado);
        }
        System.out.println(soldados.size());
        
        //agregando soldados en rotacion
        for (Soldado sol : soldados) {
            
            //System.out.println(sol.isAlive());
            Rotate eje = new Rotate();
            eje.setPivotX(centrox);
            eje.setPivotY(centroy);
            eje.setAngle(espacio);

            sol.getCuerpo().setLayoutX(0);
            sol.getCuerpo().setLayoutY(50);

            sol.getCuerpo().getTransforms().add(eje);
            eje.setAngle(eje.getAngle() * c);
 
            c++;
            imagenesSoldado.getChildren().add(sol.getCuerpo());

        }
        


        
        
    }
    
    public Pane getContenido() {
        return this.contenido;
    }
    
    public Slider getPosicionInicio() {
        return posicionInicio;
    }
    
    public Slider getCantidadSoldados() {
        return cantidadSoldados;
    }
    
    public ToggleGroup getGrupoDirec(){
        return grupoDirec;
    }
    
    public RadioButton getDerecha(){
        return derecha;
    }
    
     public RadioButton getIzquierda(){
        return derecha;
    }
     
    public void iniciarContenido() {
        
    }
    
}
