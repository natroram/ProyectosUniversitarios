/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pago;

/**
 *
 * @author Natalia Ramirez
 */
public class PagoPaypal extends MetododePago{
    private String nombreusuario;
    private String contraseña;
    private double fondos;
    
    
    public PagoPaypal(String nombreusuario, String contraseña, double pago){
        super(pago);
        this.nombreusuario = nombreusuario;
        this.contraseña = contraseña;
        
    }
    public double generaValor(){
        double fondos = Math.random()*900+100;
        this.fondos = fondos;
        return fondos;
    }
    
    @Override
    public boolean procesarPago(){
        double fondos = generaValor();
        if (fondos > super.getPago()){
            return true;
        }
        return false;
    }
    
   
}
