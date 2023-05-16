/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @autor: rociomera
 */
public class Entrenamiento {
    private String nombre;
    private List<Ejercicio> ejercicios;
    
    public Entrenamiento(String nombre, List<Ejercicio> ejercicios){
        this.nombre = nombre;
        this.ejercicios = ejercicios;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
    
    public static List<Entrenamiento> cargarEntrenamientos(String nomArchivo){
        List<Entrenamiento> entrenamientos = null;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader(CONSTANTS.path+nomArchivo))){
            line = br.readLine();
            while(line != null){
            List<Ejercicio> ejercicios = null;
            String[] entrenamiento = line.split(";");
            String nomEnt = entrenamiento[0];
            for(int num = 1; num < (entrenamiento.length); num++){
                String ejer = entrenamiento[num];
                String[] info = ejer.split(",");
                String nomEj = info[0];
                int reps = Integer.parseInt(info[1]);
                List<String> imagenes = null;
                imagenes.add(info[2]);
                imagenes.add(info[3]);
                Ejercicio ejercicio = new Ejercicio(nomEj, reps, imagenes);
                ejercicios.add(ejercicio);
            }
            Entrenamiento entren = new Entrenamiento(nomEnt, ejercicios);
            entrenamientos.add(entren);
            }
            return entrenamientos;
        } catch (IOException ex) {
            throw new GymException("Algo ocurrió");
        }
        
    }
    
    
}
