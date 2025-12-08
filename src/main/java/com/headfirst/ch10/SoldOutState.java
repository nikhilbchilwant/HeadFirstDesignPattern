package com.headfirst.ch10;

/**
 * SoldOutState - represents the state when the machine is out of gumballs.
 * 
 * In this state:
 * - insertQuarter() should print an error (machine is sold out)
 * - ejectQuarter() should print an error (you can't eject, you haven't inserted a quarter)
 * - turnCrank() should print an error (you turned but there are no gumballs)
 * - dispense() should print an error (no gumball dispensed)
 * 
 * TODO: Implement the State interface and define the behavior for each method
 */
public class SoldOutState implements State {
    // TODO: Add a reference to the GumballMachine
    GumballMachine gumballMachine;
    
    // TODO: Create a constructor that takes a GumballMachine parameter
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    
    // TODO: Implement insertQuarter()
    // Print an error message (you can't insert a quarter, the machine is sold out)
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }
    // TODO: Implement ejectQuarter()
    // Print an error message (you can't eject, you haven't inserted a quarter yet)
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }
    
    // TODO: Implement turnCrank()
    // Print an error message (you turned, but there are no gumballs)
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }
    // TODO: Implement dispense()
    // Print an error message (no gumball dispensed)
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
