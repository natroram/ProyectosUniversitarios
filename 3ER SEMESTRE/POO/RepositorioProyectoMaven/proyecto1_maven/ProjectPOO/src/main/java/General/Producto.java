package General;

import Categoria.Categorias;
import java.util.ArrayList;

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
    private ArrayList<Categorias> categoria;
    private Proveedor proveedor;
    // Categoria categoria;

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

    public ArrayList<Categorias> getCategoria() {
        return categoria;
    }

    public Proveedor getProveedor() {
        return proveedor;
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

    /**
     * Constructor de Producto
     * @param codigo identificador unico de producto
     * @param nombre Nombre del producto
     * @param descripcion Brve descripcion del producto
     * @param categoria categoria perteneciente al producto
     * @param precio precio del producto
     * @param proveedor proveedor del producto
     */
      public Producto(String codigo, String nombre, String descripcion, String categoria,double precio, Proveedor proveedor){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categoria= new ArrayList<>();
        
        if (categoria.contains(",")){
            String [] Lcat = categoria.split(",",0);    
            for (String s: Lcat){
                this.categoria.add(Categorias.valueOf(s.toUpperCase()));
            }
        }
        else {
        this.categoria.add(Categorias.valueOf(categoria.toUpperCase()));    
        }
    }
    public Producto(String codigo, double precio){
        this.codigo = codigo;
        this.precio = precio;
    }
    
    /**
     * Metodo equals claseProducto
     * Permite verificar si dos productos 
     * @param obj recibe el objeto Producto a comparar
     * @return true si tienen el mismo codigo
     */
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
    /**
     * Metodo que permite cambiar la categoria
     * @param categoriaVieja posicion en la que se encuentra la categoria que se desea cambiar
     * @param categoriaNueva Nombre de la nueva categoria
     */
    public void cambiarCategoria(int categoriaVieja, Categorias categoriaNueva){
        categoria.set(categoriaVieja,categoriaNueva);
    }
    /**
     * Metodo que agrega la nueva categoria del producto
     * @param cat nombre de la nueva categoria del producto
     */
    public void addCat(String cat){
        Categorias c=Categorias.valueOf(cat.toUpperCase());
        if(categoria.indexOf(c)==-1){
        categoria.add(c);}
        else {
            System.out.println("la categoria ya existe");
        }
    }
    
    /**
     * Metodo que permite eliminar la categoria que se desea cambiar
     * @param cat la categoria que sera removida
     */
    public void deleteCat(String cat){

        int del = categoria.indexOf(Categorias.valueOf(cat.toUpperCase()));
        if(del!=-1) {
            categoria.remove(del);
        }
        else{
            System.out.println("No existe esa categoria en el producto");
        }
        }

    /**
     * Imprime las categorias del producto
     */
    public void printCat(){
        int i=0;
        for(Categorias c:categoria){
            System.out.println(i+" "+c);
            i++;
        }
        if(i==0){
            System.out.println("No hay Categorias");
        }
    }
    public boolean inCatRange(int i){
        return  i<categoria.size();
    }

}
