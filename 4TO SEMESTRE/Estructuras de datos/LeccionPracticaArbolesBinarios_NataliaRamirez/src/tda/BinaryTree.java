package tda;

import java.util.Stack;

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
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }
    
    
    
    public int countNodesWithOnlyChild_recursive(){
        int count = 0;
        if(this.isEmpty()){
            return 0;
        }
        if(this.isLeaf()){
            return 0;
        }
        else{
            if(this.getLeft().isEmpty() | this.getRight().isEmpty()){
                count++;
            }
            else{
                if(!this.getLeft().isEmpty()){
                    this.getLeft().countNodesWithOnlyChild_recursive();
                }
                if(!this.getRight().isEmpty()){
                    this.getRight().countNodesWithOnlyChild_recursive();
                }
            }
        }
        return count;
    }
    
    public int countNodesWithOnlyChild_iterative(){
        Stack<BinaryTree> pila = new Stack<>();
        BinaryTree<T> tree = null;
        int count = 0;
        if(this.isEmpty()){
            return 0;
        }
        if(this.isLeaf()){
            return 0;
        }
        else{
            if(this.getLeft().isEmpty() | this.getRight().isEmpty()){
                count++;
            }
            else{
                if(!this.getLeft().isEmpty()){
                    pila.push(this.getLeft());
                    
                }
                if(!this.getRight().isEmpty()){
                    pila.push(this.getRight());
                }
            }
        }
        
        return count;
    }

}