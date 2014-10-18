package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> underTest = new SinglyLinkedList<>();

    @Before
    public void setUp() throws Exception {
        underTest.insertFirst(10);
        underTest.insertFirst(5);
    }

    @After
    public void tearDown() throws Exception {
        underTest = null;
    }

    @Test
    public void testInsertFirst() throws Exception {
        assertThat(underTest.size()).isEqualTo(2);

        underTest.insertFirst(2);

        assertThat(underTest.size()).isEqualTo(3);
        assertThat(underTest.getHead()).isEqualTo(2);
        assertThat(underTest.toString()).isEqualTo("2->5->10");
    }

    @Test
    public void testInsertLast() throws Exception {
        assertThat(underTest.size()).isEqualTo(2);

        underTest.insertLast(15);

        assertThat(underTest.size()).isEqualTo(3);
        assertThat(underTest.getTail()).isEqualTo(15);
        assertThat(underTest.toString()).isEqualTo("5->10->15");
    }

    @Test
    public void testInsertAfter() throws Exception {
        assertThat(underTest.isExist(7)).isFalse();

        underTest.insertAfter(5, 7);

        assertThat(underTest.isExist(7)).isTrue();
        assertThat(underTest.toString()).isEqualTo("5->7->10");
    }

    @Test
    public void testInsertBefore() throws Exception {
        assertThat(underTest.isExist(8)).isFalse();

        underTest.insertBefore(10, 8);

        assertThat(underTest.isExist(8)).isTrue();
        assertThat(underTest.toString()).isEqualTo("5->8->10");
    }

    @Test
    public void testDeleteFirst() throws Exception {
        assertThat(underTest.deleteFirst()).isEqualTo(5);
        assertThat(underTest.toString()).isEqualTo("10");
    }

    @Test
    public void testDeleteLast() throws Exception {
        assertThat(underTest.deleteLast()).isEqualTo(10);
        assertThat(underTest.toString()).isEqualTo("5");
    }

    @Test
    public void testIsExist() throws Exception {
        assertThat(underTest.isExist(200)).isFalse();
        assertThat(underTest.isExist(10)).isTrue();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(underTest.isEmpty()).isFalse();

        assertThat(underTest.deleteFirst()).isEqualTo(5);
        assertThat(underTest.deleteFirst()).isEqualTo(10);

        assertThat(underTest.isEmpty()).isTrue();
        assertThat(underTest.toString()).isEqualTo("");
    }

}
