package com.headfirst.ch10;

/**
 * Test driver to test the Gumball Machine implementation
 * 
 * This will test various scenarios:
 * 1. Normal operation (insert quarter, turn crank, get gumball)
 * 2. Ejecting a quarter
 * 3. Running out of gumballs
 * 4. Invalid operations (turning crank without quarter, etc.)
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        // TODO: Create a GumballMachine with 5 gumballs    
        GumballMachine gumballMachine = new GumballMachine(5);
        
        // TODO: Print the initial state
        System.out.println(gumballMachine);
        
        // TODO: Test normal operation
        // - Insert quarter
        // - Turn crank
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        
        // TODO: Test ejecting a quarter
        // - Insert quarter
        // - Eject quarter
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        
        // TODO: Test invalid operations
        // - Turn crank without inserting quarter
        // - Insert quarter twice
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        
        // TODO: Use up all gumballs and test sold out state
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        
        // TODO: Print final state
        System.out.println(gumballMachine);
        
        System.out.println("\n=== Gumball Machine Test Complete ===");
    }
}
