package com.headfirst.ch2;

public class WeatherSubscriber implements Observer {
    private String subsciberName;
    private WeatherService weatherService;

    public WeatherSubscriber(String subsciberName, WeatherService weatherService) {
        this.subsciberName = subsciberName;
        this.weatherService = weatherService;
    }

    @Override
    public void update() {
        var weatherData = weatherService.getWeatherData();
        System.out.println(subsciberName + " Temperature: " + weatherData.temperature());
        System.out.println(subsciberName + " Humidity: " + weatherData.humidity());
        System.out.println(subsciberName + " Pressure: " + weatherData.pressure());
    }
}