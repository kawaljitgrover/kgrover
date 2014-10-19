package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class BinaryTreeTest {

    private BinaryTree<String> underTest;
    private Node<String> root;

    @Before
    public void setUp() throws Exception {
        root = new Node<>(100, "root");
        underTest = new BinaryTree<>(root);
    }

    @After
    public void tearDown() throws Exception {
        root = null;
        underTest = null;
    }

    @Test
    public void testInsert() throws Exception {
        underTest.insert(500, "Data500");
        underTest.insert(90, "Data90");

        assertThat(root.getLeft().getData()).isEqualTo("Data90");
        assertThat(root.getRight().getData()).isEqualTo("Data500");
    }

    @Test
    public void testFind() throws Exception {
        addLeftAndRightNodes();

        assertThat(underTest.find(1000)).isNull();
        assertThat(underTest.find(45).getData()).isEqualTo("Data45");
        assertThat(underTest.find(200).getData()).isEqualTo("Data200");
    }

    @Test
    public void testDelete() throws Exception {
        addLeftAndRightNodes();

        Node<String> deletedNode = underTest.delete(500);

        assertThat(deletedNode.getData()).isEqualTo("Data500");
        assertThat(underTest.size()).isEqualTo(6);
    }

    @Test
    public void testSize() throws Exception {
        addLeftAndRightNodes();

        assertThat(underTest.size()).isEqualTo(7);
    }

    @Test
    public void testFindMin() throws Exception {
        addLeftAndRightNodes();

        assertThat(underTest.findMin().getData()).isEqualTo("Data45");
    }

    @Test
    public void testFindMax() throws Exception {
        addLeftAndRightNodes();

        assertThat(underTest.findMax().getData()).isEqualTo("Data800");
    }

    @Test
    public void testInOrderTraversal() throws Exception {
        addLeftAndRightNodes();

        List<String> result = new ArrayList<>();
        underTest.inOrderTraversal(root, result);

        assertThat(result).containsSequence("Data45", "Data50", "Data90", "root", "Data200", "Data500", "Data800");
    }

    @Test
    public void testPreOrderTraversal() throws Exception {
        addLeftAndRightNodes();

        List<String> result = new ArrayList<>();
        underTest.preOrderTraversal(root, result);

        assertThat(result).containsSequence("root", "Data50", "Data45", "Data90", "Data500", "Data200", "Data800");
    }

    @Test
    public void testPostOrderTraversal() throws Exception {
        addLeftAndRightNodes();

        List<String> result = new ArrayList<>();
        underTest.postOrderTraversal(root, result);

        assertThat(result).containsSequence("Data45", "Data90", "Data50", "Data200", "Data800", "Data500", "root");
    }

    private void addLeftAndRightNodes() {
        underTest.insert(500, "Data500");
        underTest.insert(200, "Data200");
        underTest.insert(800, "Data800");

        underTest.insert(50, "Data50");
        underTest.insert(45, "Data45");
        underTest.insert(90, "Data90");
    }

}

