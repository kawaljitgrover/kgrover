package datastructures;

import java.util.ArrayList;
import java.util.List;

public class BFSGraph<T> {

    private Graph<T> graph;

    public BFSGraph(Graph<T> graph) {
        this.graph = graph;
    }

    public List<T> bfsTraversal(Vertex<T> startingVertex) {
        List<T> elements = new ArrayList<>(graph.size());
        QueueUsingList<Vertex<T>> queue = new QueueUsingList<>();

        startingVertex.setVisited(true);
        queue.enqueue(startingVertex);

        while (queue.size() != 0 ) {
            Vertex<T> dequeuedVertex = queue.dequeue();
            elements.add(dequeuedVertex.getData());

            List<Vertex<T>> unvisitedAdjacentVertexes = graph.getAdjacentUnVisitedVertexes(dequeuedVertex);

            for (Vertex<T> unvisitedAdjacentVertex : unvisitedAdjacentVertexes) {
                unvisitedAdjacentVertex.setVisited(true);
                queue.enqueue(unvisitedAdjacentVertex);
            }
        }

        return elements;
    }

}

