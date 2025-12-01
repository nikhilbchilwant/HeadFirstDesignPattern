package com.headfirst.ch7.adapter.oneway;

/**
 * THE ADAPTER - Makes a Turkey look like a Duck!
 * 
 * TODO: Complete this class to make turkeys work where ducks are expected.
 * 
 * PATTERN: Adapter Pattern
 * - Implements the TARGET interface (Duck)
 * - Wraps the ADAPTEE (Turkey)
 * - Translates method calls
 * 
 * YOUR TASKS:
 * 1. Add a private Turkey field
 * 2. Complete the constructor to store the turkey
 * 3. Implement quack() - call turkey.gobble()
 * 4. Implement fly() - call turkey.fly() multiple times (turkeys fly short distances)
 */
public class TurkeyAdapter implements Duck {
    
    // TODO 1: Add a private Turkey field called 'turkey'
    
    
    // TODO 2: Complete the constructor
    public TurkeyAdapter(Turkey turkey) {
        // TODO: Store the turkey in the field
    }
    
    // TODO 3: Implement quack() - delegate to turkey.gobble()
    @Override
    public void quack() {
        // TODO: Make the turkey gobble when duck quacks
    }
    
    // TODO 4: Implement fly()
    // HINT: Turkeys fly short distances, so call turkey.fly() 5 times
    @Override
    public void fly() {
        // TODO: Make the turkey fly multiple times to simulate duck's longer flight
    }
}
