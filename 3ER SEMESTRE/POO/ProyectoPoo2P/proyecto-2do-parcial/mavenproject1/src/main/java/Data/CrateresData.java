/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Crateres;

/**
 *
 * @author User
 */
public class CrateresData {
    private static String FILE_PATH = Constants.RESOURCE_FOLDER+"/crateres_info.txt";
    public static String MINERALES = Constants.RESOURCE_FOLDER+"/minerales.txt";
    private static Map<String, Crateres> mapa = new HashMap<>();
    
    public static Map<String, Crateres> getMapa () {
        return mapa;        
    }
    
    /**
     * Esta funcion lee el archivo crateres_info.txt que se encuentra en 
     * el paquete recursos y retorna un ArrayList que contienen objetos de tipos crateres
     * @return ArrayList Crateres
     * @throws FileNotFoundException checked exception generada por la lectura de un archivo
     */
    
    

    public static ArrayList<Crateres> arregloCrateres() throws FileNotFoundException{
        ArrayList<Crateres> c = new ArrayList();
        try(BufferedReader bf = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while((linea=bf.readLine())!=null){
                String[] p = linea.split(",");
                Crateres craters= new Crateres(Integer.parseInt(p[0]), p[1],
                        Double.parseDouble(p[4]),Double.parseDouble(p[2]),
                        Double.parseDouble(p[3]) );
                c.add(craters);
                mapa.put(p[1].toLowerCase(),craters);
            }
        } catch (IOException ex) {
            Logger.getLogger(CrateresData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;        
    }
    
}
