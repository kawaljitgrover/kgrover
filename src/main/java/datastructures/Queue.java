package datastructures;

public class Queue {

    private Integer[] queueArray;
    private int front;
    private int rear;

    private int size;

    public Queue(int maxSize) {
        this.queueArray = new Integer[maxSize];
        rear = -1;
    }

    public void enqueue(Integer element) {
        if (isFull()) {
            throw new RuntimeException("Queue is Full");
        }
        ++size;

        if (rear == queueArray.length - 1) {
            rear = -1;
        }

        queueArray[++rear] = element;
    }

    public Integer dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }
        --size;

        Integer element = queueArray[front++];

        if (front == queueArray.length) {
            front = 0;
        }

        return element;
    }

    public Integer head() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return queueArray[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queueArray.length;
    }

    public int size() {
        return size;
    }

}
