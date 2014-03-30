package designPattern.observer;

public class WeatherData {
    private int temp;

    public WeatherData(int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherData that = (WeatherData) o;

        if (temp != that.temp) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return temp;
    }
}
