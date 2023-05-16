/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import data.ClientesData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.CuentaBancaria;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class Banco {
    public List<Cliente> clientes;
    public List<Cliente> cuentas;
    
    public Banco() throws ProblemasConArchivoException{
        //leer los datos de los clientes del banco y cargarlo en la lista clientes 
        
        //leer los datos de las cuentas del banco y cagarlos en la lista cuentas
        
    }
    
    /**
     * Retorna la informacion de un cliente dada su cedula
     * si el cliente no existe retorna null
     * @param cedula
     * @return el cliente con la cedula dada 
     */
    public Cliente buscarCliente(String cedula){
        //retorna el cliente de la cedula dada  
        return null;
    }
    
    /**
     * Crea una nueva cuenta bancaria para un cliente dada
     * @param numero
     * @param saldo 
     */
    public void crearCuenta(Cliente c, String numero, double saldo){
        //cree un nuevo objeto de tipo cuenta
        
        //agregar el objeto al arreglo de cuentas
        
        //escribir la cuenta bancaria en el archivo
    }
    
    public CuentaBancaria buscarCuenta(Cliente c, String numerocuenta){
        //retorna la cuentaBancaria del cliente
        return null;
    }
    
    
    
    /**
     * Realiza el deposito del monto pasado como parametro a la cuenta
     * Maneje las excepciones que se pueden producir mostrando el mensaje 
     * de la excepcion producida en pantalla
     * @param numeroCuenta
     * @param monto 
     */
    public void depositarDinero(CuentaBancaria cta, double monto){
        //obtener la cuenta bancaria
        
        //realizar el deposito
        
        //actualizar el archivo cuentasBancarias
    }
    
    /**
     * Realiza el retiro del monto pasado como parametro a la cuenta
     * Maneje las excepciones que se pueden producir mostrando el mensaje 
     * de la excepcion producida en pantalla
     * @param cta
     * @param monto 
     */
    public void retirarDinero(CuentaBancaria cta, double monto){
        //obtener la cuenta bancaria
        
        //realizar el retiro
        
        //actualizar el archivo cuentasBancarias
    }
    
    
}
