/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import constantes.CONSTANTES;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.CuentaBancaria;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class CuentasData {
    private static String ARCHIVOCUENTAS = CONSTANTES.RUTARECURSOS+"/cuentas.txt";
    
    /**
     * Metodo que lee el archivo de cuentas bancarias y retorna un ArrayList con  
     * las cuentas bancarias en el archivo
     * @return un ArrayList de CuentaBancaria con las cuentas bancarias del cliente
     * @throws java.io.ProblemasConArchivoException
     */
    public static List<CuentaBancaria>obtenerCuentasBancaria() 
            throws ProblemasConArchivoException{
        List<CuentaBancaria> cuentas = new ArrayList();
        try(BufferedReader br = 
                new BufferedReader(new FileReader(ARCHIVOCUENTAS))){
            List<Cliente> clientes = ClientesData.leerClientes();
            String l = null;
            while((l=br.readLine())!=null){
                String[] partes = l.split(",");
                String cedula = partes[2];
                Cliente cli = null;
                for(Cliente c : clientes){
                    if(c.getCedula().equals(cedula)){
                        cli = c;
                    }
                }
                CuentaBancaria cu = new CuentaBancaria(partes[0], Double.parseDouble(partes[1]), cli);
                cuentas.add(cu);
        }
        return cuentas;
        }catch(FileNotFoundException ex){
            throw new ProblemasConArchivoException(ARCHIVOCUENTAS,"Archivo no existe");
        }catch(IOException ex){
            throw new ProblemasConArchivoException(ARCHIVOCUENTAS,ex.getMessage());
        }
    }
    
    /**
     * Metodo que agrega una cuenta al archivo de cuentas bancarias
     * @param cuenta 
     */
    public static void agregarCuenta(CuentaBancaria cuenta,
            String cedula) throws ProblemasConArchivoException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVOCUENTAS, true))){
            String datos = cuenta.getNcuenta()+","+cuenta.getMonto()+","+cuenta.getCliente().getCedula();
            bw.write(datos);
        }catch(IOException ex){
            throw new ProblemasConArchivoException(ARCHIVOCUENTAS, ex.getMessage());
        }
    }
    
    
    public static void actualizarArchivo(List<CuentaBancaria> cuentas)
        throws ProblemasConArchivoException{
        
    }
}
