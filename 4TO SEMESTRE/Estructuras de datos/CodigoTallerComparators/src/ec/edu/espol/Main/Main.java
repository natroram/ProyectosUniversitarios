/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Main;

import ec.edu.espol.ArrayList.ArrayList;
import ec.edu.espol.List.List;
import ec.edu.espol.SimplyLinkedList.LinkedList;
import java.util.Iterator;

/**
 *
 * @author ggmendez
 */

//Natalia Ramírez - Paralelo 1

public class Main {

    public static void main(String[] args) {

        
        Customer c = new Customer("Quito", "Old", "Gonzalo Mendez", 25);
        
        Customer limit_inf = new Customer("", "New", "limite inferior", 20);
        Customer limit_sup = new Customer("", "New", "limite superior", 30);
        
        Customer tope = new Customer("Nanegal", "Old", "tope ciudad con N", 18);
        
        ArrayList<Customer> customers_A = loadCustomers();
        
        LinkedList<Customer> customers_L = loadCustomersL();

        List<Customer> results_equals = customers_L.findAll((Customer c1, Customer c2) -> {
            if (c1.getCity().equals(c2.getCity())) {
                return 0;
            } else {
                return 1;
            }
        }, c);
        
        System.out.println("Prueba LinkedList clientes con ciudad Quito\n");
        createIterator(results_equals);
        System.out.println("\n");
        
        List<Customer> results_greater = customers_L.findGreaterThan((Customer c1, Customer c2) -> {
            if (c1.getAge() > c2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }, c);
        
        System.out.println("Prueba LinkedList clientes mayores a 25 años\n");
        createIterator(results_greater);
        System.out.println("\n");
        
        List<Customer> results_lower = customers_L.findLowerThan((Customer c1, Customer c2) -> {
            char ini_c1 = c1.getCity().charAt(0);
            char ini_c2 = c2.getCity().charAt(0);
            if (ini_c1 < ini_c2) {
                return -1;
            } else {
                return 0;
            }
        }, tope);
        
        System.out.println("Prueba LinkedList clientes con ciudades inicial antes de la N\n");
        createIterator(results_lower);
        System.out.println("\n");
        
        List<Customer> results_between = customers_L.findBetween((Customer c1, Customer c2) -> {
            if(c1.getAge() > c2.getAge()){
                return 1;   
            } else if(c1.getAge() < c2.getAge()){
                return -1;
            } else{
                return 0;
            }
        }, limit_inf, limit_sup);
        
        System.out.println("Prueba LinkedList clientes entre 20 y 30 años\n");
        createIterator(results_between);
        System.out.println("\n");

        System.out.println("--------- MISMAS PRUEBAS PARA ARRAYLIST EN MISMO ORDEN -----------\n");
        
        List<Customer> results_equalsA = customers_A.findAll((Customer c1, Customer c2) -> {
            if (c1.getCity().equals(c2.getCity())) {
                return 0;
            } else {
                return 1;
            }
        }, c);
        
        System.out.println("Prueba ArrayList clientes con ciudad Quito\n");
        createIterator(results_equalsA);
        System.out.println("\n");
        
        List<Customer> results_greaterA = customers_A.findGreaterThan((Customer c1, Customer c2) -> {
            if (c1.getAge() > c2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }, c);
        
        System.out.println("Prueba ArrayList clientes mayores a 25 años\n");
        createIterator(results_greaterA);
        System.out.println("\n");
        
        List<Customer> results_lowerA = customers_A.findLowerThan((Customer c1, Customer c2) -> {
            char ini_c1 = c1.getCity().charAt(0);
            char ini_c2 = c2.getCity().charAt(0);
            if (ini_c1 < ini_c2) {
                return -1;
            } else {
                return 0;
            }
        }, tope);
        
        System.out.println("Prueba ArrayaList clientes con ciudades inicial antes de la N\n");
        createIterator(results_lowerA);
        System.out.println("\n");
        
        List<Customer> results_betweenA = customers_A.findBetween((Customer c1, Customer c2) -> {
            if(c1.getAge() > c2.getAge()){
                return 1;   
            } else if(c1.getAge() < c2.getAge()){
                return -1;
            } else{
                return 0;
            }
        }, limit_inf, limit_sup);
        
        System.out.println("Prueba ArrayList clientes entre 20 y 30 años\n");
        createIterator(results_betweenA);
        System.out.println("\n");

    }
    
    public static void createIterator(List<Customer> lista){
        Iterator<Customer> iterator = lista.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public static ArrayList<Customer> loadCustomers() {

        ArrayList<Customer> customers = new ArrayList<>();
        customers.addLast(new Customer("Guayaquil", "New", "Lorena Salinas", 35));
        customers.addLast(new Customer("Guayaquil", "New", "Gabriel Poveda", 25));
        customers.addLast(new Customer("Quito", "New", "Susana Vaca", 29));
        customers.addLast(new Customer("Quito", "New", "Yolanda Martinico", 34));
        customers.addLast(new Customer("Salina", "New", "Alberto Paredes", 27));
        customers.addLast(new Customer("Cuenca", "New", "Janina Figueroa", 30));
        customers.addLast(new Customer("Cuenca", "New", "Ximena Aragundi", 28));
        customers.addLast(new Customer("Ambato", "Old", "Daniel Torres", 29));
        customers.addLast(new Customer("Ambato", "Old", "Rigoberto Martínez", 18));
        customers.addLast(new Customer("Guayaquil", "Old", "Whashington González", 25));
        customers.addLast(new Customer("Guayaquil", "Old", "Luis Muñoz", 22));
        customers.addLast(new Customer("Machala", "Old", "José Haro", 21));
        customers.addLast(new Customer("Machala", "Old", "Luis García", 27));
        customers.addLast(new Customer("Machala", "Old", "Pedro Salazar", 32));
        customers.addLast(new Customer("Quito", "New", "María Fernández", 33));
        customers.addLast(new Customer("Quito", "New", "Josué Hernández", 25));
        customers.addLast(new Customer("Quito", "New", "Fabricio Ontaneda", 21));
        customers.addLast(new Customer("Guayaquil", "Old", "José Márquez", 24));
        customers.addLast(new Customer("Quito", "New", "Verónica Parra", 18));
        customers.addLast(new Customer("Quito", "New", "María Ortiz", 21));
        customers.addLast(new Customer("Guayaquil", "Old", "Jaime Mejía", 24));
        customers.addLast(new Customer("La Libertad", "New", "Aureliano Salazar", 19));
        customers.addLast(new Customer("Santa Elena", "Old", "Claudia Paredes", 20));
        customers.addLast(new Customer("Salinas", "New", "Ignacio Vera", 23));
        customers.addLast(new Customer("Guayaquil", "New", "Manuel Cáceres", 33));
        return customers;

    }
    
    public static LinkedList<Customer> loadCustomersL() {

        LinkedList<Customer> customers = new LinkedList<>();
        customers.addLast(new Customer("Guayaquil", "New", "Lorena Salinas", 35));
        customers.addLast(new Customer("Guayaquil", "New", "Gabriel Poveda", 25));
        customers.addLast(new Customer("Quito", "New", "Susana Vaca", 29));
        customers.addLast(new Customer("Quito", "New", "Yolanda Martinico", 34));
        customers.addLast(new Customer("Salina", "New", "Alberto Paredes", 27));
        customers.addLast(new Customer("Cuenca", "New", "Janina Figueroa", 30));
        customers.addLast(new Customer("Cuenca", "New", "Ximena Aragundi", 28));
        customers.addLast(new Customer("Ambato", "Old", "Daniel Torres", 29));
        customers.addLast(new Customer("Ambato", "Old", "Rigoberto Martínez", 18));
        customers.addLast(new Customer("Guayaquil", "Old", "Whashington González", 25));
        customers.addLast(new Customer("Guayaquil", "Old", "Luis Muñoz", 22));
        customers.addLast(new Customer("Machala", "Old", "José Haro", 21));
        customers.addLast(new Customer("Machala", "Old", "Luis García", 27));
        customers.addLast(new Customer("Machala", "Old", "Pedro Salazar", 32));
        customers.addLast(new Customer("Quito", "New", "María Fernández", 33));
        customers.addLast(new Customer("Quito", "New", "Josué Hernández", 25));
        customers.addLast(new Customer("Quito", "New", "Fabricio Ontaneda", 21));
        customers.addLast(new Customer("Guayaquil", "Old", "José Márquez", 24));
        customers.addLast(new Customer("Quito", "New", "Verónica Parra", 18));
        customers.addLast(new Customer("Quito", "New", "María Ortiz", 21));
        customers.addLast(new Customer("Guayaquil", "Old", "Jaime Mejía", 24));
        customers.addLast(new Customer("La Libertad", "New", "Aureliano Salazar", 19));
        customers.addLast(new Customer("Santa Elena", "Old", "Claudia Paredes", 20));
        customers.addLast(new Customer("Salinas", "New", "Ignacio Vera", 23));
        customers.addLast(new Customer("Guayaquil", "New", "Manuel Cáceres", 33));
        return customers;

    }

}
