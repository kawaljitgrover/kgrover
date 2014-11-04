package datastructures;

public class QueueUsingList<T> {

    private SinglyLinkedList<T> singlyLinkedList;

    public QueueUsingList() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    public void enqueue(T element) {
        singlyLinkedList.insertLast(element);
    }

    public T dequeue() {
        return singlyLinkedList.deleteFirst();

    }

    public T head(){
        return singlyLinkedList.getHead();
    }

    public int size() {
        return singlyLinkedList.size();
    }

}
