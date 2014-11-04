package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    private Graph<String> underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Graph<>(4);

        assertFalse(underTest.isFull());

        underTest.addVertex("A");
        underTest.addVertex("B");
        underTest.addVertex("C");
        underTest.addVertex("D");

        assertTrue(underTest.isFull());
    }

    @After
    public void tearDown() throws Exception {
        underTest = null;
    }

    @Test
    public void testAddEdge() throws Exception {
        underTest.addEdge("A", "B");
        underTest.addEdge("A", "D");
        underTest.addEdge("B", "C");
        underTest.addEdge("B", "D");

        int[][] adjacentMatrix = underTest.getAdjacentMatrix();

        assertEquals(1, adjacentMatrix[0][1]);
        assertEquals(1, adjacentMatrix[1][0]);
        assertEquals(1, adjacentMatrix[0][3]);
        assertEquals(1, adjacentMatrix[3][0]);
        assertEquals(1, adjacentMatrix[1][2]);
        assertEquals(1, adjacentMatrix[2][1]);
        assertEquals(1, adjacentMatrix[1][3]);
        assertEquals(1, adjacentMatrix[3][1]);
        assertEquals(0, adjacentMatrix[0][0]);
        assertEquals(0, adjacentMatrix[1][1]);
        assertEquals(0, adjacentMatrix[2][2]);
        assertEquals(0, adjacentMatrix[3][3]);
        assertEquals(0, adjacentMatrix[0][2]);
        assertEquals(0, adjacentMatrix[2][0]);
        assertEquals(0, adjacentMatrix[2][3]);
        assertEquals(0, adjacentMatrix[3][2]);
    }
}
