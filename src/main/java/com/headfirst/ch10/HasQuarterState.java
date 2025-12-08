package com.headfirst.ch10;

/**
 * HasQuarterState - represents the state when a quarter has been inserted.
 * 
 * In this state:
 * - insertQuarter() should print an error (can't insert another quarter)
 * - ejectQuarter() should return the quarter and transition to NoQuarterState
 * - turnCrank() should accept the crank turn and transition to SoldState
 * - dispense() should print an error (need to turn crank first)
 * 
 * TODO: Implement the State interface and define the behavior for each method
 */
public class HasQuarterState implements State {
    // TODO: Add a reference to the GumballMachine
    GumballMachine gumballMachine;
    
    // TODO: Create a constructor that takes a GumballMachine parameter
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    // TODO: Implement insertQuarter()
    // Print an error message (you can't insert another quarter)
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }
    
    // TODO: Implement ejectQuarter()
    // Print a message and transition back to NoQuarterState
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }
    
    // TODO: Implement turnCrank()
    // Print a message and transition to SoldState
    public void turnCrank() {
        System.out.println("You turned the crank");
        gumballMachine.setState(gumballMachine.getSoldState());
    }   
    
    // TODO: Implement dispense()
    // Print an error message (you need to turn the crank first)
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
