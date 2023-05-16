package tree;

public class BSTNode<T, K> {
    private T content;
    private K key;
    private BST<T, K> left;
    private BST<T, K> right;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BST<T, K> getLeft() {
        return left;
    }

    public void setLeft(BST<T, K> left) {
        this.left = left;
    }

    public BST<T, K> getRight() {
        return right;
    }

    public void setRight(BST<T, K> right) {
        this.right = right;
    }
    
}
