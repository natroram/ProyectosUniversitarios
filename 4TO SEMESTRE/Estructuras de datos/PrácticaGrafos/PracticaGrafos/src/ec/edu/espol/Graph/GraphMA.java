/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Graph;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class GraphMA<E> {

    private ArrayList<E> vertex;
    private int[][] matrix;
    private int capacity = 100;
    private boolean directed;
    
    public GraphMA(boolean directed){
        vertex = new ArrayList<>();
        matrix = new int[capacity][capacity];
        this.directed = directed;
    }
    
    public boolean isEmpty() {
        return vertex.isEmpty();
    }

    public boolean addVertex(E data) {
        return (data != null && !vertex.contains(data)) ? vertex.add(data) : false;
    }

    public boolean addEdge(E origen, E destino, int peso) {
        int io = vertex.indexOf(origen);
        int id = vertex.indexOf(destino);
        if ((io != -1 && id != -1) && peso != 0 && matrix[io][id] == 0) {
            matrix[io][id] = peso;
            if (!directed) {
                matrix[id][io] = peso;
            }
            return true;
        }
        return false;
    }

    public boolean removeVertex(E data) {
        int i = vertex.indexOf(data);
        if (i == -1) {
            return false;
        }

        for (int j = i; j < vertex.size(); j++) {
            matrix[j] = matrix[j + 1];

            for (int k = 0; k < vertex.size(); k++) {
                matrix[k][j] = matrix[k][j + 1];
            }
        }
        vertex.remove(i);
        return true;
    }

    public int indegree(E data) {
        int i = vertex.indexOf(data);
        int grado = 0;

        if (i == -1) {
            return -1;
        }

        for (int j = 0; j < vertex.size(); j++) {
            if (matrix[j][i] != 0) {
                grado++;
            }
        }

        return grado;
    }

    public int outdegree(E data) {
        int i = vertex.indexOf(data);
        int grado = 0;

        if (i == -1) {
            return -1;
        }

        for (int j = 0; j < vertex.size(); j++) {
            if (matrix[i][j] != 0) {
                grado++;
            }
        }

        return grado;
    }
    
    public GraphMA<E> reverse(){
        GraphMA<E> n = new GraphMA<>(true);
        n.vertex=this.vertex;
        for (int i=0 ; i< vertex.size();i++) {
            for (int j = 0 ; j<vertex.size();j++) {
                n.addEdge(vertex.get(j),vertex.get(i), matrix[i][j]);
            }
        }
        return n;
    }

}
