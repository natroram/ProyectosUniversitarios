/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pizzeria;

/**
 *
 * @author computron
 */
public class PedidoPizza {
    private String cliente;
    private int pizzasActuales;
    private static final int CANTIDAD_MAXIMA = 3;
    private Pizza pizza1;
    private Pizza pizza2;
    private Pizza pizza3;
    
    public PedidoPizza(String cliente){
        this.cliente = cliente;
    }
    
    public PedidoPizza(){
        this.cliente = "Consumidor Final";
    }
    
    public String getCliente(){
        return this.cliente;
    }
    
    public int getPizzasActuales(){
        return this.pizzasActuales;
    }
    
    public static int getCANTIDAD_MAXIMA(){
        return CANTIDAD_MAXIMA;
    }
    
    public Pizza getPizza1(){
        return this.pizza1;
    }
    
    public Pizza getPizza2(){
        return this.pizza2;
    }
    
    public Pizza getPizza3(){
        return this.pizza3;
    }
    
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    
    public boolean agregarPizza(Pizza pizza){
        
        switch (pizzasActuales){
            case 0:
                this.pizza1 = pizza;
                pizzasActuales+=1;
                return true;
                
            case 1:
                this.pizza2 = pizza;
                pizzasActuales+=1;
                return true;
            case 2:
                this.pizza3 = pizza;
                pizzasActuales+=1;
                return true;
            default:
                System.out.println("La cantidad máxima de pizzas en un pedido es 3");
                return false;
                
        }
        
    }
    
    public int calcularTotal(){
        int total = 0;
        switch (pizzasActuales){
            case 3:
                total = this.pizza1.calcularCosto() + this.pizza2.calcularCosto() + 
               this.pizza3.calcularCosto();
                return total;
            case 2:
                total = this.pizza1.calcularCosto() + this.pizza2.calcularCosto();
                return total;
            case 1:
                total = this.pizza1.calcularCosto();
                return total;
            default:
                total = 0;
                return total;
        }          
    }
    
    public void mostrarPedido(){
        
        System.out.println("NombreCliente: " + this.cliente);
        System.out.println("Número de pizzas: " + this.pizzasActuales);
        switch (pizzasActuales){
            case 3:
                System.out.println(pizza1.toString());
                System.out.println(pizza2.toString());
                System.out.println(pizza3.toString());
                break;
            case 2:
                System.out.println(pizza1.toString());
                System.out.println(pizza2.toString());
                break;
            case 1:
                System.out.println(pizza1.toString());
                break;
            default:
                System.out.println("No hay pizzas pedidas");
        }
        System.out.println("Total a pagar: " + calcularTotal());
    }
}
