/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import data.ClientesData;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class PruebaClientes {
    public static void main(String[] args){
        List<Cliente> clientes;
        try {
            clientes = ClientesData.leerClientes();
            for(Cliente c : clientes){
                System.out.println(c);
            }
        } catch (ProblemasConArchivoException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
