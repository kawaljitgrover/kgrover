package datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class StackTest {

    private Stack underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Stack(10);

        underTest.push(5);
        underTest.push(10);
        underTest.push(15);
    }

    @After
    public void tearDown() throws Exception {
        underTest = null;
    }

    @Test
    public void testPush() throws Exception {
        assertThat(underTest.size()).isEqualTo(3);

        underTest.push(20);

        assertThat(underTest.size()).isEqualTo(4);
    }

    @Test
    public void testPop() throws Exception {
        assertThat(underTest.pop()).isEqualTo(15);
        assertThat(underTest.size()).isEqualTo(2);
    }

    @Test
    public void testPeek() throws Exception {
        assertThat(underTest.peek()).isEqualTo(15);
        assertThat(underTest.size()).isEqualTo(3);
    }

    @Test
    public void testIsFull() throws Exception {
        assertThat(underTest.isFull()).isFalse();

        underTest.push(4);
        underTest.push(5);
        underTest.push(6);
        underTest.push(7);
        underTest.push(8);
        underTest.push(9);
        underTest.push(10);

        assertThat(underTest.isFull()).isTrue();
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertThat(underTest.isEmpty()).isFalse();

        assertThat(underTest.pop()).isEqualTo(15);
        assertThat(underTest.pop()).isEqualTo(10);
        assertThat(underTest.pop()).isEqualTo(5);

        assertThat(underTest.isEmpty()).isTrue();

    }
}
