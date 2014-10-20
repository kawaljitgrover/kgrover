package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class QueueTest {

    private Queue underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Queue(5);
    }

    @After
    public void tearDown() throws Exception {
        underTest = null;
    }

    @Test
    public void testEnqueue() throws Exception {
        underTest.enqueue(50);
        underTest.enqueue(100);

        assertThat(underTest.size()).isEqualTo(2);
        assertThat(underTest.head()).isEqualTo(50);
    }

    @Test
    public void testDequeue() throws Exception {
        underTest.enqueue(5);
        underTest.enqueue(7);
        underTest.enqueue(10);

        assertThat(underTest.head()).isEqualTo(5);
        assertThat(underTest.dequeue()).isEqualTo(5);
        assertThat(underTest.head()).isEqualTo(7);
        assertThat(underTest.size()).isEqualTo(2);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(underTest.isEmpty()).isTrue();

        underTest.enqueue(10);

        assertThat(underTest.isEmpty()).isFalse();
    }

    @Test
    public void testSize() throws Exception {
        underTest.enqueue(10);
        underTest.enqueue(20);
        underTest.enqueue(30);

        assertThat(underTest.dequeue()).isEqualTo(10);

        assertThat(underTest.size()).isEqualTo(2);
    }

    @Test
    public void testIsFull() throws Exception {
        underTest.enqueue(1);
        underTest.enqueue(2);
        underTest.enqueue(3);
        underTest.enqueue(4);
        underTest.enqueue(5);

        assertThat(underTest.isFull()).isTrue();
    }

    @Test
    public void testCircularConditionForHead() throws Exception {
        underTest.enqueue(1);
        underTest.enqueue(2);
        underTest.enqueue(3);
        underTest.enqueue(4);
        underTest.enqueue(5);

        assertThat(underTest.dequeue()).isEqualTo(1);

        underTest.enqueue(6);

        assertThat(underTest.head()).isEqualTo(2);
        assertThat(underTest.size()).isEqualTo(5);
    }

    @Test
    public void testCircularConditionForFront() throws Exception {
        underTest.enqueue(1);
        underTest.enqueue(2);
        underTest.enqueue(3);
        underTest.enqueue(4);
        underTest.enqueue(5);

        assertThat(underTest.dequeue()).isEqualTo(1);
        assertThat(underTest.dequeue()).isEqualTo(2);
        assertThat(underTest.dequeue()).isEqualTo(3);
        assertThat(underTest.dequeue()).isEqualTo(4);
        assertThat(underTest.dequeue()).isEqualTo(5);

        underTest.enqueue(6);

        assertThat(underTest.head()).isEqualTo(6);
        assertThat(underTest.size()).isEqualTo(1);
        assertThat(underTest.dequeue()).isEqualTo(6);
        assertThat(underTest.isEmpty()).isTrue();
    }

}
