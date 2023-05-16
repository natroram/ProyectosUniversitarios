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
    private String contrasena;
    private double fondos;
    
    /**
     * Constructor objeto Paypal
     * @param nombreusuario username de la cuenta de paypal del usuario
     * @param contrasena clave de la cuenta de paypal del usuario
     */
    public PagoPaypal(String nombreusuario, String contrasena){
        super();
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
    }
    
    
    public PagoPaypal(String nombreusuario, String contrasena, double pago){
        super(pago);
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
    }
   /**
    * Metodo que genera un numero aleatorio entre un rango especifico
    * @param min valor minimo que puede ser el numero
    * @param max valor maximo que puede ser el numero
    * @return retorna un double 
    */
    public double getRandomNumber(double min, double max) {
        return (double) ((Math.random() * (max - min)) + min);
    }
    /**
     * Metodo que genera los fondos del usuario de PayPal
     * @return los fondos del usuario
     */
    
    public double generaValor(){
        double fondos = getRandomNumber(100, 1000);
        this.fondos = fondos;
        return fondos;
    }    
   
   /**
    * Metodo que permite procesar la comprar
    * @return true en caso de que los fondos sean mayor al valor de pago
    */
    
    @Override
    public boolean procesarPago(){
        double fondos = generaValor();
        if (fondos > super.getPago()){
            return true;
        }
        return false;
    }
    

    @Override
    public String toString() {
        return "nombre= "+ nombreusuario+"fondos=" + fondos;
    }
   
}
