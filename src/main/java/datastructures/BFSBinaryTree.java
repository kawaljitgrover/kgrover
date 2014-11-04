package datastructures;

import java.util.ArrayList;
import java.util.List;

public class BFSBinaryTree<T> {

    private BinaryTree<T> binaryTree;

    public BFSBinaryTree(BinaryTree<T> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public List<T> bfsTraversal() {
        List<T> elements = new ArrayList<>(binaryTree.size());
        QueueUsingList<Node<T>> queue = new QueueUsingList<>();
        Node<T> current = binaryTree.getRoot();
        queue.enqueue(current);

        while (queue.size() != 0) {
            Node<T> dequeuedNode = queue.dequeue();
            elements.add(dequeuedNode.getData());

            Node<T> leftNode = dequeuedNode.getLeft();
            if (leftNode != null) {
                queue.enqueue(leftNode);
            }

            Node<T> rightNode = dequeuedNode.getRight();
            if (rightNode != null) {
                queue.enqueue(rightNode);
            }
        }

        return elements;
    }

}
