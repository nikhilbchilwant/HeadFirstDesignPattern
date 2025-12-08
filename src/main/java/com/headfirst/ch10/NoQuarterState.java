package com.headfirst.ch10;

/**
 * NoQuarterState - represents the state when the machine is waiting for a quarter.
 * 
 * In this state:
 * - insertQuarter() should accept the quarter and transition to HasQuarterState
 * - ejectQuarter() should print an error (no quarter to eject)
 * - turnCrank() should print an error (need to insert quarter first)
 * - dispense() should print an error (can't dispense without payment)
 * 
 * TODO: Implement the State interface and define the behavior for each method
 */
public class NoQuarterState implements State {
    // TODO: Add a reference to the GumballMachine
    GumballMachine gumballMachine;
    
    // TODO: Create a constructor that takes a GumballMachine parameter
    // This allows the state to call methods on the machine (like setState)
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    // TODO: Implement insertQuarter()
    // Print a message and transition to HasQuarterState    
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }
    
    // TODO: Implement ejectQuarter()
    // Print an error message (you haven't inserted a quarter)
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }
    
    // TODO: Implement turnCrank()
    // Print an error message (you need to insert a quarter first)
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }
    
    // TODO: Implement dispense()
    // Print an error message (you need to pay first)
    public void dispense() {
        System.out.println("You need to pay first");
    }
}
