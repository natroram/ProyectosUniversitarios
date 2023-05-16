/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaespectaculosui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Compra;
import modelo.Funcion;
import modelo.espectaculo.Concierto;
import modelo.espectaculo.Espectaculo;
import sistemaespectaculos.EspectaculosEcuador;

/**
 *
 * @author rociomera
 */
public class ProcesarCompra {
    public static void main(String[] args){
        
        //1. crear instancia EspectaculosEcuador 
        EspectaculosEcuador espec = new EspectaculosEcuador();
        
        String continuar = "";
        do{
            //2. buscar espectaculo por nombre o por equipo y mostrar el resultado en
            //pantalla
            Scanner sc = new Scanner(System.in);
            System.out.println("Bienvenido");
            System.out.println("1. Consultar por nombre");
            System.out.println("2. Consultar por equipo");
            String opcion = sc.nextLine();
            
            ArrayList<Espectaculo> espectaculos= new ArrayList();
            
            if(opcion.equals("1")){
                System.out.println("Ingrese nombre");
                String nombre = sc.nextLine();
                espectaculos = espec.buscarEspectaculo(nombre);
            }else if(opcion.equals("2")){
                System.out.println("Ingrese equipo");
                String equipo = sc.nextLine();
                espectaculos = espec.buscarPartido(equipo);
            }
            //mostrar la informacion de los espectaculos 
            //que coincidieron con la busqueda
            for(Espectaculo es: espectaculos){
                System.out.println(es);
            }

            //3. pedir el codigo del espectaculo que se desea, obtenerlo
            //y mostrara las funciones del mismo
            //asuma que el cliente ingresa un codigo de espectaculo que existe
            //y esta dentro de los espectaculos devueltos por la busqueda anterior
            System.out.println("Ingrese codigo espectaculo");
            String codigoesp = sc.nextLine();
            
            Espectaculo chosen = null;
            for (Espectaculo e : espec.espectaculos){
                if (e.getCodigo().equals(codigoesp)){
                    chosen = e;
                    for (Funcion f : e.getFunciones()){
                        System.out.println(f);
                        System.out.println("Vendidos:"+espec.obtenerBoletosVendidos(f));
                    }
                    
                }
            }
            
            //4. pedir la fecha del espectaculo que se desea y obtenerlo 
            //asuma que el cliente ingresa la fecha en formato correcto y existe
            //un funcion para esa fecha para el espectaculo seleccionado
            System.out.println("Ingrese la fecha funcion que desea");
            String fecha = sc.nextLine(); //"dd-MM-yyyy HH:mm" -> 08-04-1986 12:30;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            LocalDateTime dateTime = LocalDateTime.parse(fecha, formatter);
            Funcion funcion = chosen.obtenerFuncion(dateTime);
            //5. pedir la cedula del cliente y obtener le cliente
            //asuma el cliente ingresa una cedula de un cliente registrado
            System.out.println("Ingrese cedula del cliente");
            String cedula = sc.nextLine(); 
            Cliente cliente = espec.buscarCliente(cedula);
            //6. pedir el numero de boletos a adquirir
            System.out.println("Ingrese numero boletos desados");
            int boletos = sc.nextInt();
            sc.nextLine(); //limpiamos el buffer

            //7. proceder a realizar la compra. Al final se debe imprimir si se pudo
            //o no hacer la compra
            if (espec.comprarBoleto(cliente, funcion, boletos)){
                System.out.println("Compra exitosa");
            }
            else{
                System.out.println("No se pudo realizar la compra");
            }
            
            System.out.println("Desea continuar");
            continuar = sc.nextLine();
        }while(continuar.equals("si"));
    }
}
