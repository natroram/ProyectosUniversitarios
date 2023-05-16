package ec.edu.espol.Graph;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Jocellyn Luna
 */
public class GraphLA<V, E> {

    private LinkedList<Vertex<V, E>> vertices;
    private boolean directed;

    public GraphLA(boolean directed) {
        this.vertices = new LinkedList<>();
        this.directed = directed;
    }

    public boolean estaVacio() {
        return vertices.isEmpty();
    }

    public boolean addVertex(V data) {
        Vertex<V, E> v = new Vertex<>(data);
        return (data == null || vertices.contains(v)) ? false : vertices.add(v);
    }

    public boolean connect(V origen, V destino, E data, int peso) {
        if (origen == null || destino == null) {
            return false;
        }

        Vertex<V, E> vo = buscarVertice(origen);
        Vertex<V, E> vd = buscarVertice(destino);

        if (vo == null || vd == null) {
            return false;
        }

        Edge<E, V> e = new Edge<>(vo, vd, data, peso);

        if (vo.getEgdes().contains(e)) {
            return false;
        }

        vo.getEgdes().add(e);
        if (!directed) {
            Edge<E, V> e1 = new Edge<>(vd, vo, data, peso);
            vd.getEgdes().add(e1);
        }
        return true;
    }

    private Vertex<V, E> buscarVertice(V data) {
        for (Vertex<V, E> v : vertices) {
            if (v.getData().equals(data)) {
                return v;
            }
        }
        return null;
    }

    public int getOutDegree(V data) {
        if (data == null) {
            return -1;
        }

        Vertex<V, E> v = buscarVertice(data);
        return (v == null) ? -1 : v.getEgdes().size();
    }

    public int getInDegree(V data) {
        Vertex<V, E> vertex = buscarVertice(data);
        if (vertex == null) {
            return -1;
        }

        int grado = 0;

        for (Vertex<V, E> v : vertices) {
            for (Edge<E, V> e : v.getEgdes()) {
                if (e.getDestino().equals(vertex)) {
                    grado++;
                }
            }

        }
        return grado;
    }

    @Override
    public String toString() {
        StringBuilder v = new StringBuilder();
        v.append(" v={");

        StringBuilder a = new StringBuilder();
        a.append(" a={");

        for (Vertex<V, E> vertex : vertices) {
            v.append(vertex.getData());
            v.append(", ");
            for (Edge<E, V> e : vertex.getEgdes()) {
                a.append(e.toString());
                a.append(", ");
            }
        }
        if (!vertices.isEmpty()) {
            v.delete(v.length() - 2, v.length());
        }
        if (a.length() > 4) {
            a.delete(a.length() - 2, a.length());
        }

        v.append("}");
        a.append("}");
        return v.toString() + "\n" + a.toString();
    }

