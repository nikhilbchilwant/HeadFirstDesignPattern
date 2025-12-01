package com.headfirst.ch6.command.enterprise;

import java.util.Objects;

/**
 * Enterprise-grade Ceiling Fan with type-safe speed enum.
 * Features: enum-based speeds, validation, logging, state management.
 */
public class CeilingFan {
    
    /**
     * Type-safe enum for fan speeds.
     */
    public enum Speed {
        OFF(0, "Off"),
        LOW(1, "Low"),
        MEDIUM(2, "Medium"),
        HIGH(3, "High");
        
        private final int level;
        private final String description;
        
        Speed(int level, String description) {
            this.level = level;
            this.description = description;
        }
        
        public int getLevel() {
            return level;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    private final String location;
    private Speed speed;

    /**
     * Constructs a CeilingFan with validation.
     * @param location the location of the fan (cannot be null)
     */
    public CeilingFan(String location) {
        this.location = Objects.requireNonNull(location, "Location cannot be null");
        this.speed = Speed.OFF;
        System.out.println("[LOG] CeilingFan created at location: " + location);
    }

    public void high() {
        speed = Speed.HIGH;
        System.out.println("[INFO] " + location + " ceiling fan is on HIGH");
    }

    public void medium() {
        speed = Speed.MEDIUM;
        System.out.println("[INFO] " + location + " ceiling fan is on MEDIUM");
    }

    public void low() {
        speed = Speed.LOW;
        System.out.println("[INFO] " + location + " ceiling fan is on LOW");
    }

    public void off() {
        speed = Speed.OFF;
        System.out.println("[INFO] " + location + " ceiling fan is OFF");
    }

    public Speed getSpeed() {
        return speed;
    }

    public String getLocation() {
        return location;
    }
}
