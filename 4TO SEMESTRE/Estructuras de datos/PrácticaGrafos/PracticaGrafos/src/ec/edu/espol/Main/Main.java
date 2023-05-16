package ec.edu.espol.Main;

import ec.edu.espol.Graph.Edge;
import ec.edu.espol.Graph.GraphLA;
import ec.edu.espol.Graph.Vertex;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.graalvm.compiler.graph.Graph;

/**
 *
 * @author Jocellyn Luna
 */
public class Main {

    public static void main(String[] args) {

        GraphLA<String, String> grafo = new GraphLA<>(false);

        grafo.addVertex("V1");
        grafo.addVertex("V2");
        grafo.addVertex("V3");
        grafo.addVertex("V4");
        grafo.addVertex("V5");
        grafo.addVertex("V6");

        grafo.connect("V1", "V2", null, 3);
        grafo.connect("V1", "V3", null, 4);
        grafo.connect("V1", "V5", null, 8);
        grafo.connect("V2", "V5", null, 5);
        grafo.connect("V3", "V5", null, 3);
        grafo.connect("V5", "V4", null, 7);
        grafo.connect("V5", "V6", null, 3);
        grafo.connect("V6", "V4", null, 2);
        
        GraphLA<String, String> grafo2 = new GraphLA<>(false);
        grafo2.addVertex("c");
        grafo2.addVertex("d");
        grafo2.addVertex("e");
        grafo2.connect("c", "d", null, 0);
        
        GraphLA<String, String> grafo1 = new GraphLA<>(false);
        grafo2.addVertex("a");
        grafo2.addVertex("b");
        grafo2.connect("a", "b", null, 0);
        
        System.out.println(grafo2.isInTheSameComponent("c", "e"));
        
//        System.out.println(grafo);
//        System.out.println("virar grafo:");
//        System.out.println(grafo.flipGraphDirections());
        
//        LinkedList<LinkedList<Vertex<String,String>>> components = new LinkedList<>();
//        //grafo.getStronglyConnectedComponents(components);
//        grafo.getConnectedComponents(components);
//        System.out.println("Componentes Fuertemente Conexas:\n"+components);
        
        //System.out.println("dist v1, v6: " + grafo.minDistance("V1", "V6"));
        
       
        
        
        
        
        
    }
//    
   public String procesarTexto(String txt){
        txt = txt.toLowerCase();
        txt = txt.replace(";", " ");
        txt = txt.replace(",", " ");
        txt = txt.replace(".", " ");
        return txt;
    }
    
    public void aumentoEdgePeso(String origen, String destino, GraphLA<String,String> graf){
        for(Vertex<String,String> v : graf.getVertices()){
            if(v.getData().equals(origen)){
                
                for(Edge<String,String> e : v.getEgdes()){
                    if(e.getDestino().getData().equals(destino)){
                        e.setPeso(e.getPeso()+1);
                    }
                }
            }
        }
    }
    
    public GraphLA<String, String> generarGrafoSintactico(String txt){
        String procesado = procesarTexto(txt);
        if(procesado != null){
            String[] partes = procesado.split(" ");
            GraphLA<String, String> grafo = new GraphLA(true);
            if(procesado.length()<2){
                System.out.println("no es posible crear con grafo de texto con 1 o 0 palabras");
                return null;
            }
            for(int i = 0; i < partes.length; i++){
                String origen = partes[i];
                String destino = partes[i+1];
                
                grafo.addVertex(origen);
                grafo.addVertex(destino);
                
                boolean indicador = grafo.connect(origen, destino, null, 1);
                
                if(!indicador){
                    aumentoEdgePeso(origen,destino,grafo);
                }
            }
            return grafo;
        }
        else{
            return null;
        }
        
    }

    
//    SISTEMA ACADEMICO - INCOMPLETO
//    public static Map < String, Map < String, List<Student> > > getRegistros (GraphLA<Student, Map<String, String> > grafo) {
//        Map<String, Map<String, List<Student>>> mResultado = new HashMap<>();
//        LinkedList<Vertex<Studen, Map<String,String>>> vertices = grafo.recorridoAnchura(grafo);
//        //recorrer las componentes
//        //crear mapa de paralelos para cada materia
//        //recorrer arcos de cada vertice
//        //verificar que 
//        
//        for(Vertex<Student, Map<String,String>> v: grafo.getVertices()){
//            for(Edge<Map<String,String>,Student> e: v.getEgdes()){
//                for(String clave: e.getData().keySet()){
//                    if(mResultado.containsKey(clave)){
//                        if(mResultado.get(clave).containsKey(e.getData().get(clave))){
//                            
//                        }
//                    }
//                }
//            }
//        }
//    }
}

