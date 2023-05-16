/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import data.ClientesData;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.CuentaBancaria;
import modelo.excepciones.NoHayFondosExcepcion;
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
            System.out.println("Problemas cargando informacion");
            System.out.println("Archivo: "+ex.getNombre_archivo());
            System.out.println(ex.getMessage());
            System.exit(0);//no nos podemos recuperar - detenemos 
            //la ejecucion del programa
        }
    }
    
    public void menuPrincipal(){
        String opcion="";
        do{
            mostrarPrincipal();
            System.out.println("Ingrese opcion:");
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
                case "4":
                    System.out.println("Salir");
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
        String cedula = sc.nextLine();
        Cliente c = b.buscarCliente(cedula);
        if(c == null){
            System.out.println("Cliente no existe");
            return;
        }        
        //pida el numero de cuenta
        System.out.println("Ingrese numero de cuenta");
        String numero = sc.nextLine();
        //pida el monto inicial
        //manejamos las excepciones de tipo NumberFormatException
        boolean continuar = true;
        double saldo = 0;
        do{
            try{
                System.out.println("Ingrese monto inicial de la cuenta: ");
                saldo = Double.parseDouble(sc.nextLine());
                continuar = false;
            }catch(NumberFormatException ex){
                System.out.println("Monto inicial invalido");
            }            
        }while(continuar);
        try{
            b.crearCuenta(c, numero, saldo);
            System.out.println("Cuenta creada");            
        }catch(ProblemasConArchivoException ex){
            System.out.println("No se puede agregar la cuenta");
            System.out.println(ex.getMessage());
        }                
    }
    
    
    public void depositarDinero(){
        //pida el numero de cuenta del que quiere realiza la transaccion
        System.out.println("Ingrese numero de cuenta"); 
        //pida el numeo de cuenta, si la cuenta no existe
        //imprima un mensaje y salga del metodo
        String numero = sc.nextLine();
        CuentaBancaria cta = b.buscarCuenta(numero);
        if(cta == null){
            System.out.println("La cuenta no existe");
            return;
        }
        //pida el monto a depositar                       
        //llame al metodo depositarDinero de Banco
        //mostrar el nuevo monto de la cuenta
        //si se produce una excepcion de tipo IlegarlArgumentException 
        //vuelva a pedir el valor
        //si se produce una excepcion de tipo ProblemasConArchivoException,
        //muestre el mensaje de la excepcion y salga del metodo
        boolean continuar = true;
        double saldo = 0;
        do{
            try{
                System.out.println("Ingrese el monto a depositar");
                saldo = Double.parseDouble(sc.nextLine());
                b.depositarDinero(cta, saldo);
                System.out.println("Nuevo saldo: "+saldo);
                continuar = false;
            }catch(IllegalArgumentException ex){
                System.out.println("Monto ingresado invalido");
            }catch(ProblemasConArchivoException ex){            
            System.out.println(ex.getMessage());
            return;
        }            
        }while(continuar);                       
    }
    
    public void retirarDinero(){
        System.out.println("Ingrese numero de cuenta"); 
        ///pida el numeo de cuenta, si la cuenta no existe
        //imprima un mensaje y salga del metodo
        String numero = sc.nextLine();
        CuentaBancaria cta = b.buscarCuenta(numero);
        if(cta == null){
            System.out.println("La cuenta no existe");
            return;
        }        
        //pedir el monto a retirar                
        //llame al metodo retirarDinero de Banco
        //mostrar el nuevo monto de la cuenta
        //si se produce una excepcion de tipo IlegarlArgumentException 
        //vuelva a pedir el valor
        //si se produce una excepcion de tipo NoHayFondosExcepcion, muestre el 
        //el mensaje de la excepcion y salga del metodo
        //si se produce una excepcion de tipo ProblemasConArchivoException,
        //muestre el mensaje de la excepcion y salga del metodo
        boolean continuar = true;
        double monto = 0;
        do{
            try{
                System.out.println("Ingrese el monto a depositar");
                monto = Double.parseDouble(sc.nextLine());
                b.retirarDinero(cta, monto);
                System.out.println("Nuevo saldo: "+monto);
                continuar = false;
            }catch(IllegalArgumentException ex){
                System.out.println("Monto ingresado invalido");
            }catch(ProblemasConArchivoException ex){            
                System.out.println(ex.getMessage());
                return;
            }catch(NoHayFondosExcepcion ex){
                System.out.println(ex.getMessage());
                return;
            }            
        }while(continuar);
    }
}
