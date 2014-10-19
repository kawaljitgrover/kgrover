package datastructures;

public class Node<T> {
    private int key;
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(int key, T data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
