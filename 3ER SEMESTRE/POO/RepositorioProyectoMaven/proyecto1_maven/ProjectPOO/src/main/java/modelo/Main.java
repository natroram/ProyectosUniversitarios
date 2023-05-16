/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Pago.MetododePago;
import Ubicacion.Coordenadas;
import Ubicacion.Geocoding;
        

import java.util.Scanner;
import General.Comprador;
import General.Personas;
import General.Producto;
import General.Proveedor;
import static MenuPersonas.MenuCompradores.MenuComInicioSesion;
import static MenuPersonas.MenuCompradores.MenuComRegistro;
import MenuPersonas.MenuPersonas;
import static MenuPersonas.MenuPersonas.Validacion;
import static MenuPersonas.MenuProveedores.MenuProInicioSesion;
import static MenuPersonas.MenuProveedores.MenuProRegistro;
import java.util.ArrayList;
/**
 *
 * @author nicolepilco
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        Sistema sis = new Sistema();
        sis.inicializarSistema();
        while(opcion != 3){
            System.out.println("Bienvenido!");
            System.out.println("1.Registro");
            System.out.println("2. Iniciar Sesion");
            System.out.println("3.Salir");
            System.out.println("Ingrese un numero: ");
            opcion = Validacion();
            Personas usuarioLog;
            if(opcion== 1){
                int opc = 3;
                while(opc>2 || opc<= 0){
                    System.out.println("1.Comprador");
                    System.out.println("2.Proveedor");
                    System.out.print("Ingrese una opcion: ");
                    opc = Validacion();   
                    if(opc == 1){
                        MenuComRegistro(sis);
                    }
                    if(opc == 2){
                        MenuProRegistro(sis);
                    }if(opc>2 || opc<= 0){
                        System.out.println("Ingrese una opcion valida");
                    }
                }
            }
            if(opcion == 2){ 
                do{
                    System.out.println("Ingrese su nombre de usuario:");
                    String usuario = sc.nextLine();
                    System.out.println("Ingrese su clave:");
                    
                    String clave = sc.nextLine();
                    usuarioLog = sis.buscarUsuario(usuario, clave);
                    if(usuarioLog == null){
                        System.out.println("Su nombre de usuario o contrasenia son incorrectos");
                    }
                    }while (usuarioLog == null);
                    if(usuarioLog instanceof Proveedor){
                        MenuProInicioSesion(usuarioLog);
                    }else{
                        MenuComInicioSesion(usuarioLog, sis);
                    }
            
            }if(opcion< 1 || opcion> 4){
                System.out.println("Ingreso una opcion no valida");
            }

        }
    }
}
