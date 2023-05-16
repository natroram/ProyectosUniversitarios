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
public class Graph_MatrizAdy<V> {
    private int MAX = 20;
    private int effectiveSize;
    private int[][] matrizAdy;
    private V[] vertices;
    private boolean isDirected;

    public Graph_MatrizAdy(boolean isDirected) {
        this.effectiveSize = effectiveSize;
        this.matrizAdy = matrizAdy;
        this.vertices = vertices;
        this.isDirected = isDirected;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }

    public int getEffectiveSize() {
        return effectiveSize;
    }

    public void setEffectiveSize(int effectiveSize) {
        this.effectiveSize = effectiveSize;
    }

    public int[][] getMatrizAdy() {
        return matrizAdy;
    }

    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }

    public V[] getVertices() {
        return vertices;
    }

    public void setVertices(V[] vertices) {
        this.vertices = vertices;
    }

    public boolean isIsDirected() {
        return isDirected;
    }

    public void setIsDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    void addVertex(V v1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void connect(V v2, V v1, int peso, Comparator cmp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
