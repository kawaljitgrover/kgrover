package designPattern.observer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SubjectTest {
    private Subject underTest;

    @Before
    public void setUp() throws Exception {
        underTest = new Subject();
    }

    @After
    public void tearDown() throws Exception {
        underTest = null;
    }

    @Test
    public void testNotifyObservers() throws Exception {
        // given
        underTest.tempChanged(75);
        Observer observerA = mock(Observer.class);
        Observer observerB = mock(Observer.class);
        underTest.register(observerA);
        underTest.register(observerB);

        // when
        underTest.notifyObservers();

        // then
        WeatherData weatherData = new WeatherData(75);
        verify(observerA).receiveData(weatherData);
        verify(observerA).receiveData(weatherData);
    }

}
