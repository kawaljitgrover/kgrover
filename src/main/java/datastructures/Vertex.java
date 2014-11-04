package datastructures;

public class Vertex<T> {
    private T data;
    private int index;

    public Vertex(T data, int index) {
        this.data = data;
        this.index = index;
    }

    public T getData() {
        return data;
    }

    public int getIndex() {
        return index;
    }

}
