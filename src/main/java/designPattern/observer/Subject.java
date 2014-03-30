package designPattern.observer;

import java.util.Collection;
import java.util.HashSet;

public class Subject {
    private WeatherData weatherData;
    
    private Collection<Observer> observers = new HashSet<Observer>(0);
    
    public void register(Observer observer) {
        observers.add(observer);
    }
    
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        if (weatherData != null) {
            for (Observer observer : observers) {
                observer.receiveData(weatherData);
            }
        }
    }
    
    public void tempChanged(int newTemp) {
        this.weatherData = new WeatherData(newTemp);
    }
    
}
