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
     * @throws modelo.excepciones.ProblemasConArchivoException
     */
    public static List<CuentaBancaria>obtenerCuentasBancaria() 
            throws ProblemasConArchivoException{
        List<CuentaBancaria> cuentas = new ArrayList();
        try(BufferedReader br = 
                new BufferedReader(new FileReader(ARCHIVOCUENTAS))){
            String l = null;
            while( (l=br.readLine()) !=null ){
                //1111,13000,0909867652
                String[] partes = l.split(",");
                String cedula = partes[2].trim();
                List<Cliente> clientes = ClientesData.leerClientes();
                Cliente c = null;
                for(Cliente cli : clientes){
                    if(cedula.equals(cli.getCedula())){
                        c = cli;
                    }
                }
                CuentaBancaria cuenta = new CuentaBancaria(partes[0].trim(), Double.parseDouble(partes[1].trim()), c);
                cuentas.add(cuenta);
            }
            br.close();
            return cuentas;
        }catch(IOException ex){
            throw new ProblemasConArchivoException(ARCHIVOCUENTAS,ex.getMessage());
        }
    }
    
    /**
     * Metodo que agrega una cuenta al archivo de cuentas bancarias
     * @param cuenta 
     * @throws modelo.excepciones.ProblemasConArchivoException 
     */
    public static void agregarCuenta(CuentaBancaria cuenta) 
            throws ProblemasConArchivoException{
        try(BufferedWriter br = 
                new BufferedWriter(new FileWriter(ARCHIVOCUENTAS, true))){
            String datos = cuenta.getNcuenta()+","+cuenta.getMonto()+","+cuenta.getCliente().getCedula()+"\n";
            br.write(datos);
            br.close();
        }catch(IOException ex){
            throw new ProblemasConArchivoException(ARCHIVOCUENTAS,ex.getMessage());
        }
    }
    
    
    public static void actualizarCuentas(List<CuentaBancaria> cuentas)
        throws ProblemasConArchivoException{
        try(BufferedWriter br = 
                new BufferedWriter(new FileWriter(ARCHIVOCUENTAS))){
            for(CuentaBancaria cuenta : cuentas){
                String datos = cuenta.getNcuenta()+","+cuenta.getMonto()+","+cuenta.getCliente().getCedula()+"\n";
                br.write(datos);
            }
            br.close();
        }catch(IOException ex){
            throw new ProblemasConArchivoException(ARCHIVOCUENTAS,ex.getMessage());
        }
    }
}
