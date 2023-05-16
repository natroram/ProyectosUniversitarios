/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pago;
import Correo.Mail;
/**
 *
 * @author Natalia Ramirez
 */
public class PagoTarjeta extends MetododePago{
    private String tipoTarjeta;
    private String numTarjeta;
    private String nombreTarjeta;
    private Mail correo;

    public PagoTarjeta(String tipoTarjeta, String numTarjeta, String nombreTarjeta, double pago) {
        super(pago);
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.nombreTarjeta = nombreTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }
    
    public static int generarCod(){
        
        return 0;
    }
    
    public boolean procesarPago(){
        Double cod = Math.random();
        
        this.correo = new Mail("Código de verificación de compra", "Este es su código de verificación"
                + "de la compra efectuada. Ingreselo en el sistema para continuar con la compra."
                + "\n"+"Código: "+cod.toString(), "CORREO COMPRADOR");
        
        return false;
    }
    
    
    
}
