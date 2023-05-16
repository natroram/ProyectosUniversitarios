/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacionpeliculas.data;

import com.mycompany.aplicacionpeliculas.modelo.Genero;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author rociomera
 */
public class GeneroData {
    private static String FILE_PATH = Constants.RESOURCE_FOLDER+"/generos.txt";
    
     /**
     * Esta funcion lee el archivo generos.txt que se encuentra en 
     * el paquete recursos y retorna un ArrayList de generos
     * por el nombre 
     * FORMATO ARCHIVO
     *  nombre,codigo
     * @return 
     */
    public static ArrayList<Genero>cargarGeneros() throws IOException {
        ArrayList<Genero> ge = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while((linea=bf.readLine())!=null){
                String p[]=linea.split(";");
                ge.add(new Genero(p[0].trim(),p[1].trim()));
            }
        } 
        return ge;
    }
}
