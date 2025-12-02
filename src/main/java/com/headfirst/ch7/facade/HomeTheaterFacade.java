package com.headfirst.ch7.facade;

/**
 * THE FACADE - Simplifies the complex home theater subsystem!
 * 
 * TODO: Complete this class to provide a simple interface for watching movies.
 * 
 * PATTERN: Facade Pattern
 * - Wraps a complex subsystem (6 components)
 * - Provides simplified methods (watchMovie, endMovie)
 * - Follows Principle of Least Knowledge
 * 
 * YOUR TASKS:
 * 1. Add private fields for all 6 components
 * 2. Complete constructor to store all components
 * 3. Implement watchMovie(String) - orchestrate all setup steps
 * 4. Implement endMovie() - orchestrate all cleanup steps
 * 
 * STEPS FOR watchMovie():
 * - Turn on popcorn popper, start popping
 * - Dim lights to 10%
 * - Put screen down
 * - Turn on projector, set to widescreen
 * - Turn on amplifier, set to DVD, surround sound, volume 5
 * - Turn on DVD player, play the movie
 * 
 * STEPS FOR endMovie():
 * - Reverse all the watchMovie steps
 */
public class HomeTheaterFacade {
    
    // TODO 1: Add private fields for all components
    Amplifier amp;
    DvdPlayer dvd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;
    
    
    // TODO 2: Complete constructor
    public HomeTheaterFacade(
            Amplifier amp,
            DvdPlayer dvd,
            Projector projector,
            TheaterLights lights,
            Screen screen,
            PopcornPopper popper) {
        // TODO: Store all components in fields
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }
    
    // TODO 3: Implement watchMovie()
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        // TODO: Implement the movie watching sequence
        // HINT: Follow the steps listed in the class comment above
        popper.on();
        popper.pop();
        lights.on();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }
    
    // TODO 4: Implement endMovie()
    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        // TODO: Implement the cleanup sequence (reverse of watchMovie)
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.off();
    }
}
