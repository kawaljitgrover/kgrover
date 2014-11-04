package datastructures;

public class Vertex<T> {
    private T data;
    private int index;
    private boolean visited;

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

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}
