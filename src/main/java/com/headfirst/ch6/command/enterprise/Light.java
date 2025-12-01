package com.headfirst.ch6.command.enterprise;

import java.util.Objects;

/**
 * Enterprise-grade Light receiver.
 * Features: immutability, validation, logging.
 */
public class Light {
    private final String location;
    private boolean isOn;

    /**
     * Constructs a Light with validation.
     * @param location the location of the light (cannot be null)
     * @throws NullPointerException if location is null
     */
    public Light(String location) {
        this.location = Objects.requireNonNull(location, "Location cannot be null");
        this.isOn = false;
        System.out.println("[LOG] Light created at location: " + location);
    }

    public void on() {
        isOn = true;
        System.out.println("[INFO] " + location + " light is ON");
    }

    public void off() {
        isOn = false;
        System.out.println("[INFO] " + location + " light is OFF");
    }

    public String getLocation() {
        return location;
    }

    public boolean isOn() {
        return isOn;
    }
}
