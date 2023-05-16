
import Modelo.Computadora;
import Modelo.Hotel;
import Modelo.HuellaElectrica;
import Modelo.Laptop;
import static Modelo.TestEficienciaElectrica.esEficiente;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natalia Ramirez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<HuellaElectrica> huellaE = new ArrayList();
        
        Hotel h1 = new Hotel(100, 9000);
        Hotel h2 = new Hotel(80, 10000);
        Laptop lap1 = new Laptop(450.8, 100,8);
        Laptop lap2 = new Laptop(410.0, 200,4);
        
        huellaE.add(h1);
        huellaE.add(h2);
        huellaE.add(lap1);
        huellaE.add(lap2);
        
        for(HuellaElectrica he : huellaE){
            double eficiencia = he.getEficienciaElectrica();
            boolean esEf = esEficiente(he);
            System.out.println(eficiencia+"-"+esEf);
        }
        
               
    }
    
}
