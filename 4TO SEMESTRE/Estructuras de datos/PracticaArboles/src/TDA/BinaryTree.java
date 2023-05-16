/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

/**
 *
 * @author Natalia Ramirez
 */
public class BinaryTree<T> {
    private BTNode<T> root;

    public BinaryTree(BTNode<T> root) {
        this.root = null;
    }

    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> root) {
        this.root = root;
    }
    
    public boolean isLeaf(){
        return this.root.getLeft()== null && this.root.getRight() == null;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public int countNiveles(){
        if(this.isEmpty()){
            return 0;
        }
        else{
            if(this.isLeaf()){
                return 1;
            }
            else{
                int leftLevel = this.root.getLeft() != null ? this.root.getLeft().countNiveles() : 0;
                int rightLevel = this.root.getRight() != null ? this.root.getRight().countNiveles() : 0;
                return 1+Math.max(leftLevel, rightLevel);
            }
        }
    }
}

class BTNode<T>{
    private T content;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BTNode(T content, BinaryTree<T> left, BinaryTree<T> right) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }
    
    
}