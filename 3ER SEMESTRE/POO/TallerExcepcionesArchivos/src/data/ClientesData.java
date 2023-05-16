/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import constantes.CONSTANTES;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class ClientesData {
    private static String ARCHIVOCLIENTES = CONSTANTES.RUTARECURSOS+"/clientes.txt";
    
    /**
     * Lee el archivo de texto clientes.txt con la informacion de los clientes del 
     * banco y retorna un ArrayList de objetos de tipo Cliente
     * @return
     * @throws ProblemasConArchivoException 
     */
    public static List<Cliente> leerClientes() throws ProblemasConArchivoException{
        List<Cliente> clientes = new ArrayList<>();
        try(BufferedReader br = 
                new BufferedReader(new FileReader(ARCHIVOCLIENTES))){
            String l = null;
            while((l=br.readLine())!=null){
                String[] partes = l.split(",");
                Cliente c = new Cliente(partes[1], partes[0]);
                clientes.add(c);
            }
            return clientes;
        }catch(FileNotFoundException ex){
            throw new ProblemasConArchivoException(ARCHIVOCLIENTES,"Archivo no existe");
        }catch(IOException ex){
            throw new ProblemasConArchivoException(ARCHIVOCLIENTES,ex.getMessage());
        }
    }
    
    
    
    
}
