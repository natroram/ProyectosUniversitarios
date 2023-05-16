/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import static TDA.BinaryTree.evaluateExpressionTree;
import java.util.Stack;
import java.lang.RuntimeException;

/**
 *
 * @author Natalia Ramirez
 */
public class BinaryTree<T> {
    private BinaryNode<T> root;

    public BinaryTree() {
        this.root = new BinaryNode<>();
    }

    public BinaryTree(T content) {
        this.root = new BinaryNode<>(content);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public void setLeft(BinaryTree<T> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(BinaryTree<T> tree) {
        this.root.setRight(tree);
    }

    public BinaryTree<T> getLeft() {
        return this.root.getLeft();
    }

    public BinaryTree<T> getRight() {
        return this.root.getRight();
    }

    public boolean isEmpty() {
        return this.getRoot() == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    public int countLeavesRecursive() {
        if (this.isEmpty()) {
            return 0;
        } else if (this.isLeaf()) {
            return 1;
        } else {
            int leavesLeft = 0;
            int leavesRight = 0;
            if (this.root.getLeft() != null) {
                leavesLeft = this.root.getLeft().countLeavesRecursive();
            }
            if (this.root.getRight() != null) {
                leavesRight = this.root.getRight().countLeavesRecursive();
            }
            return leavesLeft + leavesRight;
        }
    }

    public int countLeavesIterative() {
        Stack<BinaryTree<T>> stack = new Stack();
        int count = 0;
        if (this.isEmpty()) {
            return count;
        } else {
            stack.push(this);
            while (!stack.empty()) {
                BinaryTree<T> subtree = stack.pop();
                if (subtree.root.getLeft() != null) {
                    stack.push(subtree.root.getLeft());
                }
                if (subtree.root.getRight() != null) {
                    stack.push(subtree.root.getRight());
                }
                if (subtree.isLeaf()) {
                    count++;
                }
            }
        }
        return count;
    }

    public BinaryNode<T> recursiveSearch(T content) {
        if (this.isEmpty()) {
            return null;
        } else {
            if (this.root.getContent().equals(content)) {
                return this.root;
            } else {
                BinaryNode<T> tmp = null;
                if (this.root.getLeft() != null) {
                    tmp = this.root.getLeft().recursiveSearch(content);
                }
                if (tmp == null) {
                    if (this.root.getRight() != null) {
                        return this.root.getRight().recursiveSearch(content);
                    }
                }
                return tmp;
            }
        }
    }
    
    //TALLER - CORREGIDO
    
    public BinaryNode<T> iterativeSearch(T content){
        Stack<BinaryTree> pila = new Stack<>();
        BinaryTree<T> subtree = new BinaryTree<>();
        BinaryNode<T> nodo = new BinaryNode<>();
        if(this.isEmpty()){
            return null;
        }
        else{
            pila.push(this);
            while(!pila.empty()){
                while (!pila.empty()) {
                    subtree = pila.pop();
                    if(subtree.getRoot().getContent().equals(content)){
                        nodo = subtree.getRoot();
                    }
                    
                    if (subtree.getLeft() != null ) {
                        pila.push(subtree.getLeft());
                    }
                    if (subtree.getRight() != null) {
                        pila.push(subtree.getRight());
                    }
                
                }
                
            }
            return nodo;
        }
    }
    
    public void printPreordenRecursive(){
        if(this.isEmpty()){
            System.out.println("The tree is empty");
        }
        else{
            System.out.print(this.root.getContent()+" ");
            
            if(this.root.getLeft() != null){
                this.root.getLeft().printPreordenRecursive();
            }
            
            if(this.root.getRight() != null){
                this.root.getRight().printPreordenRecursive();
            }
        }
    }
    
    public void printEnordenRecursive(){
        if(this.isEmpty()){
            System.out.println("The tree is empty");
        }
        else{
            if(this.root.getLeft() != null){
                this.root.getLeft().printEnordenRecursive();
            }
            
            System.out.print(this.root.getContent()+" ");
            
            if(this.root.getRight() != null){
                this.root.getRight().printEnordenRecursive();
            }
        }
    }
    
    public void printPosordenRecursive(){
        if(this.isEmpty()){
            System.out.println("The tree is empty");
        }
        else{
            if(this.root.getLeft() != null){
                this.root.getLeft().printPosordenRecursive();
            }

            if(this.root.getRight() != null){
                this.root.getRight().printPosordenRecursive();
            }
            
            System.out.print(this.root.getContent()+" ");
        }
    }
    
    //TAREA PARA 11 DEC 
    
    public static BinaryNode<Integer> getMin_recursive(BinaryTree<Integer> tree){
        BinaryNode<Integer> minRight = null;
        BinaryNode<Integer> minLeft = null;
        if(tree.isEmpty()){
            return null;
        }
        if(tree.isLeaf()){
            return tree.getRoot();
        }
        else{
            if(!tree.getRight().isEmpty()){
                if(tree.getRight().getRoot().getContent() < tree.root.getContent()){
                    minRight = getMin_recursive(tree.getRight());
                }
                else{
                    minRight = tree.getRoot();
                }
            }
            if(!tree.getLeft().isEmpty()){
                if(tree.getRoot().getLeft().getRoot().getContent() < tree.getRoot().getContent()){
                    minLeft = getMin_recursive(tree.getLeft());
                }
                else{
                    minLeft = tree.getRoot();
                }
            }
            if(minRight == null){
                return minLeft;
            }
            if(minLeft == null){
                return minRight;
            }
            else{
                if(minRight.getContent() < minLeft.getContent()){
                    return minRight;
                }
                else{
                    return minLeft;
                }
            }
        }
    }
    
    public static BinaryNode<Integer> getMin_iterative(BinaryTree<Integer> tree){
        Stack<BinaryTree<Integer>> pila = new Stack<>();
        BinaryTree<Integer> subtree = null;
        BinaryNode<Integer> minNode = new BinaryNode<>();

        if(tree.isEmpty()){
            return null;
        }
        if(tree.isLeaf()){
            return tree.getRoot();
        }
        else{
            pila.push(tree);
            minNode = tree.getRoot();
            
            while(!pila.empty()){
                subtree = pila.pop();
                
                if(subtree.getRoot().getContent() < minNode.getContent()){
                    minNode = subtree.getRoot();
                }
                if(subtree.getRight() != null){
                    pila.push(subtree.getRight());
                }
                if(subtree.getLeft() != null){
                    pila.push(subtree.getLeft());
                }
            }
            return minNode;
        }
    }
    
    public int countLevels_recursive(){
        int rightLevels = 0;
        int leftLevels = 0;
        
        if(this.isEmpty()){
            return 0;
        }
        
        else{
            if(this.getRight() != null){
                rightLevels = this.getRight().countLevels_recursive();
            }
            if(this.getLeft() != null){
                leftLevels = this.getLeft().countLevels_recursive();
            }
            
            if(rightLevels > leftLevels){
                return rightLevels + 1;
            }
            else{
                return leftLevels + 1;
            }
        }
        
    }
    
    public int countLevels_iterative(){
        Stack<BinaryTree<T>> pila = new Stack<>();
        BinaryTree<T> subtree = new BinaryTree<>();
        int count = -1;
        int size = 0;
        if(this.isEmpty()){
            return 0;
        }
        else{
            pila.push(this);
            while(true){
                size = pila.size();
                if(size == 0){
                    return count;
                }
                count++;
                while(size > 0){
                    subtree = pila.pop();
                
                    if(subtree.getRight() != null){
                        pila.push(subtree.getRight());
                    }
                    if(subtree.getLeft() != null){
                        pila.push(subtree.getLeft());
                    }
                    size--;
                
                }
            }
        }
    }
    
    public int countNodesWithOnlyChild_recursive(){
        int count = 0;
        if(this.isEmpty()){
            return count;
        }
        else{
            if((this.getLeft() == null && this.getRight() != null) || (this.getRight() == null && this.getLeft() != null)){
                count++;
            }
            else{
                if(this.getLeft() != null){
                    count += this.getLeft().countNodesWithOnlyChild_recursive();
                }
                if(this.getRight() != null){
                    count += this.getRight().countNodesWithOnlyChild_recursive();
                }
            }
            
        }
        return count;
    }
    
    public boolean isLefty_iterative(){
        Stack<BinaryTree<T>> pila = new Stack<>();
        BinaryTree<T> subtree = new BinaryTree<>();
        int result = 0;
        if(this == null || this.isLeaf()){
            return true;
        }
        else{
            pila.push(this);
            
            while(!pila.empty()){
                subtree = pila.pop();
                
                if(subtree.getLeft() == null || subtree.getRight() == null){
                    if(subtree.getRight() != null){
                        result++;
                    }
                }
                else{
                    if(subtree.getLeft() != null){
                        pila.push(subtree.getLeft());
                    }
                    if(subtree.getRight() != null){
                        pila.push(subtree.getRight());
                    }
                }
            }
            
            return result == 0;
        }
    }
    
    public boolean isHeightBalanced_iterative(){
        Stack<BinaryTree<T>> pila = new Stack<>();
        BinaryTree<T> subtree = new BinaryTree<>();
        int leftHeight = 0;
        int rightHeight = 0;
        boolean balanced = false;
        
        
        if(this == null){
            return true;
        }
        
        pila.push(this);
        
        while(!pila.empty()){
            subtree = pila.pop();
            
            if(subtree.getLeft() != null){
                leftHeight = subtree.getLeft().countLevels_recursive();
            }
            if(subtree.getRight() != null){
                rightHeight = subtree.getRight().countLevels_recursive();
            }
            
            if(Math.abs(leftHeight - rightHeight) <= 1){
                balanced = true;
            }
            
        }
        
        return balanced;
    }
    
    //METODOS CREADOS PARA TAREA ARBOLES DE EXPRESION
    
    public static BinaryTree<String> generateExpressionTree(String postfixExp){
        
        Stack<BinaryTree<String>> pila = new Stack<>();
        String[] partes = null;
        
        if(postfixExp.isBlank()){
            return null;
        }
        else{
            partes = postfixExp.split(" ");
            for(String parte : partes){
                if("+-*/".contains(parte)){
                    BinaryTree<String> tree = new BinaryTree<>(parte);
                    if(pila.size()>=2){
                        tree.setRight(pila.pop());
                        tree.setLeft(pila.pop());
                        pila.push(tree);
                    }
                }
                else{
                    BinaryTree<String> leaf = new BinaryTree<>(parte);
                    pila.push(leaf);
                }
            }
            
            return pila.pop();
        }
    }
    
    public static double evaluateExpressionTree(BinaryTree<String> tree){
        if(tree.isEmpty()){
            return 0;
        }
        if(tree.isLeaf()){
            if(isNumeric(tree.getRoot().getContent())){
                return Double.parseDouble(tree.getRoot().getContent());
            }
            else{
                //throw RuntimeException
                return Double.MIN_VALUE;
            }
        }
        else{
            if(tree.getRoot().getContent().equals("+")){
                return evaluateExpressionTree(tree.getLeft()) + evaluateExpressionTree(tree.getRight());
            }
            else if(tree.getRoot().getContent().equals("-")){
                return evaluateExpressionTree(tree.getLeft()) - evaluateExpressionTree(tree.getRight());
            }
            else if(tree.getRoot().getContent().equals("*")){
                return evaluateExpressionTree(tree.getLeft()) * evaluateExpressionTree(tree.getRight());
            }
            else if(tree.getRoot().getContent().equals("/")){
                return evaluateExpressionTree(tree.getLeft()) / evaluateExpressionTree(tree.getRight());
            }
            
            return Double.MIN_VALUE;
        }
    }
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