    public LinkedList<Vertex<V, E>> getVertices() {
        return vertices;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean removerVertice(V data) {
        if (data == null) {
            return false;
        }

        Vertex<V, E> v = buscarVertice(data);
        if (v == null) {
            return false;
        }

        for (Vertex<V, E> vertex : vertices) {
            Iterator<Edge<E, V>> l = vertex.getEgdes().iterator();
            while (l.hasNext()) {
                Edge<E, V> e = l.next();
                if (e.getDestino().equals(v) || e.getOrigen().equals(v)) {
                    l.remove();
                }
            }
        }

        v.setData(null);
        v.setEgdes(null);
        vertices.remove(v);
        return true;

    }

    public boolean removerArco(V origen, V destino) {
        if (origen == null || destino == null) {
            return false;
        }

        Vertex<V, E> vo = buscarVertice(origen);
        Vertex<V, E> vd = buscarVertice(destino);

        if (vo == null || vd == null) {
            return false;
        }

        LinkedList<Edge<E, V>> edges = vo.getEgdes();

        Iterator<Edge<E, V>> l = edges.iterator();

        while (l.hasNext()) {
            Edge<E, V> e = l.next();

            if (e.getDestino().equals(vd)) {
                l.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GraphLA)) {
            return false;
        }

        GraphLA<V, E> other = (GraphLA<V, E>) o;

        if (this.vertices.size() != other.vertices.size()) {
            return false;
        }

        Set<V> s1 = new HashSet<>();
        s1.addAll((Collection<V>) vertices);

        s1.removeAll((Collection<V>) other.vertices);
        if (!s1.isEmpty()) {
            return false;
        }

        for (Vertex<V, E> v : vertices) {
            Vertex<V, E> vOther = other.buscarVertice(v.getData());

            Set<Edge<E, V>> s2 = new HashSet<>();
            s2.addAll((Collection<Edge<E, V>>) v.getEgdes());

            s2.removeAll((Collection<Edge<E, V>>) vOther.getEgdes());
            if (!s2.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.vertices);
        hash = 53 * hash + (this.directed ? 1 : 0);
        return hash;
    }
    
    //TALLER GRAFOS
    
    public LinkedList<Vertex<V,E>> recorridoAnchura(V data){
        Queue<Vertex<V,E>> cola = new ArrayDeque<>();
        LinkedList<Vertex<V,E>> recorrido = new LinkedList<>();
        Vertex<V,E> vertice = buscarVertice(data);
        
        if(vertice == null){
            return null;
        }
        else{
            cola.offer(vertice);
            vertice.setVisited(true);
            Vertex<V,E> tmp = null;
            
            while(cola.size() > 0){
                tmp = cola.poll();
                recorrido.add(tmp);
                //System.out.println(tmp);
                
                for(Edge<E,V> arco : tmp.getEgdes()){
                    if(!arco.getDestino().isVisited()){
                        arco.getDestino().setVisited(true);
                        cola.offer(arco.getDestino());
                    }
                    
                }
            }
            
            return recorrido;
        }
    }
    
    public LinkedList<Vertex<V,E>> recorridoProfundidad(V data){
        LinkedList<Vertex<V,E>> recorrido = new LinkedList<>();
        Vertex<V,E> vertice = buscarVertice(data);
        Stack<Vertex<V,E>> pila = new Stack<>();
        
        if(vertice == null){
            return null;
        }
        else{
            pila.push(vertice);
            vertice.setVisited(true);
            Vertex<V,E> tmp = null;
            
            while(!pila.empty()){
                tmp = pila.pop();
                recorrido.add(tmp);
                System.out.println(tmp);
                
                for(Edge<E,V> arco : tmp.getEgdes()){
                    if(!arco.getDestino().isVisited()){
                        arco.getDestino().setVisited(true);
                        pila.push(arco.getDestino());
                    }
                    
                }
            }
            
            return recorrido;
        }
    }
    
    public boolean getConnectedComponents(LinkedList<LinkedList<Vertex<V,E>>> components){
        cleanVertex();
        Vertex<V,E> n = null;
        LinkedList<Vertex<V,E>> recorrido = null;
        
        while(true){
            n = this.buscarVerticeNoVisitado();
            if(n == null){
                break;
            }
            recorrido = this.recorridoAnchura(n.getData());
            components.addLast(recorrido);
        }
        if(components.size() ==1){
            return true;
        }
        return false;
    }
    
    public Vertex<V,E> buscarVerticeNoVisitado(){
        for(Vertex<V,E> vertice : this.vertices){
            if(!vertice.isVisited()){
                vertice.setVisited(true);
                return vertice;
            }
        }
        return null;
    }
    
    public void cleanVertex(){
        for(Vertex<V, E> v: this.vertices){
            v.setAntecesor(null);
            v.setDistAcumulada(Integer.MAX_VALUE);
            v.setVisited(false);
        }
    }
    
    //TAREA 19 ENERO
    
    public GraphLA<V, E> flipGraphDirections(){
        if(this.directed){
            cleanVertex();
            GraphLA<V, E> resultado = new GraphLA<>(true);
            //añadiendo todos los vertices sin lados a nuevo grafo
            for(Vertex<V,E> vertice : this.vertices){
                resultado.addVertex(vertice.getData());
            }
            //conectando los vertices de nuevo grafo al reves
            for(Vertex<V, E> vertice : this.vertices){
                if(!vertice.isVisited()){
                    for(Edge<E, V> lado : vertice.getEgdes()){
                        resultado.connect(lado.getDestino().getData(), lado.getOrigen().getData(), lado.getData(), lado.getPeso());
                    }
                }
            }
            return resultado;
        }
        else{
            return null;
        }
    }
    
    public LinkedList<Vertex<V,E>> getIntersectionOfRecorrido(LinkedList<Vertex<V,E>> lista1, LinkedList<Vertex<V,E>> lista2){
        int len1 = lista1.size();
        int len2 = lista2.size();
        LinkedList<Vertex<V,E>> resultado = new LinkedList<>();
        
        if(len1 > len2){
            for(Vertex<V,E> v1 : lista1){
                for(Vertex<V,E> v2 : lista2){
                    if(v2.equals(v1) && !resultado.contains(v2)){
                        resultado.add(v2);
                    }
                }
            }
            
            return resultado;
        }
        else if(len2 > len1){
            for(Vertex<V,E> v2 : lista2){
                for(Vertex<V,E> v1 : lista1){
                    if(v1.equals(v2) && !resultado.contains(v1)){
                        resultado.add(v1);
                    }
                }
            }
            
            return resultado;
        }
        
        return null;
    }
    
    //metodo el cual obtiene las componentes fuertemente conexas de un grafo dirigido
    public boolean getStronglyConnectedComponents(LinkedList<LinkedList<Vertex<V,E>>> components){
        cleanVertex();
        Vertex<V,E> v = null;
        LinkedList<Vertex<V,E>> recorridoD = null;
        LinkedList<Vertex<V,E>> recorridoA = null;
        GraphLA<V,E> flipped = null;
        
        if(this.directed){
            
            while(true){
                flipped = this.flipGraphDirections();
                v = this.buscarVerticeNoVisitado();
                for(LinkedList<Vertex<V,E>> componente : components){
                    while(componente.contains(v)){
                        //v.setVisited(true);
                        v = this.buscarVerticeNoVisitado();
                    }
                }
                if(v == null){
                    break;
                }
                recorridoD = this.recorridoAnchura(v.getData());
                recorridoA = flipped.recorridoAnchura(v.getData());
                LinkedList<Vertex<V,E>> intersection = getIntersectionOfRecorrido(recorridoD, recorridoA);
                components.addLast(intersection);
                
            }
            if(components.size()>=1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            System.out.println("No se pueden obtener componentes fuertemente conexas en grafos no dirigidos.");
            return false;
        }
    }
    
    //metodo que aplica dijkstra a un grafo partiendo de un vértice inicial
    public void useDijkstra(V data){
        if(this.directed){
            System.out.println("Solo aplica a grafos no dirigidos");
            return;
        }
        cleanVertex();
        Queue<Vertex<V,E>> cola = new PriorityQueue<>((Vertex<V,E> v1, Vertex<V,E> v2)->(v1.getDistAcumulada()-v2.getDistAcumulada()));
        Vertex<V,E> origen = buscarVertice(data);
        if(origen != null){
        origen.setDistAcumulada(0);
        cola.offer(origen);
        
        while(!cola.isEmpty()){
            Vertex<V,E> viajero = cola.poll();
            viajero.setVisited(true);
            for(Edge<E,V> adj : viajero.getEgdes()){
                Vertex<V, E> v_adj = adj.getDestino();
                if(!v_adj.isVisited() && viajero.getDistAcumulada()+adj.getPeso() < v_adj.getDistAcumulada()){
                    v_adj.setDistAcumulada(viajero.getDistAcumulada()+adj.getPeso());
                    v_adj.setAntecesor(viajero);
                    cola.offer(v_adj);
                }
            }
        }
        }
    }
    
    //metodo el cual retorna la distancia minima acumulada entre dos vertices de un grafo
    public int minDistance(V data1, V data2){
        Vertex<V,E> destino = buscarVertice(data2);
        
        if(data1 == null || destino == null){
            return -1;
        }
        
        useDijkstra(data1);
        
        return destino.getDistAcumulada();
    }
    
    public void agregarVerticesANuevoGrafo(GraphLA<V,E> grafo){
        for(Vertex<V,E> v : this.vertices){
            grafo.addVertex(v.getData());
        }
    }
    
    public GraphLA<V,E> usePrim(V data){
        cleanVertex();
        if(this.directed){
            System.out.println("Solo aplica a grafos no dirigidos");
            return null;
        }
        Vertex<V, E> inicio = buscarVertice(data);
        int vertexNum = this.vertices.size();
        if(inicio != null){
            GraphLA<V,E> minExpanTree = new GraphLA<>(false);
            agregarVerticesANuevoGrafo(minExpanTree);
            
            PriorityQueue<Edge<E,V>> cola = new PriorityQueue<>((Edge<E,V> e1, Edge<E,V> e2)->(e1.getPeso()-e2.getPeso()));
            int cont = 0;
            
            while(cont<vertexNum){
                for(Edge<E,V> lado : inicio.getEgdes()){
                    if(!lado.getDestino().isVisited()){
                        cola.offer(lado);
                    }
                }
                
                Edge<E,V> tempEdge = cola.poll();
                if(!tempEdge.getDestino().isVisited()){
                    
                    tempEdge.getDestino().setVisited(true);
                    minExpanTree.connect(tempEdge.getOrigen().getData(), tempEdge.getDestino().getData(), tempEdge.getData(), tempEdge.getPeso());
                    inicio = tempEdge.getDestino();
                    cont++;
                }
            }
            
            return minExpanTree;
        }
        else{
            return null;
        }
        
        
    }
    
    public GraphLA<V,E> useKruskal(){
        cleanVertex();
        GraphLA<V,E> minTree = new GraphLA<>(false);
        agregarVerticesANuevoGrafo(minTree);
        
        PriorityQueue<Edge<E,V>> cola = new PriorityQueue<>((Edge<E,V> e1, Edge<E,V> e2)->(e1.getPeso()-e2.getPeso()));
        
        for(Vertex<V,E> v : this.vertices){
            cola.addAll(v.getEgdes());
        }
        
        LinkedList<LinkedList<Vertex<V,E>>> components = new LinkedList<>();
        
        boolean mismaComponente = false;
        int totalEdges = 0;
        
        while(!cola.isEmpty()/*totalEdges < (this.vertices.size() -1)*/){
            Edge<E,V> arco = cola.poll();
            //System.out.println(arco);
            LinkedList<LinkedList<Vertex<V,E>>> lista = new LinkedList<>();
            minTree.getConnectedComponents(lista);
            components = lista;
            //System.out.println(components);
            //System.out.println(minTree.vertices.contains(arco.getDestino()));
            for(LinkedList<Vertex<V,E>> componente : components){
                //System.out.println(componente);
                if(componente.contains(arco.getDestino()) && componente.contains(arco.getOrigen())){
                    System.out.println(totalEdges + " " + componente);
                    mismaComponente = true;
                }
            }
            
            if(!mismaComponente){
                minTree.connect(arco.getOrigen().getData(), arco.getDestino().getData(), arco.getData(), arco.getPeso());
                totalEdges++;
                mismaComponente = false;
                
            }
            components.clear();
            //System.out.println(minTree);
        }
        
        return minTree;
    }
    
    public GraphLA<V,E> grafoComplementario() {
        GraphLA<V,E> complemento = new GraphLA<>(directed);
        Set<Vertex<V,E>> vertex = new HashSet<>();
        vertex.addAll(this.vertices);
        for (Vertex<V,E> v: this.vertices) {
            complemento.addVertex(v.getData());
        }
        for (Vertex<V,E> v: this.vertices) {
            Set<Vertex<V,E>> v_adj = new HashSet<>();
            v_adj.add(v);
            for (Edge<E,V> e:v.getEgdes()) {
                v_adj.add(e.getDestino());
            }
            Set<Vertex<V,E>> vertex1 = new HashSet<>() ;
            vertex1.addAll(vertex);
            vertex1.removeAll(v_adj);
            for (Vertex<V,E> ve : vertex1) {
                complemento.connect(v.getData(), ve.getData(), null,0);
            }
        }
        return  complemento;
    }
    
//    public List<E> bestSearchFirst(E inicio) {
//        Vertex<E> init = searchVertex(inicio);
//        List<E> vertexR = new LinkedList<>();
//        vertexR.add(inicio);
//        PriorityQueue<Edge<E>> cola = new PriorityQueue<>( (Edge<E> e1 , Edge<E> e2)-> e1.getPeso()- e2.getPeso());
//        Stack<Vertex<E>> pila = new Stack();
//        init.setVisited(true);
//        pila.push(init);
//        while (!pila.isEmpty()) {
//            cola.addAll(pila.pop().getEdges());
//            while (!cola.isEmpty()) {
//                Vertex<E> v = cola.poll().getVdestino() ;
//                if (!v.isVisited()) {
//                    v.setVisited(true);
//                    vertexR.add(v.getData());
//                    pila.push(v);
//                }
//            }
//        }
//        return vertexR;
//    }
    
    
    public static GraphLA<String,String> getCartesianProduct(GraphLA<String,String> grafo1, GraphLA<String,String> grafo2){
        
        GraphLA<String,String> producto = new GraphLA(false);
        if(grafo1.isDirected() || grafo2.isDirected()){
            System.out.println("no es posible obtener proudcto cartesiano de grafos dirigidos");
            return null;
        }
        for(Vertex<String,String> v1 : grafo1.getVertices()){
            for(Vertex<String,String> v2: grafo2.getVertices()){
                String nuevaData = v1.getData()+","+v2.getData();
                producto.addVertex(nuevaData);
            }
        }
        
        for(Vertex<String,String> vOrigen : producto.getVertices()){
            String[] dataO = vOrigen.getData().split(",");
            for(Vertex<String,String> vDestino : producto.getVertices()){
                String[] dataD = vDestino.getData().split(",");
                if(dataO[0].equals(dataD[0]) && grafo2.isAdjacent(dataO[1], dataD[1])){
                    producto.connect(vOrigen.getData(), vDestino.getData(), null, 0);
                }
                if(dataO[1].equals(dataD[1]) && grafo1.isAdjacent(dataO[0], dataD[0])){
                    producto.connect(vOrigen.getData(), vDestino.getData(), null, 0);
                }
            }
            
        }
        
        return producto;
    }
    
    //funcion apoyo: retorna true si ambos vertices son adyacentes en el grafo que llama al metodo
    public boolean isAdjacent(V v1, V v2){
        cleanVertex(); //limpia los vertices del grafo que llama al metodo: los setea como no visitados
        for(Vertex<V,E> v: this.getVertices()){
            for(Edge<E,V> e : v.getEgdes()){
                if(e.getOrigen().getData().equals(v1) && e.getDestino().getData().equals(v2)){
                    return true;
                }
                
            }
        }
        
        return false;
    }
    
    public boolean isInTheSameComponent (V dato1, V dato2){
        cleanVertex();//limpia los vertices del grafo que llama al metodo: los setea como no visitados
        
        //Si existe un camino/recorrido entre ambos vértices, sin importar su dirección, entonces ambos vértices se encuentran en la misma componente conexa
        
        LinkedList<Vertex<V,E>> recorrido = recorridoAnchura(dato1);
        Vertex<V,E> v2 = buscarVertice(dato2);
        if(v2 != null){
            if(recorrido.contains(v2)){
                return true;
            }
        }
        
        return false;
    }
    
//    //Obteniendo componentes conexas 
//    public boolean isInTheSameComponent(V dato1, V dato2){
//        LinkedList<LinkedList<Vertex<V,E>>> components = new LinkedList<>();
//        Vertex<V,E> v1 = buscarVertice(dato1);
//        Vertex<V,E> v2 = buscarVertice(dato2);
//        if(v1 == null || v2 == null){
//            return false;
//        }
//        else{
//            this.getConnectedComponents(components);
//            for(LinkedList<Vertex<V,E>> componente : components){
//                if(componente.contains(v1) && componente.contains(v2)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
