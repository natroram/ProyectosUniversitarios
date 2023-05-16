/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import TDA.BinaryNode;
import TDA.BinaryTree;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Natalia Ramirez
 */
public class VistaApp {
    public BorderPane root;
    private int numOperandos;
    private Map<String, String> mapa;
    private BinaryTree<String> variableTree;
    private BinaryTree<String> finalTree;
    private String expPost;
    private VBox contCentro;
    private VBox contTop;
    private HBox contBot;
    
    public VistaApp(){
        root = new BorderPane();
        mapa = new HashMap<>();
        variableTree = new BinaryTree<>();
        finalTree = new BinaryTree<>();
        contCentro = new VBox();
        root.setCenter(contCentro);
        contBot = new HBox();
        root.setBottom(contBot);
        contTop = new VBox();
        createTop();
        //createCenter();
        
    }

    public BorderPane getRoot() {
        return root;
    }
    
    public void createTop(){
        HBox top = new HBox();
        Label expression = new Label("Ingrese la expresión a evaluar:");
        TextField input = new TextField();
        Button ingresar = new Button("Ingresar");
        
        top.setSpacing(20);
        top.setPadding(new Insets(10,10,10,10));
        top.setAlignment(Pos.CENTER);
        
        contTop.setSpacing(10);
        contTop.setAlignment(Pos.CENTER);
        contTop.setPadding(new Insets(20,20,20,20));
        top.getChildren().addAll(expression, input);
        contTop.getChildren().addAll(top, ingresar);
        root.setTop(contTop);
        
        //si se quiere volver a ingresar otros valores para los simbolos se debe presionar nuevamente el boton ingresar
        ingresar.setOnAction(
                (e)->{
                    String exp = input.getText();
                    this.expPost = conversionPosfija(exp);
                    this.variableTree = BinaryTree.generateExpressionTree(expPost);
                    this.mapa = generarMapa(expPost);
                    this.numOperandos = countOperandos(expPost);
                    
                    createCenter();
                });
    }
    
    //crea la parte central usando un mapa para definir la relacion entre valores y simbolos
    public void createCenter(){
        contCentro.getChildren().clear();
        HBox contenedor = new HBox();
        VBox contVariables = new VBox();
        contVariables.setSpacing(10);
        contVariables.setAlignment(Pos.CENTER);
        Button evaluar = new Button("EVALUAR");
        Label instruccion = new Label("Insertar el valor que corresponda a cada letra");
        
        for(Map.Entry<String,String> set : mapa.entrySet()){
            HBox caja = new HBox();
            caja.setSpacing(10);
            caja.setAlignment(Pos.CENTER);
            Label letra = new Label(set.getKey());
            TextField txt = new TextField();
            caja.getChildren().addAll(letra,txt);
            contVariables.getChildren().addAll(caja);
            
            
            txt.setOnMouseExited(
            (e)->{
                for(Map.Entry<String,String> set2 : mapa.entrySet()){
                    if(letra.getText().equals(set2.getKey())){
                        mapa.replace(set.getKey(), txt.getText());
                    }
                }
                
            });
            
            evaluar.setOnAction(
            (eh)->{
                replaceExpressionTree(mapa);
                
                double total = BinaryTree.evaluateExpressionTree(variableTree);
                createBottom(total);
            
            });
        }
        
        contenedor.setSpacing(20);
        contenedor.setPadding(new Insets(10,10,10,10));
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.getChildren().addAll(instruccion, contVariables);
        
        contCentro.setSpacing(20);
        contCentro.setPadding(new Insets(20,20,20,20));
        contCentro.setAlignment(Pos.TOP_CENTER);
        contCentro.getChildren().addAll(contenedor, evaluar);
        
        
    }
    
    //crea el contenerdor que muestra el resultado de la operacion
    public void createBottom(double total){
        contBot.getChildren().clear();
        Label result = new Label("El total de la expresion es: " + total);
        contBot.setSpacing(20);
        contBot.setPadding(new Insets(20,20,20,20));
        contBot.setAlignment(Pos.TOP_CENTER);
        contBot.getChildren().add(result);
    }
    
    public String conversionPosfija(String expresion){
        Stack<Character> pila = new Stack<>();
        //String[] partes = null;
        //String currentTope = null;
        String concat = "";
        if(expresion.isBlank()){
            return "Error: se ingresó una expresión vacía";
        }
        else{
            for(int i = 0; i<expresion.length(); i++){
                char c = expresion.charAt(i);
                
                if(Character.isLetterOrDigit(c)){
                    concat += c + " ";
                }
                else if(c == '('){
                    pila.push(c);
                }
                else if(c == ')'){
                    while(!pila.empty() && pila.peek() != '('){
                        concat += pila.pop() + " ";
                        //pila.pop();
                    }
                }
                else{
                    while(!pila.empty() && verificarPrioridad(c) <= verificarPrioridad(pila.peek())){
                        concat += pila.pop() + " ";
                    }
                    pila.push(c);
                }
                
            }
            while(!pila.empty()){
                if(pila.peek() == '('){
                    return null;
                }
                concat += pila.pop() + " ";
            }
        }    
        return concat;
    }
    
    //Retorna 1 si el operador2 es de mayor prioridad que el operador1, caso contrario retorna 0
    public int verificarPrioridad(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
                
            case '^':
        }
        return -1;
    }
    
    public int countOperandos(String expression){
        int cont = 0;
        String[] partes = null;
        if(expression.isBlank()){
            return 0;
        }
        else{
            partes = expression.split(" ");
            
            for(String parte : partes){
                if(!("+-*/".contains(parte))){
                    cont++;
                }
            }
            
            return cont;
        }
    }
    
    public Map<String,String> generarMapa(String expression){
        String[] partes = null;
        Map<String,String> mapa = new HashMap<>();
        
        if(expression.isBlank()){
            return null;
        }
        else{
            partes = expression.split(" ");
            for(String parte : partes){
                if(!"+-*/".contains(parte)){
                    mapa.put(parte, null);
                }
            }
            
            return mapa;
        }
    }
    
    public void replaceExpressionTree(Map<String,String> mapa){
        
        for(Map.Entry<String,String> set3 : mapa.entrySet()){
            BinaryNode<String> nodo = variableTree.recursiveSearch(set3.getKey());
            //System.out.println(nodo.getContent());
            nodo.setContent(set3.getValue());
            //System.out.println(nodo.getContent());
                        
        }
    }
}
