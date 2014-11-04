package datastructures;

import org.junit.Test;

import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class BFSBinaryTreeTest {
    @Test
    public void testBfsTraversal() throws Exception {

        // given
        BinaryTree<String> binaryTree = new BinaryTree<>(new Node<>(100, "root"));
        addLeftAndRightNodes(binaryTree);
        BFSBinaryTree<String> underTest = new BFSBinaryTree<>(binaryTree);

        // when
        List<String> elements = underTest.bfsTraversal();

        // then
        assertThat(elements).containsSequence("root", "Data50", "Data500", "Data45", "Data90", "Data200", "Data800");
    }

    private void addLeftAndRightNodes(BinaryTree<String> binaryTree) {
        binaryTree.insert(500, "Data500");
        binaryTree.insert(200, "Data200");
        binaryTree.insert(800, "Data800");

        binaryTree.insert(50, "Data50");
        binaryTree.insert(45, "Data45");
        binaryTree.insert(90, "Data90");
    }


}
