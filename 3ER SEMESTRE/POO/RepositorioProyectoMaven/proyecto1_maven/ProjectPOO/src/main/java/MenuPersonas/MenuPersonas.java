/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuPersonas;

import modelo.Utilidades;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nicolepilco
 */
public class MenuPersonas {
    public static int Validacion(){
	while (!Utilidades.sc.hasNextInt()) {
            Utilidades.sc.nextLine();
            System.out.println("valor invalido. Ingrese entero");
        }
	int i=Utilidades.sc.nextInt();
        Utilidades.sc.nextLine();
        return i;
        
    }
    /**
     * Metodo que verifica si una cedula es correcta usando el digito verificador
     * @param cedula  parametro a verificar
     * @return true o false
     */
    public static boolean validadorDeCedula(String cedula) {
     boolean cedulaCorrecta = false;
 
     try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
            int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
            if (tercerDigito < 6) {
            // Coeficientes de validación cédula
            // El decimo digito se lo considera dígito verificador
             int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
             int verificador = Integer.parseInt(cedula.substring(9,10));
             int suma = 0;
             int digito = 0;
            for (int i = 0; i < (cedula.length() - 1); i++) {
             digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
             suma += ((digito % 10) + (digito / 10));
            }

            if ((suma % 10 == 0) && (suma % 10 == verificador)) {
             cedulaCorrecta = true;
            }
            else if ((10 - (suma % 10)) == verificador) {
             cedulaCorrecta = true;
            } else {
             cedulaCorrecta = false;
            }
            } else {
            cedulaCorrecta = false;
            }
            } else {
            cedulaCorrecta = false;
            }
            } 
     catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
            } 
     catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validacion");
            cedulaCorrecta = false;
            }

     if (!cedulaCorrecta) {
            System.out.println("La Cedula ingresada es Incorrecta");
            }
     return cedulaCorrecta;
    }
    /**
     * Metodo que valida si un email es correcto o no
     * @param correo correo que ingresa el usuario
     * @return retorna un boolean true si el correo ingresado es valido, caso contrario retorna false
     */
    public static boolean validadoremail(String correo){
       boolean EmailCorrecto = false;
       // Patrón para validar el email
	Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" 
                                          + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
	    EmailCorrecto = true;
	} else {
	  System.out.println("El email ingresado es invalido.");
          EmailCorrecto = false;
	}
      return EmailCorrecto;
    }
/**
 * Metodo que valida si una cadena esta o no vacia
 * @param cadena objeto de tipo string 
 * @return true si la cadena esta vacia, caso contrario false
 */
    public static boolean validarVacio(String cadena){
      return cadena.trim().isEmpty();
    }
    
    /**
     * Metodo que valida el numero de tarjeta ingresado
     * @param numero numero de la tarjeta que ingresa el usuario
     * @return true si el numero es invalido, caso contrario false
     */
    public static boolean validadortarjeta(String numero) {
     boolean TCorrecta = false;
 
            if (numero.trim().isEmpty()){
                System.out.println("Tarjeta Invalida");
                TCorrecta   = true;
            }
            else{
              if (numero.matches("[0-9]*")== false) {
                  System.out.println("Tarjeta invalida, ingresar solo numeros");
                  TCorrecta   = true;  
                  }
              else{
                 if (numero.length() < 16 || numero.length() > 16) {
                    System.out.println("Tarjeta invalida, se esperan 16 digitos.");
                    TCorrecta   = true;
                  } 
              } 
            }
     return TCorrecta;
    }
    
    /**
     * Metodo que permite verificar si el numero ingresado cumple o no con las condiciones de un numero celular
     * @param numero numero el cual se va a comparar
     * @return true si el numero es invalido, caso contrario false
     */
    public static boolean validadorNumContacto(String numero) {
     boolean NumCorrecta = false;
 
            if (numero.trim().isEmpty()){
                System.out.println("Numero de contacto invalido");
                NumCorrecta   = true;
            }
            else{
              if (numero.matches("[0-9]*")== false) {
                  System.out.println("Numero de contacto invalido, ingresar solo numeros");
                  NumCorrecta   = true;  
                  }
              else{
                 if (numero.length() < 10 || numero.length() > 10) {
                    System.out.println("Numero de contacto invalido, se esperan 10 digitos.");
                    NumCorrecta   = true;
                  } 
              } 
            }
     return NumCorrecta;
    }
    
    /**
     * Metodo que verifica el codigo generado por la compra y enviado al correo del usuario
     * @param numero codigo de verificacion ingresado por el usuario
     * @return true si el codigo ingresado es invalido, caso contrario false
     */
    
    public static boolean validadorCodigoVeri(String numero) {
     boolean codigoCorrecta = false;
 
            if (numero.trim().isEmpty()){
                System.out.println("codigo invalido");
                codigoCorrecta   = true;
            }
            else{
              if (numero.matches("[0-9]*")== false) {
                  System.out.println("codigo invalido, ingresar solo numeros");
                  codigoCorrecta   = true;  
                  }
              else{
                 if (numero.length() < 5 || numero.length() > 5) {
                    System.out.println("Codigo invalido, se esperan 5 digitos.");
                    codigoCorrecta   = true;
                  } 
              } 
            }
    return codigoCorrecta;
    }
}
