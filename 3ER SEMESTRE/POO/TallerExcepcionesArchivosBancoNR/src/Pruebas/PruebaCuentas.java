/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import data.ClientesData;
import data.CuentasData;
import java.util.List;
import modelo.Cliente;
import modelo.CuentaBancaria;
import modelo.excepciones.ProblemasConArchivoException;

/**
 *
 * @author rociomera
 */
public class PruebaCuentas {
    public static void main(String[] args) throws ProblemasConArchivoException{
        //imprimir la informacion de las cuentas bancarias
        List<CuentaBancaria> cuentas = CuentasData.obtenerCuentasBancaria();
        for(CuentaBancaria cuenta : cuentas){
            System.out.println(cuenta);
        }
        Cliente cli = new Cliente("natalia ramirez", "0931739551");
        CuentaBancaria c1 = new CuentaBancaria("12345", 5000.0, cli);
        cuentas.add(c1);
        c1.setMonto(35000.0);
        CuentasData.actualizarCuentas(cuentas);
        
    }
}
