package com.headfirst.ch7.facade;

/**
 * Test drive for Facade Pattern.
 * Shows how the Facade simplifies using a complex subsystem.
 */
public class HomeTheaterTestDrive {
    
    public static void main(String[] args) {
        // Create all the subsystem components
        Amplifier amp = new Amplifier("Top-O-Line Amplifier");
        DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player");
        Projector projector = new Projector("Top-O-Line Projector");
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");
        
        // Create the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            amp, dvd, projector, lights, screen, popper
        );
        
        // Use the simplified interface!
        homeTheater.watchMovie("Raiders of the Lost Ark");
        
        System.out.println("\n");
        
        homeTheater.endMovie();
    }
}
