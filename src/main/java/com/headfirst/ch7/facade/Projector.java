package com.headfirst.ch7.facade;

/**
 * Subsystem component - Projector
 */
public class Projector {
    private String description;
    private DvdPlayer dvdPlayer;
    
    public Projector(String description) {
        this.description = description;
    }
    
    public void on() {
        System.out.println(description + " on");
    }
    
    public void off() {
        System.out.println(description + " off");
    }
    
    public void wideScreenMode() {
        System.out.println(description + " in widescreen mode (16x9 aspect ratio)");
    }
    
    @Override
    public String toString() {
        return description;
    }
}
