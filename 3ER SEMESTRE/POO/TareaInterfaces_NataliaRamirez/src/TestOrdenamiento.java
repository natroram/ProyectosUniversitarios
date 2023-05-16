
import Modelo.Hotel;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natalia Ramirez
 */
public class TestOrdenamiento {
    public static void main(String[] args){
        ArrayList<Hotel> hoteles = new ArrayList();
        
        Hotel h1 = new Hotel(100, 9000);
        Hotel h2 = new Hotel(80, 10000);
        Hotel h3 = new Hotel(40, 4000);
        Hotel h4 = new Hotel(90, 15000);
        
        hoteles.add(h1);
        hoteles.add(h2);
        hoteles.add(h3);
        hoteles.add(h4);
        
        Collections.sort(hoteles);
        for(Hotel h : hoteles){
            System.out.println(h);
            
        }
    }
}
