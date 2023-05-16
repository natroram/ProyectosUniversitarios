package tree;

import java.util.Comparator;

public class BST<T, K> {

    private BSTNode<T, K> root;
    private Comparator<K> cmp;
    
    public BST(Comparator<K> cmp){
        this.cmp = cmp;
        this.root = null;
    }

    public BSTNode<T, K> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<T, K> root) {
        this.root = root;
    }

    public Comparator<K> getCmp() {
        return cmp;
    }

    public void setCmp(Comparator<K> cmp) {
        this.cmp = cmp;
    }
    
    public boolean isEmpty(){
        return this.root == null;
    }
    
    public boolean insertNode(BSTNode<T,K> nodo){
        if(this.isEmpty()){
            this.setRoot(nodo);
            return true;
        }
        else{
            int comparacion = this.cmp.compare(nodo.getKey(), this.root.getKey());
            if(comparacion > 0){
                if(this.getRoot().getRight().isEmpty()){
                    this.getRoot().getRight().setRoot(nodo);
                }
                else{
                    return this.root.getRight().insertNode(nodo);
                }
            }
            else if(comparacion < 0){
                if(this.getRoot().getLeft().isEmpty()){
                    this.getRoot().getLeft().setRoot(nodo);
                }
                else{
                    return this.root.getLeft().insertNode(nodo);
                }
            }
        }
        return false;
    }
    
    public BSTNode<T,K> searchNode(K clave){
        
        if(this.isEmpty()){
            return null;
        }
        else{
            int comparacion = this.cmp.compare(clave, this.root.getKey());
            if(comparacion > 0){
                return this.root.getRight().searchNode(clave);
            }
            else if(comparacion < 0){
                return this.root.getLeft().searchNode(clave);
            }
            else{
                return this.root;
            }
        }
    }
    
    public boolean deleteNode(BSTNode<T,K> nodo){
        BSTNode<T,K> p = this.searchNode(nodo.getKey());
        
        if((!p.getLeft().isEmpty())&&(!p.getRight().isEmpty())){
            BSTNode<T,K> q = null;
            while(p.getLeft().getCmp().compare(q.getKey(), p.getLeft().getRoot().getKey())>0){
                q = p.getLeft().getRoot();
            }
            p.setContent(q.getContent());
            
        }
        else{
            
        }
        return false;
    }

}
