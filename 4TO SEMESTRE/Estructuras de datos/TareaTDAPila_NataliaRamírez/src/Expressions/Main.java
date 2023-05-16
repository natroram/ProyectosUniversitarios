/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expressions;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Natalia Ramirez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja opción que desea: ");
        System.out.println("1. Conversión de expresión infija a posfija");
        System.out.println("2. Evaluación de expresión posfija");
        System.out.print("Opción: ");
        String opcion = sc.nextLine();
        if(opcion.equals("1")){
            System.out.print("Ingrese expresión infija: ");
            String cadena = sc.nextLine().trim();
            System.out.println("Conversión a Posfija: " + conversionPosfija(cadena));
        }
        else if(opcion.equals("2")){
            System.out.print("Ingrese expresión posfija: ");
            String cadena = sc.nextLine().trim();
            System.out.println("El resultado es: " + evaluacionPosfija(cadena));
            
            System.out.println("*/-+".contains("*"));
        }
        
    }
    
    public static String conversionPosfija(String expresion){
        Stack<String> pila = new Stack<>();
        String[] partes = null;
        String currentTope = null;
        String concat = "";
        if(expresion.isBlank()){
            return "Error: se ingresó una expresión vacía";
        }
        else{
            partes = expresion.split(" ");
            
            for(String parte : partes){
                //System.out.println("parte: " + parte);
                if("+-*/^".contains(parte)){
                    if(pila.isEmpty()){
                        pila.push(parte);
                    }
                    else{
                        
                        currentTope = pila.peek();
                        int verificacion = verificarPrioridad(parte, currentTope);
                        while(verificacion == 1 && !pila.empty()){
                            concat = concat + pila.pop();
                            if(!pila.empty()){
                                currentTope = pila.peek();
                                verificacion = verificarPrioridad(parte, currentTope);
                            }
                            else{
                                concat = concat + parte;
                                verificacion = -1;
                            }
                        }
                        
                        pila.push(parte);
                    }
                }
                else{
                    if(parte.equals(partes[partes.length-1]) && !pila.empty()){
                        concat = concat + parte + " " + pila.pop();
                    }
                    else{
                        concat = concat + parte + " ";
                    }
                    System.out.println(concat);
                }
            }
        }
        return concat;
    }
    
    //Retorna 1 si el operador2 es de mayor prioridad que el operador1, caso contrario retorna 0
    public static int verificarPrioridad(String operador1, String operador2){
        switch(operador1){
            case "+":
                if("*/^".contains(operador2)){
                    return 1;
                }
                else{
                    return 0;
                }
                
            case "-":
                if("*/^".contains(operador2)){
                    return 1;
                }
                else{
                    return 0;
                }
                
            case "*":
                if("^".equals(operador2)){
                    return 1;
                }
                else{
                    return 0;
                }
                
            case "/":
                if("^".equals(operador2)){
                    return 1;
                }
                else{
                    return 0;
                }
            
            case "^":
                return 1;
        }
        return -1;
    }
    
    public static Double evaluacionPosfija(String expresion){
        Stack<Double> pila = new Stack<>();
        String[] partes = null;
        if(expresion.isBlank()){
            System.out.println("Error: se ingresó una expresión vacía");
            return -1.0;
        }
        else{
            partes = expresion.split(" ");
            Double tope1 = 0.0;
            Double tope2 = 0.0;
        
            for(String parte : partes){
                if(parte.equals("+") && pila.size()>=2){
                    tope1 = pila.pop();
                    tope2 = pila.pop();
                    pila.push(tope2 + tope1);
                }
                else if(parte.equals("-")&& pila.size()>=2){
                    tope1 = pila.pop();
                    tope2 = pila.pop();
                    pila.push(tope2 - tope1);
                }
                else if(parte.equals("*")&& pila.size()>=2){
                    tope1 = pila.pop();
                    tope2 = pila.pop();
                    pila.push(tope2 * tope1);
                }
                else if(parte.equals("/")&& pila.size()>=2){
                    tope1 = pila.pop();
                    tope2 = pila.pop();
                    pila.push(tope2 / tope1);
                }
                else if(parte.equals("^")&& pila.size()>=2){
                    tope1 = pila.pop();
                    tope2 = pila.pop();
                    pila.push(Math.pow(tope2, tope1));
                }
                else{
                    if(isNumeric(parte)){
                        pila.push(Double.parseDouble(parte));
                    }
                    else{
                        System.out.println("Error: la expresión contiene caracteres que no son ni numeros ni operandos");
                        return -1.0;
                    }
                }
            }
        }
        
        
        return pila.pop();
    }
    
    public static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    
}
