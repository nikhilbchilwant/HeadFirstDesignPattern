package com.headfirst.ch2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherService implements Subject {
    
    private List<Observer> observers;
    private WeatherData weatherData;
    private Random random;

    public WeatherService() {
        observers = new ArrayList<Observer>();     
        weatherData = new WeatherData();
        random = new Random();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void updateWeather() {
        weatherData.setTemperature(random.nextInt(100));
        weatherData.setHumidity(random.nextInt(100));
        weatherData.setPressure(random.nextInt(100));
        notifyObservers();
    }
}