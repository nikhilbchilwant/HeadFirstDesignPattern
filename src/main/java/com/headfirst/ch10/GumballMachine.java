package com.headfirst.ch10;

/**
 * GumballMachine - the Context class that maintains the current state
 * and delegates all actions to the current state object.
 * 
 * This class should:
 * 1. Hold references to all possible state objects
 * 2. Maintain a reference to the current state
 * 3. Track the number of gumballs
 * 4. Provide methods to change state
 * 5. Delegate action methods to the current state
 * 
 * TODO: Complete the implementation
 */
public class GumballMachine {
    // TODO: Declare state object references
    State soldOutState, noQuarterState, hasQuarterState, soldState;
    
    // TODO: Declare current state reference
    State currentState;
    
    // TODO: Declare gumball count
    int count = 0;
    
    /**
     * Constructor - initializes the machine with a given number of gumballs
     * 
     * TODO: 
     * 1. Initialize all state objects (pass 'this' to their constructors)
     * 2. Set the count
     * 3. Set initial state (SoldOutState if count = 0, otherwise NoQuarterState)
     */
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            currentState = noQuarterState;
        } else {
            currentState = soldOutState;
        }
    }
    
    /**
     * Action methods - these should delegate to the current state
     */
    
    // TODO: Implement insertQuarter()
    public void insertQuarter() {
        currentState.insertQuarter();
    }
    
    // TODO: Implement ejectQuarter()
    public void ejectQuarter() {
        currentState.ejectQuarter();
    }
    
    // TODO: Implement turnCrank()
    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }
    
    /**
     * Helper method to actually release a gumball
     * This is called by the SoldState when dispensing
     */
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }
    
    /**
     * Getter for gumball count
     */
    public int getCount() {
        return count;
    }
    
    /**
     * State transition method - allows states to change the machine's state
     */
    public void setState(State state) {
        currentState = state;
    }
    
    /**
     * Getters for state objects - allows states to transition to other states
     */
    
    // TODO: Implement getters for all state objects
    // public State getSoldOutState() { return soldOutState; }
    // public State getNoQuarterState() { return noQuarterState; }
    // public State getHasQuarterState() { return hasQuarterState; }
    // public State getSoldState() { return soldState; }
    public State getSoldOutState() { return soldOutState; }
    public State getNoQuarterState() { return noQuarterState; }
    public State getHasQuarterState() { return hasQuarterState; }
    public State getSoldState() { return soldState; }
    
    /**
     * toString method to display the current state of the machine
     */
    @Override
    public String toString() {
        return "Gumball Machine\n" +
               "Count: " + count + " gumballs\n" +
               "Current state: " + currentState;
    }
}
