package com.headfirst.ch2.modern;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ModernCurrentConditionsDisplay implements PropertyChangeListener {
    private float temperature;
    private float humidity;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("measurements".equals(evt.getPropertyName())) {
            ModernWeatherData weatherData = (ModernWeatherData) evt.getNewValue();
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions: " + temperature 
            + "F degrees and " + humidity + "% humidity");
    }
}
