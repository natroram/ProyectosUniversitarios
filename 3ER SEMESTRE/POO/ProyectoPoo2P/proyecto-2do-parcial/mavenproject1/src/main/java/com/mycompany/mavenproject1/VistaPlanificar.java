/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import Data.CrateresData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utilidades.Crateres;
import utilidades.Rover;

/**
 *
 * @author nicolepilco
 */
public class VistaPlanificar {
    public BorderPane root;
    public HBox nombreC;
    public TableView<Crateres> table;
    
   /**
     * Constructor de la clase que inicializa los contenedores de y llama a los metodos 
     * que crean cada seccion.
     */
    
    public VistaPlanificar(){
        root = new BorderPane();
        BackgroundFill myBF = new BackgroundFill(Color.ORANGERED.darker().desaturate(), new CornerRadii(1),
         new Insets(0.0,0.0,0.0,0.0));
        root.setBackground(new Background(myBF));
        nombreC = new HBox();
        craterN();
        nombreC.setAlignment(Pos.CENTER);
        root.setTop(nombreC);

        table = new TableView();
        table.setMaxSize(400, 500);
        informacion();
        root.setCenter(table);
        root.setPadding(new Insets(6,6,6,6));
        BorderPane.setMargin(root, new Insets(6));
    }
    
    /**
     * Este metodo genera la seccion superior de la ventana donde se ingresan los nombres
     * de los crateres que se quieren visitar
     */
    
    private void craterN(){
        Text titulo = new Text();
    
        titulo.setText("Ingrese nombres de los crateres:");
        titulo.setFill(Color.WHITE);
        titulo.setFont(new Font(15));
        TextField crater = new TextField();
        manejadorBuscar(crater);
        nombreC.getChildren().addAll(titulo, crater);
        nombreC.setSpacing(6);
        nombreC.setPadding(new Insets(6,6,6,6));
        
        
    }
    /**
     * Esta funcion lee el archivo crateres_info.txt que se encuentra en 
     * el paquete recursos y retorna un ObservableList conla informacion de cada crater
     * @return ObservableList Crateres
     */
    
    public ObservableList<Crateres> getNombres(){
        ObservableList<Crateres> nombre = FXCollections.observableArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader("recursos/crateres_info.txt"))){
            String line;
            
            while((line = br.readLine()) != null){
                String[] cadena = line.split(",");
                nombre.add(new Crateres(cadena[1]));
                
            }
            
        }catch(FileNotFoundException e1){
            System.out.println(e1.getMessage());
            
        }catch(IOException e2){
            System.out.println(e2.getMessage());
        }
        return nombre;
    }
    
    /**
     * Este metodo genera las columnas para el TableView y relaciona cada columna con la
     * variable de Crateres que va a ir ingresada.
     */
    
    private void informacion(){
        table.setEditable(true);
        TableColumn<Crateres,String> nombres = new TableColumn("Lista de crateres");
        nombres.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombres.setMinWidth(400);
        
        table.getColumns().add(nombres);
        table.getItems().addAll(getNombres());
    }
    
    /**
     * Este metodo recibe los crateres que el usuario quiere visitar y busca la mejor ruta
     * para visitarlos dependiendo de la ubicacion del rover
     * @param texto textField al cual se le colocara el evento
     */
    
    public void manejadorBuscar(TextField texto){
        texto.setOnAction((e)->{
            table.getItems().clear();
            String[] cadena = texto.getText().split(",");
            ArrayList<Crateres> explorar = new ArrayList<>();
            try {
                CrateresData.arregloCrateres();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            for(String c: cadena){
                Crateres select = CrateresData.getMapa().get(c.toLowerCase().trim());
                if(select!= null){
                    explorar.add(select);
                }
                
            }
            
            double latitudR = Rover.posX;
            double longitudR = Rover.posY;
            ObservableList<Crateres> ordenados = FXCollections.observableArrayList();
            while(!explorar.isEmpty()){
                Crateres cercano = null;
                for(Crateres c:explorar){
                    if(cercano == null){
                        cercano = c;
                    }else{
                        double distanciaC = Math.hypot(c.getLatitud()-latitudR, c.getLongitud()-longitudR);
                        double distanciaCercano = Math.hypot(cercano.getLatitud()-latitudR, cercano.getLongitud()-longitudR);
                        if(distanciaC< distanciaCercano){
                            cercano = c;
                        
                        }       
                    }
                }
                ordenados.add(cercano);
                latitudR = cercano.getLatitud();
                longitudR = cercano.getLongitud();
                explorar.remove(cercano);
            }
            table.getItems().clear();
            table.getItems().addAll(ordenados);
            
            table.refresh();
        });
        
    }
    
    /**
     * Este metodo devuelve el contenedor principal de la VistaReporte para generar scene
     * @return Pane
     */
    
    public Pane getRoot(){
        return root;
    }
}
