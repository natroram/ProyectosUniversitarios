/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aplicacionpeliculas.data;

import com.mycompany.aplicacionpeliculas.modelo.Genero;
import com.mycompany.aplicacionpeliculas.modelo.Pelicula;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rociomera
 */
public class PeliculaData {
    private static String FILE_PATH = Constants.RESOURCE_FOLDER+"/peliculas.txt";
    
    /**
     * Lee el archivos peliculas.txt y retornaun ArrayList<Pelicula> 
     * con las peliculas que pertenecen al genero pasado como parametro
     * FORMATO ARCHIVO
     *  nombre, codGenero, ano, rating, director, imagePath
     * @param ge: Genero
     * @return ArrayList<Pelicula>
     */
    public static ArrayList<Pelicula> cargarPelicula(Genero ge) throws IOException{
        ArrayList<Pelicula> pe = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while((linea=bf.readLine())!=null){
                System.out.println(linea);
                String p[]=linea.split(";");
                if(p[1].trim().equals(ge.getCodigo())){
                    pe.add(new Pelicula(ge,
                                            p[0].trim(),
                                            p[4].trim(),
                                            Integer.valueOf(p[3].trim()),
                                            p[5].trim(),
                                            Integer.valueOf(p[2].trim())
                                        ) 
                            );
                }
            }
        }
        return pe;
    }
}
