/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import com.mycompany.proyecto_estructuras.Principal;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    Sistema sis = new Sistema();
    private StackPane menu = new StackPane();
    private HBox base_inicio = new HBox(100);
    private ImageView fondo;
    private Button empezar = new Button("Empezar");
    
    private Pane contenido;
    private Label titulo;
    private CircularLinkedList<Soldado> soldados;
    private Slider cantidadSoldados;
    private Label cantidadSelec;
    private Slider posicionInicio;
    private Pane imagenesSoldado;
    private HBox opciones;
    private VBox direccion;
    private Label direccionSelec;
    private Button izquierda;
    private Button derecha;
    private ImageView fondo2;
    private Button simular;

    
    public VistaPantalla() {
        this.fondo = new ImageView(new Image("Imagenes/fondo", 1000, 500, false, false));
        this.base_inicio.setAlignment(Pos.TOP_CENTER);
        this.menu.getChildren().addAll(fondo, base_inicio);
        
        cantidadSoldados = new Slider(1, 20, 5);
        cantidadSelec = new Label("5");
        
        empezar.setOnMouseClicked(e->Empezar());
    }

    /**
     * retorna el nodo principal que se presentara en la escena principal
     * @return 
     */
    public StackPane getMenu_inicio() {
        return menu;
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
    
    public void iniciarContenido() {
        
    }
}
