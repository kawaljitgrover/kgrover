package datastructures;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public void insert(int key, T data) {
        Node<T> current = root;

        while (current != null) {
            if (key > current.getKey()) {
                if (current.getRight() == null) {
                    Node<T> rightNode = new Node<>(key, data);
                    current.setRight(rightNode);
                    break;
                } else {
                    current = current.getRight();
                    continue;
                }
            }

            if (key < current.getKey()) {
                if (current.getLeft() == null) {
                    Node<T> leftNode = new Node<>(key, data);
                    current.setLeft(leftNode);
                    break;
                } else {
                    current = current.getLeft();
                }
            }
        }

    }

    public Node<T> find(int key) {
        Node<T> current = root;

        while (current != null && current.getKey() != key) {
            if (key > current.getKey()) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        return current;
    }

    public Node<T> delete(int key) {
        throw new NotImplementedException();
    }

    public int size() {
        List<T> elements = new ArrayList<>(0);
        findSizeOfTree(root, elements);
        return elements.size();
    }

    private void findSizeOfTree(Node<T> node, List<T> elements) {
        if (node != null) {
            findSizeOfTree(node.getLeft(), elements);
            findSizeOfTree(node.getRight(), elements);
            elements.add(node.getData());
        }
    }

    public Node<T> findMin() {
        Node<T> current = root;

        while (current != null) {

            if (current.getLeft() == null) {
                return current;
            }

            current = current.getLeft();
        }

        throw new IllegalStateException("It should have at least one node");
    }

    public Node<T> findMax() {
        Node<T> current = root;

        while (current != null) {

            if (current.getRight() == null) {
                return current;
            }

            current = current.getRight();
        }

        throw new IllegalStateException("It should have at least one node");
    }


    public void inOrderTraversal(Node<T> node, List<T> elements) {
        if (node != null) {
            inOrderTraversal(node.getLeft(), elements);
            elements.add(node.getData());
            inOrderTraversal(node.getRight(), elements);
        }
    }

    public void preOrderTraversal(Node<T> node, List<T> elements) {
        if (node != null) {
            elements.add(node.getData());
            preOrderTraversal(node.getLeft(), elements);
            preOrderTraversal(node.getRight(), elements);
        }
    }

    public void postOrderTraversal(Node<T> node, List<T> elements) {
        if (node != null) {
            postOrderTraversal(node.getLeft(), elements);
            postOrderTraversal(node.getRight(), elements);
            elements.add(node.getData());
        }
    }

}
