/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author rociomera
 */
public class Compra {
    private Cliente cliente;
    private int numeroBoletos;
    private Funcion funcion;
    private double total;
    
    public Compra(Funcion funcion, Cliente c, int nBoletos){
        this.funcion = funcion;
        this.cliente = c;
        this.numeroBoletos = nBoletos;
        this.total = calcularTotal();
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumeroBoletos() {
        return numeroBoletos;
    }

    public void setNumeroBoletos(int numeroBoletos) {
        this.numeroBoletos = numeroBoletos;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    private double calcularTotal(){
        return (funcion.getPrecio()*numeroBoletos);
    }
    
    
}
