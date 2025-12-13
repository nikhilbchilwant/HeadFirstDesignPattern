package com.headfirst.ch2.modern;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModernWeatherData {
    private final PropertyChangeSupport support;
    private float temperature;
    private float humidity;
    private float pressure;

    public ModernWeatherData() {
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        float oldTemp = this.temperature;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        
        // Notify listeners with the property name, old value, and new value
        // Use "measurements" to signify a bulk update, or specific properties
        // Passing 'oldTemp' as the old value (though technically we are sending the whole object as new value)
        support.firePropertyChange("measurements", oldTemp, this);
    }

    // Getters
    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}
