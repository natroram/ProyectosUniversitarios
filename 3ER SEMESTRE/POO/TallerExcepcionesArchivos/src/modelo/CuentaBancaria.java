/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author rociomera
 */
public class CuentaBancaria {
    private String numero_cuenta;
    private double monto;
    private Cliente cliente;
    
    public CuentaBancaria(String numero_cuenta,double monto, Cliente c){
        this.numero_cuenta = numero_cuenta;
        this.monto = monto;
        this.cliente = c;
    }

    public String getNcuenta() {
        return numero_cuenta;
    }
    
    public double getMonto() {
        return monto;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public String toString(){
        return numero_cuenta+" "+monto+" "+cliente.getCedula()+" "+cliente.getNombre();
    }
    
    
    
}
