/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.examen.principal;

import actores.CONSTANTES;
import actores.Pregunta;
import actores.Categoria;
import actores.Examen;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Hp Corporations
 */
public class VistaExamen {
    private VBox root;
    private int correctas;
    private int tTranscurridos;
    private Label lTiempo;
    private final int TIEMPO_MAX = 60;
    private int len_lista = Integer.MAX_VALUE;
    private VBox seccion_preg;
    private HBox hb;
    
    public VistaExamen() {
        correctas = 0;
        this.root = new VBox(10);
        this.lTiempo = new Label("0");
        this.seccion_preg = new VBox();
        this.hb = new HBox();
        root.setSpacing(20);
        
        try {
            crearTop();
        } catch (IOException | RuntimeException ex ) {
            root.getChildren().clear();
            root.getChildren().add(new Label("Algo ocurrio"));
            root.getChildren().add(new Label(ex.getMessage()));
        }
        
    }
    
    public void crearTop() throws IOException{
      HBox h1= new HBox(new Label("Tiempo: "), lTiempo);
      root.getChildren().add(h1);
      //crear combo con las categorias
      ComboBox<Categoria> categorias = new ComboBox();
      categorias.setItems(FXCollections.observableArrayList(Examen.obtenerCategorias()));
      HBox h2 = new HBox(new Label("Categorias: "), categorias);
      root.getChildren().add(h2);
      VBox seccion_img = new VBox();
      seccion_img.setAlignment(Pos.CENTER);
      
      //VBox seccion_preg = new VBox();
      seccion_preg.setAlignment(Pos.CENTER);
      seccion_preg.setSpacing(15);
      
      categorias.setOnAction(
              (ActionEvent eh)->{
          try {
              TimeRunnable tr = new TimeRunnable();
              Thread th1 = new Thread(tr);
              th1.start();
              
              seccion_preg.getChildren().clear();
              categorias.setDisable(true);
              Categoria c = categorias.getValue();
              List<Pregunta> preguntas = Examen.obtenerPreguntas(c);
              
              //seccion imagen - estatico
              Image catImg = new Image(new FileInputStream(CONSTANTES.ruta_imagenes+c.getImagen()), 300, 300, true, true);
              ImageView catImgV = new ImageView(catImg);
              Label catNom = new Label(c.getNombre());
              seccion_img.getChildren().add(catImgV);
              root.getChildren().add(seccion_img);
              
              //creando seccion de boton continuar y label de verificacion de respuesta
              //HBox hb = new HBox();
              hb.setAlignment(Pos.CENTER);
              hb.setSpacing(30);
              Button bt2 = new Button("Continuar");
              
              mostrarPreguntaAzar(preguntas, seccion_preg, hb, bt2);
              
              /*root.getChildren().add(seccion_preg);
              root.getChildren().add(hb);*/
              
              bt2.setOnAction(
                      (ActionEvent e)->{
                          this.len_lista = preguntas.size();
                          System.out.println(len_lista);
                          hb.getChildren().clear();
                          seccion_preg.setDisable(false);
                          if(len_lista>0){
                            mostrarPreguntaAzar(preguntas, seccion_preg, hb, bt2);
                          }
                      }
              );
                           
              root.getChildren().add(seccion_preg);
              root.getChildren().add(hb);
              
          } catch (IOException|ClassNotFoundException ex) {
                throw new RuntimeException(ex.getMessage());
          } 
              }
      );
    }
    
    public VBox getRoot() {
        return root;
    }
    
    public Pregunta obtenerPregunta(List<Pregunta> p){
        Pregunta pregunta;
        Random rd = new Random();
        int ind = rd.nextInt(p.size());
        pregunta = p.get(ind);
        p.remove(pregunta);
        return pregunta;
    }
    
    public void mostrarPreguntaAzar(List<Pregunta> preguntas, VBox seccion, HBox hb, Button button){
        //obtener pregunta al azar y su informacion: opciones, respuesta, texto
              seccion.getChildren().clear();
              Pregunta pregunta = obtenerPregunta(preguntas);
              List<String> opciones = pregunta.getOpciones();
              String respuesta = pregunta.getRespuesta();
              Label texto = new Label(pregunta.getTexto());
              seccion.getChildren().add(texto);
              
              //Crear botones para las opciones y agregar todos los elementos al contenedor
              for(String opcion : opciones){
                  Button bt = new Button(opcion);
                  seccion.getChildren().add(bt);
                  
                  bt.setOnAction(
                          (ActionEvent e)->{
                              seccion.setDisable(true);
                              if(bt.getText().equals(respuesta)){
                                  this.correctas += 1;
                                  Label lb = new Label("CORRECTO!");
                                  hb.getChildren().addAll(lb, button);
                              }
                              else{
                                  Label lb = new Label("INCORRECTO!");
                                  hb.getChildren().addAll(lb, button);
                              }
                              
                          }
                  );
                  //bt.setDisable(true);
              }
              
    }
    
    class TimeRunnable implements Runnable {
        public void run() {
             try {
                while(tTranscurridos<=TIEMPO_MAX && len_lista>0) {
                    tTranscurridos+=1;
                    Thread.sleep(1000);
                    Platform.runLater(()->  
                    {
                        lTiempo.setText(String.valueOf(tTranscurridos));
                    }
                );
                }
                if(tTranscurridos >= TIEMPO_MAX || len_lista == 0){
                    Platform.runLater(
                            ()->{
                                root.getChildren().remove(hb);
                                seccion_preg.getChildren().clear();
                                seccion_preg.getChildren().add(new Label("SE TERMINO EL TIEMPO - "+String.valueOf(correctas+" PREGUNTAS CORRECTAS")));
                                
                            }
                    );
                }
            }catch (InterruptedException ex) {
                    ex.printStackTrace();
            }
        }

 

    }
}
