/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import Data.Constants;
import Data.CrateresData;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import utilidades.Reporte;

/**
 *
 * @author User
 */
public class VistaReporte {
    public BorderPane root;
    public TableView<Reporte> table;
    public HBox search;
    public ObservableList<Reporte> repActualizado;
    
    /**
     * Constructor de la clase que inicializa los contenedores de y llama a los metodos 
     * que crean cada seccion.
     */
    
    public VistaReporte(){
        root = new BorderPane();
        BackgroundFill myBF = new BackgroundFill(Color.ORANGERED.darker().desaturate(), new CornerRadii(1),
         new Insets(0.0,0.0,0.0,0.0));
        this.repActualizado = FXCollections.observableArrayList();
        root.setBackground(new Background(myBF));
        table = new TableView();
        table.setMinSize(600, 400);
        table.setMaxSize(600, 400);
        search = new HBox();
        search.setAlignment(Pos.CENTER);
        seccionFiltro();
        seccionBusqueda();
        root.setTop(search);
        root.setCenter(table);
        root.setPadding(new Insets(6,6,6,6));
        BorderPane.setMargin(root, new Insets(6));  
    }
    
    /**
     * Este metodo genera la seccion superior de la ventana donde el usuario ingresa  
     * la fecha de inicio, final y minerales por los que se va a filtrar.
     */
    
    private void seccionFiltro(){
        Label fechaI = new Label("Fecha Inicio  ");
        fechaI.setTextFill(Color.WHITE);
        fechaI.setFont(new Font(15));
        TextField inicio = new TextField();
        
        HBox ingreso1 = new HBox();
        ingreso1.getChildren().addAll(fechaI, inicio);
        
        Label fechaF = new Label("Fecha Final  ");
        fechaF.setTextFill(Color.WHITE);
        fechaF.setFont(new Font(15));
        TextField finalf = new TextField();
        manejadorFC(finalf, inicio);
        
        HBox ingreso2 = new HBox();
        ingreso2.getChildren().addAll(fechaF, finalf);
        
        Label mineral = new Label("Mineral          ");
        mineral.setTextFill(Color.WHITE);
        mineral.setFont(new Font(15));
        TextField mine = new TextField();
        
        manejadorMine(mine);
        
        HBox ingresoM = new HBox();
        ingresoM.getChildren().addAll(mineral, mine);
        
        search.getChildren().addAll(ingreso1, ingreso2, ingresoM);
        search.setSpacing(6);
        search.setPadding(new Insets(6,6,6,6));
    }
    
    /**
     * Este metodo genera las columnas para el TableView y relaciona cada columna con la
     * variable de Reporte que va a ir ingresada.
     */
    
    private void seccionBusqueda(){
        table.setEditable(true);
        
        TableColumn<Reporte, LocalDate> fechaExplora = new TableColumn("Fecha Exploracion");
        fechaExplora.setCellValueFactory(new PropertyValueFactory<>("fechaExploracion"));
        fechaExplora.setMinWidth(200);
        
        TableColumn<Reporte, String> nombre = new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        nombre.setMinWidth(200);
        
        TableColumn<Reporte, String> minCol = new TableColumn("Minerales");
        minCol.setCellValueFactory(new PropertyValueFactory<>("mineral"));
        minCol.setMinWidth(200);
        
        table.getColumns().addAll(fechaExplora, nombre, minCol);
        table.getItems().addAll(getReporte());
        
        
    }
    
    /**
     * Esta funcion lee el archivo exploraciones.txt que se encuentra en 
     * el paquete recursos y retorna un ObservableList que se presentara en el TableView
     * @return ObservableList Reporte
     */
    
