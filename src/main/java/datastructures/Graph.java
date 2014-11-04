package datastructures;

public class Graph<T> {
    private Vertex<T>[] vertexes;
    private int size;
    private int maxSize;
    private int[][] adjacentMatrix;

    public Graph(int maxSize) {
        vertexes = new Vertex[maxSize];
        adjacentMatrix = new int[maxSize][maxSize];
        this.maxSize = maxSize;
    }

    public void addVertex(T data) {
        Vertex<T> vertex = new Vertex<>(data, size);
        vertexes[size++] = vertex;
    }

    public void addEdge(T from, T end) {
        Vertex<T> fromVertex = findVertex(from);
        Vertex<T> endVertex = findVertex(end);
        adjacentMatrix[fromVertex.getIndex()][endVertex.getIndex()] = 1;
        adjacentMatrix[endVertex.getIndex()][fromVertex.getIndex()] = 1;
    }

    private Vertex<T> findVertex(T data) {
        for (Vertex<T> vertex : vertexes) {
            if (vertex.getData().equals(data)) {
                return vertex;
            }
        }
        return null;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }

    public int[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }

}
