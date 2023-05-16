/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioMovimiento2;


import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

/**
 * Clase que crea los componentes de la aplicacion MovingShape
 * @author rociomera
 */
public class VistaPrincipal {    
    private BorderPane _root;
    private Pane _contenedorFigura; //panel en el que estara la elipse que desplzaremos
    private Rectangle _rectangle; //elispse que se despalzara
    
    public VistaPrincipal() {
       _root = new BorderPane();
       seccionTitulo(); //metodo que crea la seccion del titulo
       seccionFigura(); //metodo encargado de crear la sección de la figura
       seccionBotones(); //metodo encargado de crear la sección de los botones
       seccionControles(); //metodo que crea la seccion de los controles
    }
    
    public Pane getRoot() {
        return _root;
    }
    
    private void seccionTitulo() {
        Label l = new Label("Ejemplo Movimiento");
        HBox hbox = new HBox(l);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        _root.setTop(hbox);
    }
    
    private void seccionFigura() {
      //crear un contenedor de tipo Pane, 

     
    }
    
    private void seccionBotones() {
        //crear el HBox, 
        //crear los botones, 
        //agregar los botones al HBox, 
        //agregar HBox al botton del _root, 
        //fijar la accion a los botones
        HBox botonesContenedor = new HBox();
        Button bleft = new Button("izquierda");
        Button bright = new Button("derecha");
        botonesContenedor.getChildren().addAll(bleft,bright);
        botonesContenedor.setPadding(new Insets(20));
        botonesContenedor.setSpacing(10);
        botonesContenedor.setAlignment(Pos.BASELINE_CENTER);
        botonesContenedor.setStyle("-fx-background-color: #CCE5FF;");
        _root.setBottom(botonesContenedor);
        
    }
    
    public void seccionControles(){
        
    }
}
