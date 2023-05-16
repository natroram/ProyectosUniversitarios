/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.soporte;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import ec.edu.espol.clases.Arbol;

/**
 *
 * @author Claudio Olvera
 */
public class FileManager {
    
    //metodo que crea un arbol multicamino a partir de un directorio de archivos
    public Arbol<IndexFolder,String> getDirTree(File dir){
        //para usar este metodo previamente debes validar la ruta
        //el metodo se muere si se usa en carpetas que requieran ser administrador
        Arbol<IndexFolder,String> t = new Arbol(new IndexFolder(dir.length()),dir.getName());
        for(File f: dir.listFiles()){
            if(f.isFile()){
                if(f!=null){
                    t.getValor().contarArchivo(f);
                }
            }
            if(f.isDirectory()){
                Arbol<IndexFolder,String> subtree = this.getDirTree(f);
                t.getValor().sumarDirectorios(subtree.getValor());
                t.AddHijo(subtree);
            } 
        }
        return t;
    }
    
    //retorna el nombre de la carpeta correspondiente a la ruta enviada
    public String getFolderName(String route){
        System.out.println("Llegue aki");
        File f = new File(route);
        return f.getName();
    }
    
    /**
     * Valida si la ruta corresponde a un directorio
     * @param route ruta a validar
     * @return true si es un directorio, false si la ruta no existe o es un archivo
     */
    public boolean routeValidate(String route){
        File dir = new File(route);
        if(dir!=null){
            if(dir.isDirectory()){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Lista los Subdirectorios
     * @param route Ruta a listar
     * @return Arreglo de Strings con el nombre de los subdirectorios
     */
    public String[]getSubdirectories(String route){
        File dir = new File(route);
        if(dir!=null){
            if(dir.isDirectory()){
                return dir.list();
            }
        }
        return null;
    }
    
    
}
