/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import data.ClientesData;
import data.CuentasData;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.CuentaBancaria;
import modelo.excepciones.NoHayFondosExcepcion;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class Banco {
    public List<Cliente> clientes;
    public List<CuentaBancaria> cuentas;
    
    /**
     * Metodo que carga la informacion de clientes y cuentas en el sistema
     * @throws ProblemasConArchivoException cuando hay problemas al leer 
     * la informacion
     * de los archivos de clientes o cuentas
     */
    public Banco() throws ProblemasConArchivoException{
        //leer los datos de los clientes del banco y cargarlo en la lista clientes 
        clientes = ClientesData.leerClientes();
        //leer los datos de las cuentas del banco y cagarlos en la lista cuentas
        cuentas = CuentasData.obtenerCuentasBancaria();
    }
    
    /**
     * Retorna la informacion de un cliente dada su cedula
     * si el cliente no existe retorna null
     * @param cedula
     * @return el cliente con la cedula dada 
     */
    public Cliente buscarCliente(String cedula){
        //retorna el cliente de la cedula dada  
        for(Cliente c: clientes){
            if(c.getCedula().equals(cedula)){
                return c;
            }
        }
        return null;
    }
    
    /**
     * Crea una nueva cuenta bancaria para un cliente dada
     * @param numero
     * @param saldo 
     */
    public void crearCuenta(Cliente c, String numero, double saldo) 
            throws ProblemasConArchivoException{
        //cree un nuevo objeto de tipo cuenta
        CuentaBancaria cta = new CuentaBancaria(numero, saldo, c);
        //agregar el objeto al arreglo de cuentas
        cuentas.add(cta);
        //escribir la cuenta bancaria en el archivo llamando al 
        //metodo agregarCuenta de CuentasData
        CuentasData.agregarCuenta(cta);
    }
    
    /**
     * Retorna la informacion de una cuenta dada su numero
     * si la cuenta no existe retorna numer
     * @param numerocuenta
     * @return el cuenta con el numero dado 
     */
    public CuentaBancaria buscarCuenta(String numerocuenta){
        //retorna la cuenta con el numero dado
        for(CuentaBancaria cta : cuentas){
            if(cta.getNcuenta().equals(numerocuenta)){
                return cta;
            }
        }
        return null;
    }
    
    
    
    /**
     * Realiza el deposito del monto pasado como parametro a la cuenta
     * Maneje las excepciones que se pueden producir mostrando el mensaje 
     * de la excepcion producida en pantalla
     * @param numeroCuenta
     * @param monto a depositar
     */
    public void depositarDinero(CuentaBancaria cta, double monto) throws ProblemasConArchivoException{

        //llame al metodo depositarDinero de cta
        cta.depositarDinero(monto);
        //actualice el archivo cuentasBancarias llamando al metodo        
        //actualizarCuentas de CuentasData 
        CuentasData.actualizarCuentas(cuentas);
        //declare las excepciones de tipo checked que se pueden lanzar en la
        //firma del metodo
        
    }
    
    /**
     * Realiza el retiro del monto pasado como parametro a la cuenta
     * Maneje las excepciones que se pueden producir mostrando el mensaje 
     * de la excepcion producida en pantalla
     * @param cta
     * @param monto a retirar
     */
    public void retirarDinero(CuentaBancaria cta, double monto) throws NoHayFondosExcepcion, ProblemasConArchivoException{
        
        //llame al metodo retirarDinero de cta
        cta.retirarDinero(monto);
        //declare las excepciones de tipo checked que se pueden lanzar en la
        //firma del metodo                
        //actualice el archivo cuentasBancarias llamando al metodo 
        //actualizarCuentas de CuentasData
        CuentasData.actualizarCuentas(cuentas);
        //declare las excepciones de tipo checked que se pueden lanzar en la
        //firma del metodo
    }
    
    
}
