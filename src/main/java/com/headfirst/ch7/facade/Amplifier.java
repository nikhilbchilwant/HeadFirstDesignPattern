package com.headfirst.ch7.facade;

/**
 * Subsystem component - Amplifier
 */
public class Amplifier {
    private String description;
    private DvdPlayer dvd;
    
    public Amplifier(String description) {
        this.description = description;
    }
    
    public void on() {
        System.out.println(description + " on");
    }
    
    public void off() {
        System.out.println(description + " off");
    }
    
    public void setDvd(DvdPlayer dvd) {
        this.dvd = dvd;
        System.out.println(description + " setting DVD player to " + dvd);
    }
    
    public void setSurroundSound() {
        System.out.println(description + " surround sound on (5 speakers, 1 subwoofer)");
    }
    
    public void setVolume(int level) {
        System.out.println(description + " setting volume to " + level);
    }
    
    @Override
    public String toString() {
        return description;
    }
}
