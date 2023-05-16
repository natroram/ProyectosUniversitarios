/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Comparator;

/**
 *
 * @author Natalia Ramirez
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Graph_MatrizAdy<Persona> grafo = new Graph_MatrizAdy<>(true);
        
        Persona v1 = new Persona("Alice", 32, "Ingeniero", "Guayaquil");
        Persona v2 = new Persona("Bob", 28, "Chef", "Guayaquil");
        Persona v3 = new Persona("Carol", 27, "Contadora", "Quito");
        Persona v4 = new Persona("Dave", 31, "Investigador", "Cuenca");
        
        Comparator cmp; //comparador para objetos tipo persona
        
        grafo.addVertex(v1);
        grafo.addVertex(v2);
        grafo.addVertex(v3);
        grafo.addVertex(v4);
        
        grafo.connect(v2, v1, 3,  cmp);
        grafo.connect(v1, v4, 1,  cmp);
        grafo.connect(v3, v2, 1, cmp);
        grafo.connect(v3, v1, 2, cmp);
        grafo.connect(v3, v4, 4,  cmp);
        grafo.connect(v4, v3, 2,  cmp);
    }
    
}
