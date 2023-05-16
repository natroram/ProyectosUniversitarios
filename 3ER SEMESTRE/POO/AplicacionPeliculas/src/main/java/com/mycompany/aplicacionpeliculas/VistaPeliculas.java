/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacionpeliculas;

import com.mycompany.aplicacionpeliculas.data.Constants;
import com.mycompany.aplicacionpeliculas.data.GeneroData;
import com.mycompany.aplicacionpeliculas.data.PeliculaData;
import com.mycompany.aplicacionpeliculas.modelo.Genero;
import com.mycompany.aplicacionpeliculas.modelo.Pelicula;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rociomera
 */
public class VistaPeliculas{
    public BorderPane root;
    public FlowPane paneListPeliculas;
    public VBox detallePelicula;
     
    
    public VistaPeliculas(){
        try{
            root = new BorderPane();
            root.setPadding(new Insets(20, 20, 20, 20));
            
            createTop();
            
            paneListPeliculas = new FlowPane();
            root.setCenter(paneListPeliculas);
            
            detallePelicula = new VBox();
            root.setRight(detallePelicula);
        }
        catch(IOException|RuntimeException ex){
            root.getChildren().clear();
            String s = "Ha ocurrido un errorn \n";
            s += ex.getMessage();
            root.setCenter(new Label(s));
        }
    }
    
    private void createTop() throws IOException{
        HBox paneTop = new HBox();
        paneTop.setPadding(new Insets(10,10,10,10));
        
        ComboBox<Genero> cpelicula = new ComboBox();
        
        cpelicula.setItems(FXCollections.observableArrayList(
                GeneroData.cargarGeneros()));
        
        paneTop.getChildren().addAll(new Label("Géneros: "), cpelicula);
        
        root.setTop(paneTop);
        
        cpelicula.setOnAction(
                (e)->{
                    try{
                        Genero ge = cpelicula.getValue();
                        mostrarPeliculas(ge);
                    }
                    catch(IOException ex){
                        throw new RuntimeException(ex.getMessage());
                    }
                }
        );
    }
    
    public void mostrarPeliculas(Genero g) throws IOException{
        paneListPeliculas.getChildren().clear();
        
        ArrayList<Pelicula> peliculas = PeliculaData.cargarPelicula(g);
        for(Pelicula p: peliculas){
            
            FileInputStream fi = new FileInputStream(Constants.RESOURCE_FOLDER+"/"+p.getImageName());
            Image img = new Image(fi);
            ImageView imgView = new ImageView(img);
            
            //nombre
            Label ln = new Label(p.getNombre());
            //anio
            Label anio = new Label(String.valueOf(p.getYear()));
            
            VBox vboxp = new VBox(imgView, ln, anio);
            vboxp.setAlignment(Pos.CENTER);
            vboxp.setSpacing(10);
            vboxp.setPadding(new Insets(5));
            paneListPeliculas.getChildren().add(vboxp);
            
            
            vboxp.setOnMouseClicked(
                    (e)->{
                try {
                    detallePelicula.getChildren().clear();
                    
                    ImageView imgView2 = new ImageView(img);
                    
                    HBox h1 = new HBox();
                    h1.getChildren().addAll(new Label("Nombre: "), new Label(p.getNombre()));
        
                    HBox h2 = new HBox();
                    h2.getChildren().addAll(new Label("Director: "), new Label(p.getDirector()));
        
                    HBox h3 = new HBox();
                    h3.getChildren().addAll(new Label("Year: "), new Label(String.valueOf(p.getYear())));
                    
                    HBox h0 = new HBox();
                    
                    for(int i = 0; i < p.getRating(); i++){
                        FileInputStream rating = new FileInputStream(Constants.RESOURCE_FOLDER+"/"+"star.png");
                        ImageView imgRating = new ImageView(new Image(rating));
                        imgRating.setFitHeight(20);
                        imgRating.setFitWidth(20);
                        h0.getChildren().add(imgRating);
                    }
                    detallePelicula.getChildren().addAll(imgView2, h0, h1, h2, h3);
                    
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
                        
                        
                    }
            );
        }
    }
    public Pane getRoot(){
        return root;
    }
    
}
