
import Modelo.Laptop;
import Modelo.PowerBand;
import Modelo.Recargable;
import static Modelo.Recargable.calcularPorcentaje;
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
public class TestPorDefecto {
    
    public static void main(String[] args){
        ArrayList<Recargable> recar = new ArrayList();
        
        Laptop lap1 = new Laptop(450.8, 100,8);
        Laptop lap2 = new Laptop(410.0, 200,4);
        PowerBand pb1 = new PowerBand("Microsoft", 80);
        PowerBand pb2 = new PowerBand("Apple", 45);
        
        recar.add(lap1);
        recar.add(lap2);
        recar.add(pb1);
        recar.add(pb2);
        
        for(Recargable rec : recar){
            if(rec instanceof Laptop){
                Laptop lp = (Laptop)rec;
                double porcen = calcularPorcentaje(lp.getNivelBateria(), Laptop.cargaMaxima);
                double min = lp.calcularMinimo();
                System.out.println(porcen+"%"+" - "+min);
            }
            else if(rec instanceof PowerBand){
                PowerBand pb = (PowerBand)rec;
                double porcen = calcularPorcentaje(pb.getNivelBateria(), Laptop.cargaMaxima);
                double min = pb.calcularMinimo();
                System.out.println(porcen+"%"+" - "+min);
            }
        }
        
        
    }
}