    public ObservableList<Reporte> getReporte(){
        ObservableList<Reporte> reportes = FXCollections.observableArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(Constants.nombre))){
            String linea;
            while((linea = br.readLine())!= null){
                String[] informacion = linea.split(",");
                String totalM = "";
                if(informacion.length < 3){
                    totalM = "";
                }
                else{
                    String[] minerales = informacion[2].split("/");
                    for(String m : minerales){
                        totalM = m + "\n" + totalM;
                    }
                }
                
                reportes.add(new Reporte(LocalDate.parse(informacion[1]), informacion[0],totalM)); 
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VistaReporte.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VistaReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        FXCollections.sort(reportes);
        
        
        return reportes;
    }
    
    /**
     * Este metodo filtra por fecha Inicio y FechaFin, recibe el ingreso por teclado del usuario
     * y selecciona la informacion del TableView que coincida con el ingreso
     * 
     * @param fecha_ini textfield que corresponde al label fecha inicio
     * @param fecha_fin textfield que corresponde al label fecha fin
     */
    
    public void manejadorFC(TextField fecha_ini, TextField fecha_fin){
        fecha_fin.setOnAction((e)->{
            ObservableList<Reporte> local = FXCollections.observableArrayList();
            table.getItems().clear();
            try {
            if(repActualizado.isEmpty()){
                for(Reporte re: getReporte()){
                
                if( (LocalDate.parse(fecha_fin.getText()).isBefore(re.getFechaExploracion())) ||  
                        (LocalDate.parse(fecha_fin.getText()).isEqual(re.getFechaExploracion()))){
                    table.getItems().add(re);
                    repActualizado.add(re);
                }
            }
            }
            
            else{
                for(Reporte re: repActualizado){
                
                if( (LocalDate.parse(fecha_fin.getText()).isBefore(re.getFechaExploracion())) ||  
                        (LocalDate.parse(fecha_fin.getText()).isEqual(re.getFechaExploracion()))){
                    table.getItems().add(re);
                    local.add(re);
                }
                this.repActualizado = local;
            }
            }
            }catch(DateTimeParseException ex) {
                    generaAlerta();
            }
            
        });
        
        fecha_ini.setOnAction((e)->{
            ObservableList<Reporte> local = FXCollections.observableArrayList();
            table.getItems().clear();
            try {
            if(repActualizado.isEmpty()){
                for(Reporte re: getReporte()){
                
                if( (LocalDate.parse(fecha_ini.getText()).isAfter(re.getFechaExploracion())) ||  
                        (LocalDate.parse(fecha_ini.getText()).isEqual(re.getFechaExploracion()))){
                    table.getItems().add(re);
                    repActualizado.add(re);
                }
            }
            }
            
            else{
                for(Reporte re: repActualizado){
                
                if( (LocalDate.parse(fecha_ini.getText()).isAfter(re.getFechaExploracion())) ||  
                        (LocalDate.parse(fecha_ini.getText()).isEqual(re.getFechaExploracion()))){
                    table.getItems().add(re);
                    local.add(re);
                }
                this.repActualizado = local;
            }
            }
            }catch(DateTimeParseException ex) {
                    generaAlerta();
            }
        });
    }
    
    /**
     * Este metodo filtra por mineral, recibe el ingreso por teclado del usuario
     * y selecciona la informacion del TableView que coincida con el ingreso
     * @param mine TextField que corresponde al label de minerales
     */
    
    public void manejadorMine(TextField mine){
        mine.setOnAction((e) -> {
            ObservableList<Reporte> local = FXCollections.observableArrayList();
            table.getItems().clear();
            try {
                if(repActualizado.isEmpty()){
                    for(Reporte re: getReporte()){
                        if( (mine.getText().equals("")) && (mine.getText().equals(re.getMineral()))   ){
                            table.getItems().add(re);
                            repActualizado.add(re);
                        }
                        else if ((!mine.getText().equals("")) && ((re.getMineral().toLowerCase().contains(mine.getText().toLowerCase()) )) ) {
                            table.getItems().add(re);   
                            repActualizado.add(re);
                        }
                    }
                }
                else{
                    for(Reporte re: repActualizado){
                        if( (mine.getText().equals("")) && (mine.getText().equals(re.getMineral()))   ){
                            table.getItems().add(re);
                            local.add(re);
                        }
                        else if ((!mine.getText().equals("")) && ((re.getMineral().toLowerCase().contains(mine.getText().toLowerCase()) )) ) {
                            table.getItems().add(re);   
                            local.add(re);
                        }
                        this.repActualizado = local;
                    }  
                }
            }catch(DateTimeParseException ex) {
                    generaAlerta();
            }
                
        });
    }
    /**
     * Metodo encargado de generar una ventana Emergente cuando se ingresa una fecha con formato incorrecta
     */
    public void generaAlerta () {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error ");
        alert.setHeaderText("Error Dialog");
        alert.setContentText("Ingrese una fecha con el siguiente formato YYYY-MM-DD");
        alert.showAndWait();
    } 
    
    /**
     * Este metodo devuelve el contenedor principal de la VistaReporte para generar scene
     * @return Pane
     */
    
    public Pane getRoot(){
        return root;
    }
}
