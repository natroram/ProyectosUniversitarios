package General;
import Categoria.Categorias;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolepilco
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categorias categoria;
    // Categoria categoria;

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    
    
    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nombre: " + nombre + ", Descripcion: " + descripcion + ", Precio: " + precio;
    }
    
    public Producto(){
        
    }
    public Producto(String codigo, String nombre, String descripcion, Categorias categoria,double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria=categoria;
    }
    public Producto(String codigo, double precio){
        this.codigo = codigo;
        this.precio = precio;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            Producto p= (Producto) obj;
            if (p.getCodigo().equals(this.codigo)) {
            return false;
            }
        }
        return true;
    }
    
    
    
    
}
