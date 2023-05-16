/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Scanner;
import Pizzeria.PedidoPizza;
import Pizzeria.Pizza;
import Pizzeria.TamanioPizza;
/**
 *
 * @author rociomera
 */
public class Aplicacion {
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        System.out.println("Bienvenido ");
        
        //pida el nombre del cliente
        System.out.println("Ingrese el nombre del cliente");
        String cliente = sc.nextLine();
        
        
        //cree una nueva instancia de Pedidio
        //si se ingreso un string vacio para cliente
        //use el constructor que fija cliente a "Consumidor final"
        //caso contrario use el constructor que recibe el nombre del cliente
        PedidoPizza pedido = new PedidoPizza();
        
        if (cliente.isEmpty()){
        } else {
            pedido.setCliente(cliente);
        }
                
        int pizzasActuales;
        int CANTIDAD_MAXIMA = PedidoPizza.getCANTIDAD_MAXIMA();
                                     
        //pida los datos de la pizza
        String continuar;
        do{
            //pedida datos de la pizza
            System.out.println("Ingrese tamaño de la pizza: ");
            TamanioPizza tamanio = Enum.valueOf(TamanioPizza.class, sc.nextLine().toUpperCase());
            System.out.println("Ingrese numero de ingredientes: ");
            int ingredientes = sc.nextInt();
            sc.nextLine();            
            //crear la pizza y agregarla a la orden
            Pizza pizza = new Pizza(tamanio, ingredientes);
            pedido.agregarPizza(pizza);
            pizzasActuales = pedido.getPizzasActuales();
            

            System.out.println("Desea agregar otra pizza");
            continuar = sc.nextLine().toLowerCase();
        }while((continuar.equals("si")) && (pizzasActuales < CANTIDAD_MAXIMA));
        
        //muestre el pedido
        pedido.mostrarPedido();
        
    }
}
