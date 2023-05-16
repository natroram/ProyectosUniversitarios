package main;

import java.util.ArrayList;
import java.util.Comparator;
import tree.BinaryNode;
import tree.BinaryTree;

public class Main {

    public static void main(String[] args) {

        System.out.println("Write your code here...");
        
        BinaryTree<Integer> tree = new BinaryTree(5);
        tree.setLeft(new BinaryTree(2));
        tree.setRight(new BinaryTree(3));
        tree.getLeft().setLeft(new BinaryTree(1));
        
        
       
        tree.getRight().setRight(new BinaryTree(2));
        
       
        
        
        BinaryTree<Integer> tree4 = new BinaryTree(1);
        tree4.setLeft(new BinaryTree(2));
        tree4.getLeft().setLeft(new BinaryTree(3));
        
        BinaryTree<Integer> tree3 = new BinaryTree(0);
        tree3.setLeft(new BinaryTree(1));
        tree3.setRight(new BinaryTree(2));
        tree3.getLeft().setLeft(new BinaryTree(3));
        tree3.getLeft().setRight(new BinaryTree(4));
        tree3.getRight().setLeft(new BinaryTree(5));
        tree3.getRight().setRight(new BinaryTree(6));
        tree3.getRight().getRight().setRight(new BinaryTree(7));
        
        BinaryTree<Integer> tree2 = new BinaryTree("Zero");
        tree2.setLeft(new BinaryTree("One"));
        tree2.setRight(new BinaryTree("Two"));
        tree2.getLeft().setLeft(new BinaryTree("Three"));
        tree2.getLeft().setRight(new BinaryTree("Four"));
        tree2.getRight().setRight(new BinaryTree("Five"));
        
//        System.out.println("Imprimiento Preorden:");
//        tree2.printPreordenRecursive();
//        
//        System.out.println("\nImprimiendo Enorden:");
//        tree2.printEnordenRecursive();
//        
//        System.out.println("\nImprimiendo Posorden:");
//        tree2.printPosordenRecursive();
//        
//        BinaryNode<Integer> menor = BinaryTree.getMin_iterative(tree);
//        System.out.println("\nmenor: " + menor.getContent());
//        
//        System.out.println("niveles de arbol: " + tree2.countLevels_recursive());

        
        
        System.out.println(tree.hasSymmetricStructure());
        
        
        
        

        //System.out.println("tree igual tree2: " + tree.isIdentical_recursive(tree2));
        
        /*System.out.println("tree igual a tree3: " + tree.isIdentical_recursive(tree3), (BinaryNode<Integer> node1, BinaryNode<Integer> node2) -> {
                    if(node1.getContent() > node2.getContent()){
                        return 1;
                    }
                    else if(node1.getContent() == node2.getContent()){
                        return 0;
                    }
                    else{
                        return -1;
                    }
                });
        */
        
//        System.out.println("nodos con un solo hijo de tree: " + tree.countNodesWithOnlyChild_iterative());
//        System.out.println("tree4 es lefty: " + tree4.isLefty_iterative());
//        System.out.println("tree2 es balanceado en altura: " + tree2.isHeightBalanced_recursive());
//        ArrayList<Integer> lista = new ArrayList<>();
//        ArrayList<Integer> result = tree.largestValueOfEachLevel_recursive(tree,0,lista);
//        for(Integer num : result){
//            System.out.print(num + " ");
//        }
        
    }

}
