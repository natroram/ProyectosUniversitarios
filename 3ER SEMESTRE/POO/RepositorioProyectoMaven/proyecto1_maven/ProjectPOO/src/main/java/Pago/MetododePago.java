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

    
    public MetododePago(){
        
    }
    
    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {    
        this.pago = pago;
    }
    /**
     * Metodo que permitira procesar una compra
     * @return true si la compra fue realizada con exito
     */
    public abstract boolean procesarPago();
    
    
}