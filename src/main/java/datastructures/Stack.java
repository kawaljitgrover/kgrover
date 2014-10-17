package datastructures;

public class Stack {

    private Integer[] stackArray;

    private int numElements;

    public Stack(int maxSize) {
        this.stackArray = new Integer[maxSize];
    }

    public void push(Integer element) {
        if (isFull()) {
            throw new RuntimeException("Stack is Full");
        }

        stackArray[numElements++] = element;
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        int topIndex = numElements - 1;
        Integer topElement = stackArray[topIndex];
        stackArray[topIndex] = null;
        numElements--;
        return topElement;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }

        int topIndex = numElements - 1;
        return stackArray[topIndex];
    }

    public boolean isFull() {
        return numElements ==  stackArray.length;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public int size(){
        return numElements;
    }

}
