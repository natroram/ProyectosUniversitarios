/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto2p;

import ec.edu.espol.clases.Arbol;
import ec.edu.espol.soporte.FileManager;
import ec.edu.espol.soporte.Graphics;
import ec.edu.espol.soporte.IndexFolder;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.SnapshotResult;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

/**
 *
 * @author Natalia Ramirez
 */
public class VistaApp {
    private BorderPane root;
    private File file;
    public String titulo;
    
    public VistaApp() {
        this.root = new BorderPane();
        root.setPadding(new Insets(10,10,10,10));
        root.setMaxSize(new Graphics().getWIDTH()+40, new Graphics().getHEIGHT()+90);
        root.setMinSize(new Graphics().getWIDTH()+40, new Graphics().getHEIGHT()+90);
        crearTop();
        
    }
    
    //metodo el cual crea y maneja todos los componentes gráficos de la interfaz correspondientes al root
    public void crearTop(){
        HBox contenedor = new HBox();
        Button enviar = new Button("ESCOGER DIRECTORIO");
        Button capturar = new Button("GUARDAR IMAGEN");
        capturar.setDisable(true);
        contenedor.setPadding(new Insets(5,5,5,5));
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setSpacing(30);
        contenedor.getChildren().addAll(enviar, capturar);
        
        root.setTop(contenedor);
        
        enviar.setOnAction( (e)-> {
            capturar.setDisable(false);
            DirectoryChooser directorios = new DirectoryChooser();
            file = directorios.showDialog(new Stage());//el usuario escoge directorio y se guarda en objeto file
            //System.out.println(file.getAbsolutePath());
            Arbol<IndexFolder, String> tree = new FileManager().getDirTree(file); //se obtiene el arbol a partir del directorio escogido
            //configuracion de título del stage
            titulo = "Estoy en el directorio: "+file.getName()+" de tamaño: "+transformacion(tree.getValor().getSize());
            App.cambiarTitulo(titulo);
            //se genera el pane con el treemap correspondiente y se lo agrega al root
            Pane treemap = new Graphics().generarRectangulos(tree);
            treemap.setMaxSize(new Graphics().getWIDTH(), new Graphics().getHEIGHT());
            root.setCenter(treemap);
            
            capturar.setOnAction((e1)->{
                capturarYGuardarDisplay();
                Label exito = new Label("La captura se ha guardado con éxito");
                root.setBottom(exito);
            });
            
        });
        
        
    }
    
    //método el cual tomará una captura de pantalla del root al ser llamado
    public void capturarYGuardarDisplay(){
        FileChooser filechooser = new FileChooser();
        
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));
        
        File file = filechooser.showSaveDialog(null);

    if(file != null){
        
            //Pad the capture area
            WritableImage writableImage = root.snapshot(new SnapshotParameters(), null);
            
            //RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
            //Write the snapshot to the chosen file
            //ImageIO.write(renderedImage, "png", file);
         
    }
    }
    
    public static void capturar (Node node) {
    try {
        final Bounds bounds = node.getLayoutBounds();
    
        int imageWidth = (int) Math.round(bounds.getWidth() );
        int imageHeight = (int) Math.round(bounds.getHeight() );
        final SnapshotParameters snapPara = new SnapshotParameters();
        snapPara.setFill(Color.TRANSPARENT);
        snapPara.setTransform(javafx.scene.transform.Transform.scale(1, 1));
        WritableImage snapshot = new WritableImage(imageWidth, imageHeight);
        snapshot = node.snapshot(snapPara, snapshot);
        
        
    } catch (Exception e) {
        
        
    }

    }
    
 
    
    /*metodo que recibe un long que representa un tamaño de archivo en bytes y retorna su conversión correspondiente
    a KB, MG, GB o TB*/
    public static String transformacion(Long bytes){
        
        if((bytes/1024) < 1024){
            return String.valueOf(bytes/1024)+" KB";
        }
        else if((bytes/(1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024)))+" MB";
        }
        else if((bytes/(1024*1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024*1024)))+" GB";
        }
        else if((bytes/(1024*1024*1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024*1024*1024)))+" TB";
        }
        /*else if((bytes/(1024*1024*1024*1024*1024)) < 1024){
            return String.valueOf((int)(bytes/(1024*1024*1024*1024)))+" TB";
        }*/
        
        return String.valueOf(bytes)+" Bytes";
    }
    
    
    public BorderPane getRoot(){
        return this.root;
    }

    
}
