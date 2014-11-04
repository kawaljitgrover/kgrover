package datastructures;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class BFSGraphTest {
    @Test
    public void testBfsTraversal() throws Exception {
        // given
        Graph<String> graph = createGraph();
        BFSGraph<String> underTest = new BFSGraph<>(graph);
        Vertex<String> startingVertex = graph.findVertex("A");

        // when
        List<String> elements = underTest.bfsTraversal(startingVertex);

        // then
        assertThat(elements).containsSequence("A", "B", "D", "C");
    }

    private Graph<String> createGraph() {
        Graph<String> graph = new Graph<>(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        return graph;
    }

}
