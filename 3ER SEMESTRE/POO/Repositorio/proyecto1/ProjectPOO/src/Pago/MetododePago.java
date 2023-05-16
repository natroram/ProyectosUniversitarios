/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pago;

/**
 *
 * @author User
 */
public abstract class MetododePago {
    private double pago;
    
    public MetododePago(double pago){
    this.pago = pago;
    }

    
    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {    
        this.pago = pago;
    }

    public abstract boolean procesarPago();
    
    
}