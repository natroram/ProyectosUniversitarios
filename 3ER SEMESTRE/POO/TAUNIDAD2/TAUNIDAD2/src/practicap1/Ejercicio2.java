/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicap1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Ejercicio de práctica de objeto Wrapper a partir de un string
 *
 * @author 
 */
public class Ejercicio2 {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Double> difTemperatura = new ArrayList<>();
        String info = "15.8-18.9;16.6-19.2;15.5-21.2;14.8-20.1;16.2-18.9;15.4-19.5";
        //a partir de la variable info extraer las temperaturas y 
        //almacenar la diferencia en la lista difTemperatura
        String[] tempEquipos = info.split(";");
        
        for (String equipo : tempEquipos){
            String[] temps = equipo.split("-");
            double difTemp = (Double.valueOf(temps[1])) - ((Double.valueOf(temps[0])));
            difTemperatura.add(difTemp);
        }
        //Corrigiendo medicion del equipo 3
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese medicion correcta equipo 3: ");
        String medicion = sc.nextLine();
        difTemperatura.set(3, Double.valueOf(medicion));
        //Mostrando valor de equipo ingresado
        System.out.println("Ingrese numero de equipo 0-5: ");
        String valor = sc.nextLine();
        System.out.println("La diferencia de temperatura es: " 
                + difTemperatura.get(Integer.valueOf(valor)));
        //luego mostrar en pantalla la temparatura de cada equipo
        int i = 0;
        for (Double temp : difTemperatura){
            i = difTemperatura.indexOf(temp);
            System.out.println("Equipo "+i + ", diferencia de temperatura: " +temp);
        }
        //y el equipo con temparatura maxima y el equipo con 
        //temperatura minima
        double valor_max = Integer.MIN_VALUE;
        double valor_min = Integer.MAX_VALUE;
        
        for (Double value : difTemperatura){
            
            if (value > valor_max){
                valor_max = value;
            }
            else if (value < valor_min){
                valor_min = value;
            }
        }
        System.out.println("El equipo con la temperatura maxima es: Equipo " + 
                difTemperatura.indexOf(valor_max));
        System.out.println("El equipo con la temperatura minima es: Equipo " + 
                difTemperatura.indexOf(valor_min));
    }
}
