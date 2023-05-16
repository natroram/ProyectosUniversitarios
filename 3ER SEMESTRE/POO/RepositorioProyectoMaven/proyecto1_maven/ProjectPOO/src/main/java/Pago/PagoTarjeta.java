/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pago;
import Correo.Mail;
import General.Comprador;
import static MenuPersonas.MenuPersonas.validadorCodigoVeri;
import modelo.Utilidades;
/**
 *
 * @author Natalia Ramirez
 */
public class PagoTarjeta extends MetododePago{
    private String tipoTarjeta;
    private String numTarjeta;
    private String nombreTarjeta;
    private Mail correo;
    private int cod;
    private int codIngresado;
    private String comCorreo;

    public PagoTarjeta(String tipoTarjeta, String numTarjeta, String nombreTarjeta, double pago, String comCorreo) {
        super(pago);
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        this.comCorreo = comCorreo;
    }
    
    /**
     * Constructor de PagoTarjeta que no recibe el monto a pagar (usar al colocar metodo de pago preferido)
     * @param tipoTarjeta tipo de la tarjeta de credito (visa, mastercard, diners)
     * @param numTarjeta numero de la tarjeta (16 digitos)
     * @param nombreTarjeta nombre del titular de la tarjeta
     * @param comCorreo correo electronico del comprador
     */
    public PagoTarjeta(String tipoTarjeta, String numTarjeta, String nombreTarjeta, String comCorreo){
        super();
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        this.comCorreo = comCorreo;
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

    public void setCodIngresado(int codIngresado) {
        this.codIngresado = codIngresado;
    }
    /**
    * Metodo que genera un numero aleatorio entre un rango especifico
    * @param min valor minimo que puede ser el numero
    * @param max valor maximo que puede ser el numero
    * @return retorna un int
    */
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /**
     * Metodo que procesa el pago de la compra generada, para eso envia un correo con una clave
     * que debe ser digitada por el usuario. Para que una compra se debe realizar el usuario debe ingresar el codigo que se le envio
     * y debe escribirlo correctamente, caso contrario no se hara efectiva la compra.
     * @return true si el pago se pudo realizar con exito.
     */
    
    @Override
    public boolean procesarPago(){
        this.cod = getRandomNumber(10000, 99000);
        this.correo = new Mail(comCorreo);
        correo.sendMail("Clave de confirmacion de compra", 
                "Estimado cliente:\n"
                + "La clave para confirmar la compra es:"+ cod);
        boolean valor = true;
        String codi = "00000";
        
        while(valor){
            System.out.println("Ingrese codigo de verificacion: ");
            codi = Utilidades.sc.nextLine();
            valor = validadorCodigoVeri(codi);
        }      
        this.codIngresado = Integer.parseInt(codi);
        if(cod == codIngresado){
            return true;
        }
        return false;
    }
    
    

    @Override
    public String toString() {
        return "PagoTarjeta{" + "numTarjeta=" + numTarjeta + '}';
    }
    
    
}
