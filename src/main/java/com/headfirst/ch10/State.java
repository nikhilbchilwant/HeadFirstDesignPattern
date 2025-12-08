package com.headfirst.ch10;

/**
 * State interface - defines all possible actions that can be performed
 * on the gumball machine in any state.
 * 
 * TODO: Define methods for:
 * - insertQuarter()
 * - ejectQuarter()
 * - turnCrank()
 * - dispense()
 * 
 * Each concrete state will implement these methods differently.
 */
public interface State {
    // TODO: Add method declarations here
    // Hint: Each method should handle what happens when that action
    // is performed in this particular state
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense(); 
}
