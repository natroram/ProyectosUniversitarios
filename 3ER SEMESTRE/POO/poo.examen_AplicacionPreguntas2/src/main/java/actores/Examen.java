/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;
import actores.Categoria;
import actores.Pregunta;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.*;
/**
 *
 * @author Hp Corporations
 */
public class Examen {
    /**
     * Retorna un List<Categorias> 
     * @return 
     */
    public static List<Categoria> obtenerCategorias() throws IOException{
        List<Categoria> catg = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(CONSTANTES.ruta_archivos+"categorias.txt"))){
            String linea;
            while((linea=bf.readLine())!=null){
                String p[]=linea.split(",");
                catg.add(new Categoria(p[0].trim(),p[1].trim()));
            }
        } 
        return catg;
        
    }
    
    /**
     * Retorna un List<Pregunta> dada una categoria
     * @return 
     */
    public static List<Pregunta> obtenerPreguntas(Categoria c) throws IOException, ClassNotFoundException{
        String nombre_categoria = c.getNombre();
        try(ObjectInputStream objin = new ObjectInputStream(
                new FileInputStream(CONSTANTES.ruta_archivos+nombre_categoria))){
            return (List<Pregunta>)objin.readObject();
        }
        
    }
}
