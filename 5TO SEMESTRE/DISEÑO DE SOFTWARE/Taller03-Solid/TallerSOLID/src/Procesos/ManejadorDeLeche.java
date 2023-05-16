/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Leche.LecheDeslactosada;
import Leche.LecheDescremada;
import Leche.LecheEntera;
import Postres.*;

/**
 *
 * @author Pedro Mendoza
 */
public class ManejadorDeLeche {
    private LecheEntera leche;
    
    public ManejadorDeLeche(LecheEntera leche){
        this.leche = leche;
    }
    
    public void cambiarTipoLeche(Object postre){
        // Cambiar tipo de leche en la preparación de los postres, usar leche deslactosada
        System.out.println(postre.getClass());
        System.out.println(Pastel.class);
        if(postre.getClass() == Pastel.class){
            if(leche.getClass() == LecheDeslactosada.class){
                System.out.println("Leche Deslactosada no se puede usar en pastel");
            }
            else{
                leche.usarPastel();
            }
        }else{
            leche.usarHelado();
        }
    }
    
}
