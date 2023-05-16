/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * clases que reprsenta un pokemon
 * @author rociomera
 */
package pokemonapplication;
public class Pokemon{
    //variables de instancia de la clase
    public String especie;
    public String nombre;
    public int puntosSalud;
    public int puntosCombate; 
    
    public Pokemon(){}
    
    public Pokemon(String especie, String nombre, 
            int puntosSalud, int puntosCombate){
        this.especie = especie;
        this.nombre = nombre;
        this.puntosSalud = puntosSalud;
        this.puntosCombate = puntosCombate;
    }
    
    /**
     * Metodo que muestra la informacion de un pokemon
     */
    public void mostrarInformacion(){
        System.out.printf("especie: %s\nnombre: %s\n"
                + "puntosSalud: %d\npuntosCombate: %d\n",
                especie,nombre,puntosSalud,puntosCombate);
    }
    
    /**
     * imprime en pantalla el nombre del pokemon el valor indicado
     * @param veces : numero de veces que se imprime en pantalla el nombre del
     * pokemon
     */
    public void saludar(int veces){
        for(int i=0;i<veces-1;i++){
            //mostramos en nombre en la misma linea n-1 veces
            System.out.print(nombre+"-");
        }
        //la ultima vez creamos un salto de linea
        System.out.println(nombre);
    }
    
    /**
     * Retorna verdadero si esquiva el ataque, falso caso contrario
     * @return 
     */
    public boolean esquivar(){
        double aleatorio = Math.random();
        if(aleatorio>0.5)
            return true;
        else
            return false;
    }
    
    public void atacar(Pokemon p){
        //si el pokemon no esquiva el ataque podemos causar danio
        if(!p.esquivar()){
            System.out.println(p.nombre+" no esquivo el ataque");
            //calculamos el danio que causaremos
            //el danio causado sara el 10% de puntos de combate del atacante
            int danio = Math.round( puntosCombate*0.10f);
            //disminuimos los puntos del salud de contricante
            p.puntosSalud=p.puntosSalud-danio;
            System.out.println("Danio causado "+danio);
        }else{
            System.out.println(p.nombre+" esquivo el ataque");
            System.out.println("NO se causo danio");
        }
    }
    
    /**
     * Este metodo que imprime "Es Popular" si el Pokemon esta en la lista de los
     * 10 Pokemons mas populares, caso contraio imprimer "No es Popular"
     */
    public void esPopular(){
        String[] espceiesmaspulares = {"Greninja","Lucario",
                                        "Mimikyu","Charizard","Umbreon",
                                        "Sylveon","Garchomp","Rayquaza",
                                        "Gardevoir","Gengar"};
        
        String salida = "No es popular";
        for(String x : espceiesmaspulares){
            if(especie.equals(x)){
                salida = "Es popular";
                break;
            }
        }
        
        System.out.println(salida);
    }
}

