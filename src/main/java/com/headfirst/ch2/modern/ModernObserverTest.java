package com.headfirst.ch2.modern;

public class ModernObserverTest {
    public static void main(String[] args) {
        System.out.println("--- Modern Observer Pattern (Java Beans) ---");
        
        ModernWeatherData weatherData = new ModernWeatherData();
        ModernCurrentConditionsDisplay currentDisplay = new ModernCurrentConditionsDisplay();
        
        // Register observer
        weatherData.addPropertyChangeListener(currentDisplay);
        
        // Update state
        System.out.println("Updating measurements...");
        weatherData.setMeasurements(80, 65, 30.4f);
        
        System.out.println("Updating measurements again...");
        weatherData.setMeasurements(82, 70, 29.2f);

        // 2. Reactive Streams / RxJava Approach (Conceptual)
        // In a truly modern app (Android/Backend), we might use:
        // weatherSubject.subscribe(data -> updateUI(data));
        // But PropertyChangeSupport is the standard standard library way.
    }
}
