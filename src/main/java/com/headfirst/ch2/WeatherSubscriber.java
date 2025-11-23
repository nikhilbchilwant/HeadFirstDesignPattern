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
        WeatherData weatherData = weatherService.getWeatherData();
        System.out.println(subsciberName + " Temperature: " + weatherData.getTemperature());
        System.out.println(subsciberName + " Humidity: " + weatherData.getHumidity());
        System.out.println(subsciberName + " Pressure: " + weatherData.getPressure());
    }
}