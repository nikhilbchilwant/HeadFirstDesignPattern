package com.headfirst.ch2;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        WeatherSubscriber weatherSubscriber = new WeatherSubscriber("WeatherSubscriber", weatherService);
        WeatherSubscriber weatherSubscriber2 = new WeatherSubscriber("WeatherSubscriber2", weatherService);
        
        weatherService.registerObserver(weatherSubscriber);
        weatherService.registerObserver(weatherSubscriber2);
        
        // Update weather data and notify observers
        weatherService.updateWeather();

        weatherService.removeObserver(weatherSubscriber);
        weatherService.updateWeather();
    }
}