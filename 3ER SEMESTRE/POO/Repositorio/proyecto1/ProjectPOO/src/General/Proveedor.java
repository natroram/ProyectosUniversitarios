package General;
import Categoria.Categorias;
import Ubicacion.Coordenadas;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicolepilco
 */
public class Proveedor extends Personas{
    private final int numeroContacto;
    private ArrayList<Producto> productosProveedor;

    public Proveedor(String nombre, int númeroIdentificación, String dirección,
        Coordenadas ubicación, String correo_electrónico, String nombreUsuario, String clave, int numeroContacto){
        super(nombre, númeroIdentificación, dirección, ubicación, correo_electrónico, nombreUsuario, clave);
        this.numeroContacto = numeroContacto;
        this.productosProveedor=new ArrayList<>();
    }
    
    public Proveedor(String nombre, int númeroIdentificación, String dirección,
        Coordenadas ubicación, String correo_electrónico, int numeroContacto){
        super(nombre, númeroIdentificación, dirección, ubicación, correo_electrónico);
        this.numeroContacto = numeroContacto;
        this.productosProveedor=new ArrayList<>();
    }

 
    public int getNumeroContacto() {
        return numeroContacto;
    }

    public ArrayList<Producto> getProductosProveedor() {
        return productosProveedor;
    }
    public void mostrarMenuProveedor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Registrar producto");
        System.out.println("2.Consultar informacion de los pedidos");
        System.out.println("3.Editar productos"); 
        int opcion = sc.nextInt();
        switch(opcion){
            case 1: 
        }
    }
    public void cambiarEstadoPedido(String estado, String fecha){
        
        
    }
     public void registrarProductos(String codigo,String nombre,String descripcion,String categoria, double precio){
        Producto p= new Producto(codigo,nombre,descripcion,Categorias.valueOf(categoria.toUpperCase()),precio);
        productosProveedor.add(p);
     }   
     public void consultarInformacionPedidos(){}
     
    public void editarProductoNombre(String codigo, String nombre, int opcion){
         for(Producto p: productosProveedor){
             if(p.getCodigo().equals(codigo)){
                 p.setNombre(nombre);
             }
         }
     }
    
    public void editarProductoDes(String codigo, String descripcion, int opcion){
         for(Producto p: productosProveedor){
             if(p.getCodigo().equals(codigo)){
                 p.setDescripcion(descripcion);
             }
         }
     }
    
    public void editarProductoCat(String codigo, String categoria, int opcion){
         for(Producto p: productosProveedor){
             if(p.getCodigo().equals(codigo)){
                 p.setCategoria(Categorias.valueOf(categoria.toUpperCase()));
             }
         }
     }
    public void editarProductoPrecio(String codigo, double precio, int opcion){
         for(Producto p: productosProveedor){
             if(p.getCodigo().equals(codigo)){
                 p.setPrecio(precio);
             }
         }
     }
    public void consultarInformacionProductos(String categoria, String nombre){
        Categorias cat = Categorias.valueOf(categoria.toUpperCase());
        for (Producto p: productosProveedor){
            if ( (p.getCategoria().equals(cat)) && (p.getNombre().equals(nombre))){
                System.out.println(p);
            }
        }
    }

     
    public static void main(String[] args){
        Coordenadas c= new Coordenadas(79.8, -79.8);
        Proveedor p= new Proveedor ("Nombre",1,"direccion",c,"proyecto@gmail.com","user","1234",123456);
        p.registrarProductos("001", "leche", "lalalala", "LACTEOS", 10.0);
        p.registrarProductos("005", "leche", "lalalala", "LACTEOS", 20.0);
        p.registrarProductos("003", "carne", "lalalala", "CARNICOS", 20.0);
        Proveedor p2= new Proveedor("E",1,"direccion",c,"proyecto@gmail.com","user11","1234",123456);
        p2.registrarProductos("002", "mantequilla", "lalalala", "LACTEOS", 5.0);
        p2.registrarProductos("004", "mantequilla", "lala", "LACTEOS", 5.0);
        /*int cont=0;
        for (Producto p1: p.productosProveedor){
            System.out.println(p1 +" " + p2.getProductosProveedor().get(cont));
            cont+=1;
        }*/
        
        p.consultarInformacionProductos("lacteos", "leche");
        
    }
    
    
 }
