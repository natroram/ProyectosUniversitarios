package tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import tree.BinaryNode;

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
    
    public boolean isIdentical_recursive(BinaryTree<T> tree, Comparator<BinaryNode<T>> cmp){
        if(this == null && tree == null){
            return true;
        }
        else if(this != null && tree != null){
            return ((cmp.compare(tree.getRoot(), this.getRoot()))==0) && (this.getRight().isIdentical_recursive(tree.getRight(), cmp))
                    && (this.getLeft().isIdentical_recursive(tree.getLeft(), cmp));
        }
        return false;
    }
    
    public boolean isIdentical_iterative(BinaryTree<T> tree, Comparator<BinaryNode<T>> cmp){
        Stack<BinaryTree<T>> pila1 = new Stack<>();
        Stack<BinaryTree<T>> pila2 = new Stack<>();
        
        if(this == null && tree == null){
            return true;
        }
        if(this == null || tree == null){
            return false;
        }
        
        pila1.push(this);
        pila2.push(tree);
        
        while(!pila1.empty() && !pila2.empty()){
            
            if(cmp.compare(pila1.peek().getRoot(), pila2.peek().getRoot()) != 0){
                return false;
            }
            
            pila1.pop();
            pila2.pop();
            
            if(this.getLeft() != null && tree.getLeft() != null){
                pila1.push(this.getLeft());
                pila2.push(tree.getLeft());
            }
            else if(this.getLeft() != null || tree.getLeft() != null){
                return false;
            }
            
            if(this.getRight() != null && tree.getRight() != null){
                pila1.push(this.getRight());
                pila2.push(tree.getRight());
            }
            else if(this.getRight() != null || tree.getRight() != null){
                return false;
            }
        }
        
        return true;
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
    
    public int countNodesWithOnlyChild_iterative(){
        Stack<BinaryTree> pila = new Stack<>();
        BinaryTree<T> subtree = new BinaryTree<>();
        int count = 0;
        if(this.isEmpty()){
            return 0;
        }

        else{
            pila.push(this);
            
            while(!pila.empty()){
                subtree = pila.pop();
                if((subtree.getLeft() == null && subtree.getRight() != null) || 
                        (subtree.getRight() == null && subtree.getLeft() != null)){
                count++;
                }
                
                if(subtree.getLeft() != null){
                    pila.push(subtree.getLeft());
                }
                if(subtree.getRight() != null){
                    pila.push(subtree.getRight());
                }
            }
        }
        
        return count;
    }
    
    public boolean isLefty_recursive(){
        if(this == null){
            return true;
        }
        if(this.getLeft() == null || this.getRight() == null){
            return this.getRight() == null;
        }
        
        return this.getLeft().isLefty_recursive() && this.getRight().isLefty_recursive();
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
    
    public boolean isHeightBalanced_recursive(){
        int leftHeight = 0;
        int rightHeight = 0;
        boolean left = false;
        boolean right = false;
        boolean balanced = false;
        
        if(this == null){
            return true;
        }
        else{
            if(this.getLeft() != null){
                leftHeight = this.getLeft().countLevels_recursive();
                left = this.getLeft().isHeightBalanced_recursive();
            }
            if(this.getRight() != null){
                rightHeight = this.getRight().countLevels_recursive();
                right = this.getRight().isHeightBalanced_recursive();
            }
        
            if((Math.abs(leftHeight - rightHeight) <= 1) && left && right){
                balanced = true;
            }
            else{
                balanced = false;
            }
        }
        return balanced;
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
    
    public void largestValueOfEachLevel_iterative(BinaryTree<Integer> tree){
        Stack<BinaryTree<Integer>> pila = new Stack<>();
        BinaryTree<Integer> subtree = new BinaryTree<>();
        ArrayList<Integer> lista = new ArrayList<>();
        Integer max = Integer.MIN_VALUE;
        
        if(tree == null){
            return;
        }
        else{
            pila.push(tree);
            
            while(!pila.empty()){
                int size = pila.size();
                max = Integer.MIN_VALUE;
                
                while(size > 0){
                    subtree = pila.pop();
                    max = Math.max(max, subtree.getRoot().getContent());
                    
                    if(subtree.getLeft() != null){
                        pila.push(subtree.getLeft());
                    }
                    if(subtree.getRight() != null){
                        pila.push(subtree.getRight());
                    }
                }
                lista.add(max);
            }
            
            for(Integer num : lista){
                System.out.print(num + " ");
            }
            System.out.println("\n");
        }
        
    }
    
    public ArrayList<Integer> largestValueOfEachLevel_recursive(BinaryTree<Integer> tree, Integer nivel, ArrayList<Integer> lista){
        Integer max = Integer.MIN_VALUE;
        //Integer nivel = 0;
        
        if(tree == null){
            return null;
        }
        if(nivel >= lista.size()){
            lista.add(tree.getRoot().getContent());
        }
        else{
            lista.set(nivel, Math.max(tree.getRoot().getContent(), lista.get(nivel)));
        }
        if(tree.getLeft() != null){
            tree.getLeft().largestValueOfEachLevel_recursive(tree.getLeft(), nivel++, lista);
        }
        if(tree.getRight() != null){
            tree.getRight().largestValueOfEachLevel_recursive(tree.getRight(), nivel++, lista);
        }
        
        return lista;
    }
    
    public BinaryTree<T> espejo(){
        BinaryTree<T> arbol = new BinaryTree<>();
        
        if(this.isEmpty()){
            return null;
        }
        if(this.isLeaf()){
            return this;
        }
        else{
            BinaryTree<T> temp = new BinaryTree<>();
            arbol.setRoot(root);
            if(this.getLeft() != null){
                
                arbol.getRoot().setRight(this.getRoot().getLeft().espejo());
                arbol.getRoot().setLeft(this.getRoot().getRight().espejo());
                
            }
            if(this.getRight()!= null){
                arbol.getRoot().setLeft(this.getRoot().getRight().espejo());
                arbol.getRoot().setRight(this.getRoot().getLeft().espejo());
            }
            
            return arbol;
        }
        
    }
    
    public BinaryTree<T> espejo_i(){
        BinaryTree<T> subtree = new BinaryTree<>();
        BinaryTree<T> temp = new BinaryTree<>();
        Stack<BinaryTree<T>> pila = new Stack<>();
        if(this.isEmpty()){
            return null;
        }
        
        else{
            pila.push(this);
            
            while(!pila.empty()){
                subtree = pila.pop();
                
                temp = subtree.getRoot().getLeft();
                subtree.setLeft(subtree.getRight());
                subtree.setRight(temp);
                
                if(subtree.getRoot().getLeft() != null){
                    pila.push(subtree.getRoot().getLeft());
                }
                if(subtree.getRoot().getRight() != null){
                    pila.push(subtree.getRoot().getRight());
                }
            }
        }
        
        return this;
    }
    
//    public boolean isMirror(BinaryTree<T> otherTree) {
//        if (otherTree == null) {
//            return false;
//        }
//        return isMirror(root, otherTree.root);
//    }

//    private boolean isMirror(BinaryNode<T> n, BinaryNode<T> Other) {
//        if (n == null && Other == null) {
//            return true;
//        }
//        if ((n == null && Other != null) || (n != null && Other == null) || !n.data.equals(Other.data)) {
//            return false;
//        }
//        return isMirror(n.left, Other.right) && isMirror(n.right, Other.left);
//    }
    
    public void createCompleteTree(ArrayList<T> lista){
        if(lista.isEmpty()){
            return;
        }
        this.setRoot(new BinaryNode<>(lista.get(0)));
        lista.remove(0);
        ArrayList<T> nueva = new ArrayList<>();
        nueva.addAll(lista);
        this.createCompleteTree(nueva, this.getRoot());
        
        
    }
    
    public void createCompleteTree(ArrayList<T> lista, BinaryNode<T> nodo){
        if(nodo.getLeft() == null){
            nodo.getLeft().createCompleteTree(lista);
        }
        else if(nodo.getLeft() != null && nodo.getRight() == null){
            nodo.getRight().createCompleteTree(lista);
        }
        
    }
    
    public BinaryTree<Integer> findIntersection(BinaryTree<Integer> tree){
        BinaryTree<Integer> intersection = new BinaryTree<>();
        if(this.getRoot() != null && tree.getRoot() != null){
            intersection.setRoot(new BinaryNode<>((Integer)this.getRoot().getContent()+tree.getRoot().getContent()));
            
            if(this.getRoot().getLeft() != null && tree.getRoot().getLeft() != null){
                return this.getRoot().getLeft().findIntersection(tree.getRoot().getLeft());
            }
            if(this.getRoot().getLeft() == null || tree.getRoot().getLeft() == null){
                return null;
            }
            if(this.getRoot().getRight() !=  null && tree.getRoot().getRight() !=  null ){
                return this.getRoot().getRight().findIntersection(tree.getRoot().getRight());
            }
            if(this.getRoot().getRight() ==  null || tree.getRoot().getRight() ==  null ){
                return null;
            }
        }
        else{
            return null;
        }
        
        return intersection;
    }
    
    public boolean cumpleHojas(){
        if(this.isEmpty()){
            return true;
        }
        else{
            System.out.println(this.countLeavesRecursive());
            if(this.getRoot().getContent().equals(this.countLeavesRecursive())){
                if(this.getRoot().getLeft() != null){
                    return this.getRoot().getLeft().cumpleHojas();
                }
                if(this.getRoot().getRight() != null){
                    return this.getRoot().getRight().cumpleHojas();
                }
                
            }
            
        }
        return false;
        
    }
    
    public boolean hasSymmetricStructure(){
        if(this.isEmpty()){
            return true;
        }
        else if(this.isLeaf()){
            return true;
        }
        else{
            if(this.getRoot().getRight() != null && this.getRoot().getLeft() != null){
                if((this.getRoot().getRight().getRight() != null && this.getRoot().getLeft().getLeft() != null)
                        || (this.getRoot().getRight().getLeft() != null && this.getRoot().getLeft().getRight() != null)){
                    
                    return this.getRoot().getRight().hasSymmetricStructure() && this.getRoot().getLeft().hasSymmetricStructure();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        
    }
}
