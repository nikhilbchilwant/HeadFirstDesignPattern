package com.headfirst.ch7.facade;

/**
 * Subsystem component - DVD Player
 */
public class DvdPlayer {
    private String description;
    private String currentMovie;
    
    public DvdPlayer(String description) {
        this.description = description;
    }
    
    public void on() {
        System.out.println(description + " on");
    }
    
    public void off() {
        System.out.println(description + " off");
    }
    
    public void eject() {
        currentMovie = null;
        System.out.println(description + " eject");
    }
    
    public void play(String movie) {
        currentMovie = movie;
        System.out.println(description + " playing \"" + movie + "\"");
    }
    
    public void stop() {
        System.out.println(description + " stopped \"" + currentMovie + "\"");
    }
    
    @Override
    public String toString() {
        return description;
    }
}
