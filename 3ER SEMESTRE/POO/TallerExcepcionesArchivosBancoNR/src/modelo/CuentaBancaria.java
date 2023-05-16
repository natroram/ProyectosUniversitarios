/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.excepciones.NoHayFondosExcepcion;


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

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    @Override
    public String toString(){
        return numero_cuenta+" "+String.valueOf(monto)+" "+cliente.getCedula()+" "+cliente.getNombre();
    }
    
    public void depositarDinero(double cantidad){
        if(cantidad <= 0) throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero");
        this.monto += cantidad;            
    }
    
    public void retirarDinero(double cantidad) throws NoHayFondosExcepcion{
        if(cantidad > monto) throw new NoHayFondosExcepcion();
        this.monto -= cantidad;
    }
    
    
}
