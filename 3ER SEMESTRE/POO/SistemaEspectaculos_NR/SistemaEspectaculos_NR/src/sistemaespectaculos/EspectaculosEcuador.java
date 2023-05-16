/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaespectaculos;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Compra;
import modelo.Funcion;
import modelo.espectaculo.Concierto;
import modelo.espectaculo.Espectaculo;
import modelo.espectaculo.Partido;
import modelo.espectaculo.Teatro;

/**
 *
 * @author rociomera
 */
public class EspectaculosEcuador {
    public ArrayList<Espectaculo> espectaculos;
    public ArrayList<Compra> compras;
    public ArrayList<Cliente> clientes;
    
    public EspectaculosEcuador(){
        espectaculos = new ArrayList<>();
        compras = new ArrayList<>();
        clientes = new ArrayList<>();
        
        //carga datos iniciales en el sistema
        cargarDatos();
    }
    
    private void cargarDatos(){
        clientes.add(new Cliente("0987654321","Eduardo Cruz"));
        clientes.add(new Cliente("0987654321","Angela Carrera"));
        
        ArrayList<String> artistas = new ArrayList<>();
        artistas.add("Carolina Jaume");
        artistas.add("David Reinoso");
        Teatro t = new Teatro("001","Alicia en el pais de las maravillas",artistas);
        t.agregarFuncion(LocalDateTime.of(2020, 07, 15, 18, 0),8.00, 10);
        t.agregarFuncion(LocalDateTime.of(2020, 07, 15, 20, 0),10.00, 20);
        espectaculos.add(t);
        Concierto c = new Concierto("002","Los Clasicos del ayer","Los Rockoleros");
        c.agregarFuncion(LocalDateTime.of(2020, 07, 14, 20, 0),15.00, 20);
        c.agregarFuncion(LocalDateTime.of(2020, 07, 15, 20, 0),15.00, 30);
        espectaculos.add(c);
        Partido p = new Partido("003","Clasico astillero","barcelona","emelec");
        p.agregarFuncion(LocalDateTime.of(2020, 07, 19, 20, 0),10.00, 100);
        espectaculos.add(p);
        
        Compra compra1 = new Compra(t.getFunciones().get(0),clientes.get(0),3);
        Compra compra2 = new Compra(t.getFunciones().get(0),clientes.get(1),2);
        
        Compra compra3 = new Compra(c.getFunciones().get(0),clientes.get(1),20);
        compras.add(compra1);
        compras.add(compra2);
        compras.add(compra3);
    }
    
    
    /**
     * Retorna el cliente cuya cedula es igual a la pasada como parametro
     * @param cedula
     * @return 
     */
    public Cliente buscarCliente(String cedula){
        for (Cliente c : clientes){
            if (c.getCedula().equals(cedula)){
                return c;
            }
        }
        return null;
    }
    
    /**
     * retorna un ArrayList con los espectaculos cuyo
     * nombre coinciden en parte o en su totalidad con el nombre
     * pasado como parametro
     * @param nombre : nombre del espectaculo en que se esta interesado
     * @return 
     */
    public ArrayList<Espectaculo> buscarEspectaculo(String nombre){
        //puede usar le metodo contains de la clase String
        //https://www.geeksforgeeks.org/java-string-contains-method-example/
        ArrayList e = new ArrayList();
        for (Espectaculo esp : espectaculos){
            if ((esp.getNombre().toLowerCase()).contains(nombre.toLowerCase())){
                e.add(esp);
            }
        }
        return e;
    }
    
    /**
     * retorna un ArrayList con los espectáculos tipo partido 
     * en donde participa el quipo pasado como parámetro
     * @param nombre : nombre del espectaculo en que se esta interesado
     * @param tipo : tipo del espectaculo en que se esta interesado (Partido, 
     * Teatro, Concierto)
     * @return 
     */
    public ArrayList<Espectaculo> buscarPartido(String equipo){
        //aqui queremos solo los espectaculos de tipo Partido filtrados por uno de 
        //los equipos
        //por cada espectaculo debe verificar si es un partido
        //en caso de serlo debe hacer downcasting a Partido y comprobar
        //si el equipo dado participa
        //¿Por que es necesario hacer downcasting?
        ArrayList p = new ArrayList();
        for (Espectaculo esp : espectaculos){
            if (esp instanceof Partido){
                Partido part = (Partido)esp;
                if(part.getEquipo1().equals(equipo)){
                    p.add(part);
                }
                else if (part.getEquipo2().equals(equipo)){
                    p.add(part);
                }
            }
        }
        return p;
    }
    
    /**
     * Retorna el numero de boletos vendidos para una determinada funcion
     * @param f - Funcion de la que se obtiene cuantos boletos han sido vendidos
     * @return 
     */
    public int obtenerBoletosVendidos(Funcion f){
        int vendidos = 0;
        for (Compra c : compras){
            if (c.getFuncion().equals(f)){
                vendidos += c.getNumeroBoletos();
            }
        }
        return vendidos;
    }
    
    public boolean hayBoletosDisponibles(Funcion f, int n){
        int vendidos = obtenerBoletosVendidos(f);
        int disponibles = (f.getCapacidad() - vendidos);
        return (disponibles >= n);
    }
    /**
     * Compra el numero de boletos pasados para el cliente y funcion dada. No
     * se puede realizar la compra si no hay suficiente boletos disponibles 
     * para la funcion
     * @param c: clente que realiza la compra
     * @param f: funcion en la que se esta interesado
     * @param boletos: numero de boletos que se desea adquirir
     * @return boolean: True si se realiza la compra, falso caso contrario
     */
    public boolean comprarBoleto(Cliente c, Funcion f, int boletos){
        if (hayBoletosDisponibles(f, boletos)){
            Compra compra = new Compra(f, c, boletos);
            this.compras.add(compra);
            return true;
        }
        return false;
    }
    
    
    
}
