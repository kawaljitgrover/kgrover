package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class DoublyLinkedListTest {

    private DoublyLinkedList<String> underTest = new DoublyLinkedList<>();

    @Before
    public void setUp() throws Exception {
        underTest.insertFirst("John");
        underTest.insertFirst("Sam");
    }

    @After
    public void tearDown() throws Exception {
        underTest = null;
    }

    @Test
    public void testInsertFirst() throws Exception {
        assertThat(underTest.toString()).isEqualTo("Sam->John");

        underTest.insertFirst("Jack");

        assertThat(underTest.toString()).isEqualTo("Jack->Sam->John");
        assertThat(underTest.getFirst()).isEqualTo("Jack");
        assertThat(underTest.getLast()).isEqualTo("John");
    }

    @Test
    public void testInsertLast() throws Exception {
        assertThat(underTest.toString()).isEqualTo("Sam->John");

        underTest.insertLast("Joseph");

        assertThat(underTest.toString()).isEqualTo("Sam->John->Joseph");
    }

    @Test
    public void testDeleteFirst() throws Exception {
        assertThat(underTest.toString()).isEqualTo("Sam->John");

        assertThat(underTest.deleteFirst()).isEqualTo("Sam");

        assertThat(underTest.toString()).isEqualTo("John");
    }

    @Test
    public void testDeleteLast() throws Exception {
        assertThat(underTest.toString()).isEqualTo("Sam->John");

        assertThat(underTest.deleteLast()).isEqualTo("John");

        assertThat(underTest.toString()).isEqualTo("Sam");
    }

    @Test
    public void testDelete() throws Exception {
        underTest.insertAfter("Sam", "Ron");

        assertThat(underTest.toString()).isEqualTo("Sam->Ron->John");

        assertThat(underTest.delete("Jack")).isFalse();
        assertThat(underTest.delete("Ron")).isTrue();

        assertThat(underTest.toString()).isEqualTo("Sam->John");
    }

    @Test
    public void testInsertAfter() throws Exception {
        assertThat(underTest.toString()).isEqualTo("Sam->John");

        underTest.insertAfter("John", "Rahul");
        underTest.insertAfter("John", "Rony");

        assertThat(underTest.toString()).isEqualTo("Sam->John->Rony->Rahul");
    }

    @Test
    public void testInsertBefore() throws Exception {
        assertThat(underTest.toString()).isEqualTo("Sam->John");

        underTest.insertBefore("Sam", "Rahul");
        underTest.insertBefore("Sam", "Rony");

        assertThat(underTest.toString()).isEqualTo("Rahul->Rony->Sam->John");
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(underTest.isEmpty()).isFalse();

        underTest.deleteFirst();
        underTest.deleteLast();

        assertThat(underTest.isEmpty()).isTrue();
    }

    @Test
    public void testSize() throws Exception {
        assertThat(underTest.size()).isEqualTo(2);

        underTest.insertFirst("Tony");

        assertThat(underTest.size()).isEqualTo(3);
    }
}
