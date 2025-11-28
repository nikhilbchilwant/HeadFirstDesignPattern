package com.headfirst.ch2;

public class Main {
    public static void main(String[] args) {
        var weatherService = new WeatherService();
        var weatherSubscriber = new WeatherSubscriber("WeatherSubscriber", weatherService);
        var weatherSubscriber2 = new WeatherSubscriber("WeatherSubscriber2", weatherService);
        
        weatherService.registerObserver(weatherSubscriber);
        weatherService.registerObserver(weatherSubscriber2);
        
        // Update weather data and notify observers
        weatherService.updateWeather();

        weatherService.removeObserver(weatherSubscriber);
        weatherService.updateWeather();
    }
}