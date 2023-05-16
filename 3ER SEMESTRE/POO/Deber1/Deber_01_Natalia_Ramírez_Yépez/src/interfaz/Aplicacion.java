/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Scanner;
import modelo.Coordenada;
import modelo.Evaluador;
import modelo.Persona;

/**
 * Clase que se encargar de pedir los datos al usuario
 * con el fin de separar el modelo con la forma en la
 * que el usuario interactua con este
 * @author rociomera
 */
public class Aplicacion {
    private Scanner sc; 
    public Aplicacion(){
        sc = new Scanner(System.in);
    }
    
    public void iniciar(){
        String entrada = "";
        do{
            presentarMenuPrincipal();
            System.out.print("Ingrese opcion:");
            entrada = sc.nextLine();
            switch(entrada){
                case "1":
                    //llamamos a metodo realizartest()
                    realizarTest();
                    break;
                case "2":
                    //mostramos mensaje de finalizacion
                    System.out.println("Adios");
                    break;
                default:
                    //la opcion ingreada no esta dentro de las opciones del menu
                    System.out.println("Opcion invalida");
                    break;
                        
            }
            //para comparar String usamos equals
        }while(!entrada.equals("2"));
    }
    
    /**
     * Este metodo pide al usuario que ingrese los datos de una
     * persona y retorna un nuevo objeto de tipo persona con los
     * datos dados
     * @return 
     */
    public Persona pedirDatosPersona(){
        //pida los intereses de la persona separados por coma
        //el metodo split(",") para dividir la cadana en parte por un delimitador
        //https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#split(java.lang.String)
        System.out.println("Ingrese intereses; ");
        String[] intereses = (sc.nextLine()).split(",");
        
        //pida los la edad de la persona
        System.out.println("Ingrese la edad: ");
        int edad = sc.nextInt();
        //pida la latitud y longitud de donde vive la persona
        System.out.println("Ingrese latitud de ubicacion: ");
        double latitud = sc.nextDouble();
        System.out.println("Ingrese longitud de ubicacion: ");
        double longitud = sc.nextDouble();
        //con la latitud y longitud dada cree un nuevo objeto de tipo
        //coordenada
        //Coordenada c= new Coordena(lat,longitud);
        Coordenada ubicacion = new Coordenada(latitud, longitud);
        //cree un nuevo objeto de tipo Persona
        //Persona = new persona(intereses,edad,c);
        Persona p = new Persona(edad, intereses, ubicacion);
        //cambie la sentencia return para que devuelve el objeto Persona que creo
        return p;
    }
    
    /**
     * Metodo que se llama cuando el usuario escoge la opcion de IniciarTest
     * en el menu principal. Aqui se evaluara si las personas son compatibles
     */
    public void realizarTest(){
        //llame al metodo pedirDatosPersona y pida los datos de la persona1
        //Persona p1 = pedirDatosPersona();
        Persona p1 = pedirDatosPersona();
        //llame al metodo pedirDatosPersona y pida los datos de la persona1
        //Persona p2 = pedirDatosPersona();
        Persona p2 = pedirDatosPersona();
        //cree una nueva instancia de la clase Evaluador
        //pase como parametro p1 y p2
        //Evaluador ev = new Evaluador(p1,p2);
        Evaluador evalua = new Evaluador(p1, p2);
        //llame al metodo son compatibles de la clase Evaluador
        //para obtener el resultado
        boolean compatibles = evalua.sonCompatibles();
        //muestre un mesaje apropiado indicando si las personas son compatibles
        //o no lo son
        if (compatibles){
            System.out.println("Las dos personas son compatibles para trabajar "
                    + "en equipo");
        }
        else{
            System.out.println("Las dos personas no son compatibles para trabajar "
                    + "en equipo");
        }
    }
    
    public void presentarMenuPrincipal(){
        System.out.println("1. Iniciar test");
        System.out.println("2. Salir");
    }
    
}
