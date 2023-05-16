/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Categoria.Categorias;

import java.util.Scanner;

/**
 *
 * @author Natalia Ramirez
 */
public class Utilidades {
    public static Scanner sc = new Scanner(System.in);


    /**
     * Metodo usado para validar e ingresar un double
     * @param promt texto a mostrarse por pantalla
     * @return double validado
     */
    public static double ingresoDouble(String promt){
        System.out.println(promt);
        while (!Utilidades.sc.hasNextDouble()) {

            Utilidades.sc.nextLine();
            System.out.println("valor invalido. Ingrese entero");
        }
        double i=Utilidades.sc.nextDouble();
        Utilidades.sc.nextLine();
        return i;
    }

    /**
     * Metodo usado para validar e ingresa Categorias
     * @return String perteneciente a una categoria
     */
    public static String ingresoCat(){
        String s="";
        while(!Categorias.contains(s)){
            System.out.println("Ingrese Categoria");
            s=sc.nextLine();
        }
        return s;
    }

    /**
     * ingreso de categoria validado con un texto mostrado por pantalla
     * @param promt texto mostrado por pantalla
     * @return String perteneciente a una categoria
     */
        public static String ingresoCat(String promt){
            String s="";
            while(!Categorias.contains(s)){
                System.out.println(promt);
                s=sc.nextLine();
            }
            return s;
        }

    //big brain nicole
}
