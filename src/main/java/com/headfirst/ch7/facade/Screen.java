package com.headfirst.ch7.facade;

/**
 * Subsystem component - Screen
 */
public class Screen {
    private String description;
    
    public Screen(String description) {
        this.description = description;
    }
    
    public void up() {
        System.out.println(description + " going up");
    }
    
    public void down() {
        System.out.println(description + " going down");
    }
    
    @Override
    public String toString() {
        return description;
    }
}
