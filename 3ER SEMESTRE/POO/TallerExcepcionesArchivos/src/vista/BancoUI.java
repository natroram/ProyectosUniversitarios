/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.Scanner;
import modelo.Cliente;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class BancoUI {
    private Banco b;
    private Scanner sc;
    
    public BancoUI(){
        try{
            sc = new Scanner(System.in);
            b = new Banco();
        }catch(ProblemasConArchivoException ex){
            //no podemos continuar sino podemos leer la informacion 
            //de los clientes, terminamos la ejecucion del programa
            System.out.println("Problema cargando informacion");
            System.out.println("Archivo: "+ex.getNombre_archivo());
            System.out.println(ex.getMessage());
            
        }
        
    }
    
    public void menuPrincipal(){
        String opcion="";
        do{
            mostrarPrincipal();
            System.out.println("Ingrese opcion");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    crearCuentaBancaria();
                    break;
                case "2":
                    retirarDinero();
                    break;
                case "3":
                    retirarDinero();
                    break;
            }
        }while(!opcion.equals("4"));
    }
    
    public void mostrarPrincipal(){
        System.out.println("1. Crear cuenta bancaria"); 
        System.out.println("2. Depositar Dinero"); 
        System.out.println("3. Retirar Dinero"); 
        System.out.println("4. Salir"); 
    }
    
    public void crearCuentaBancaria(){
        System.out.println("Ingrese cedula del cliente "); 
        //obtener el cliente a partir de la cedula, si el cliente no existe
        //imprima un mensaje y salga del metodo
        
        System.out.println("Ingrese numero de cuenta"); 
        
        //pida el numero de cuenta del que quiere realiza la transaccion
        System.out.println("Ingrese monto inicial de la cuenta"); 
        
        
        
    }
    
    
    public void depositarDinero(){
        System.out.println("Ingrese cedula del cliente "); 
        //obtener el cliente a partir de la cedula, si el cliente no existe
        //imprima un mensaje y salga del metodo
        
        
        
        //pida el numero de cuenta del que quiere realiza la transaccion
        System.out.println("Ingrese numero de cuenta"); 
        //obtener la cuenta del cliente
        
        
        //pida el monto a depositar
        double monto = sc.nextDouble();
        
        
        //mostrar el nuevo saldo de la cuenta
        
    }
    
    public void retirarDinero(){
        System.out.println("Ingrese cedula del cliente "); 
        //obtener el cliente a partir de la cedula, si el cliente no existe
        //imprima un mensaje y salga del metodo
        
        
        System.out.println("Ingrese numero de cuenta"); 
        //obtener la cuenta del cliente
        
        
        //pedir el monto a retirar
        double monto = sc.nextDouble();
        
        
        //mostrar el nuevo saldo de la cuenta
        
    }
}
