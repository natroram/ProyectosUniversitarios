/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tarea02_nataliaramirez;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Natalia Ramirez
 */
public class MainController implements Initializable {
    @FXML LineChart<String,Long> chart;
//    @FXML TextArea text_rec;
//    @FXML TextArea text_it;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ejecutar(){
        MejoresMetodos f = new MejoresMetodos();
        f.generateInput();
        ArrayList<Long> brute = f.datosFuerzaBruta();
        ArrayList<Long> mochila = f.datosMochila();
//        ArrayList<Long> mapas = f.datosMapas();
        
//        text_rec.clear();
//        text_it.clear();
        chart.getData().clear();
        
        XYChart.Series<String,Long> serie_rec = new XYChart.Series<>();
        serie_rec.setName("Fuerza Bruta");
        XYChart.Series<String,Long> serie_it = new XYChart.Series<>();
        serie_it.setName("Mochila");
//        XYChart.Series<String,Long> serie_mapa = new XYChart.Series<>();
//        serie_mapa.setName("Usando Mapa");
        for(int i = 0; i < brute.size(); i++){
            serie_rec.getData().add(new XYChart.Data<String,Long>(String.valueOf(f.entradas[i]), (brute.get(i)/1000)));
            serie_it.getData().add(new XYChart.Data<String,Long>(String.valueOf(f.entradas[i]), (mochila.get(i)/1000)));
//            serie_mapa.getData().add(new XYChart.Data<String,Long>(String.valueOf(f.entradas[i]), (mapas.get(i)/1000)));
//            text_it.setText(String.valueOf(ordenar.get(i)/1000));
//            text_rec.setText(String.valueOf(heaps.get(i)/1000));
            //text_rec.setText(String.valueOf(mapas.get(i)/1000));
        }
        
        chart.getData().addAll(serie_rec, serie_it);
        
    }
}
