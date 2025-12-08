package com.headfirst.ch10;

/**
 * SoldState - represents the state when a gumball is being dispensed.
 * 
 * In this state:
 * - insertQuarter() should print an error (wait, we're giving you a gumball)
 * - ejectQuarter() should print an error (too late, you already turned the crank)
 * - turnCrank() should print an error (you can't turn the crank twice)
 * - dispense() should actually dispense a gumball and transition to appropriate state
 *   (NoQuarterState if gumballs remain, SoldOutState if no gumballs left)
 * 
 * TODO: Implement the State interface and define the behavior for each method
 */
public class SoldState implements State {
    // TODO: Add a reference to the GumballMachine
    GumballMachine gumballMachine;
    
    // TODO: Create a constructor that takes a GumballMachine parameter
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    // TODO: Implement insertQuarter()
    // Print an error message (please wait, we're already giving you a gumball)
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }
    
    // TODO: Implement ejectQuarter()
    // Print an error message (sorry, you already turned the crank)
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }
    
    // TODO: Implement turnCrank()
    // Print an error message (turning twice doesn't get you another gumball)
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }   
    
    // TODO: Implement dispense()
    // Call gumballMachine.releaseBall()
    // Check if count > 0, transition to NoQuarterState
    // Otherwise transition to SoldOutState
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
