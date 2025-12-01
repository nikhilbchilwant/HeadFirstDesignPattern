package com.headfirst.ch7.adapter.oneway;

/**
 * TWO-WAY ADAPTER - Makes a Duck look like a Turkey!
 * This is the reverse of TurkeyAdapter.
 * 
 * TODO: Complete this class to make ducks work where turkeys are expected.
 * 
 * PATTERN: Adapter Pattern (reverse direction)
 * - Implements the TARGET interface (Turkey)
 * - Wraps the ADAPTEE (Duck)
 * - Translates method calls
 * 
 * YOUR TASKS:
 * 1. Add a private Duck field
 * 2. Complete the constructor to store the duck
 * 3. Implement gobble() - call duck.quack()
 * 4. Implement fly() - ducks fly longer, so just call duck.fly() once
 * 
 * CHALLENGE: Can you use java.util.Random to make the duck only fly sometimes?
 */
public class DuckAdapter implements Turkey {
    
    // TODO 1: Add a private Duck field called 'duck'
    
    
    // TODO 2: Complete the constructor
    public DuckAdapter(Duck duck) {
        // TODO: Store the duck in the field
    }
    
    // TODO 3: Implement gobble() - delegate to duck.quack()
    @Override
    public void gobble() {
        // TODO: Make the duck quack when turkey gobbles
    }
    
    // TODO 4: Implement fly()
    // HINT: Ducks fly longer distances, so just call duck.fly() once
    // BONUS: Use Random to make it fly only sometimes (ducks are smarter than turkeys!)
    @Override
    public void fly() {
        // TODO: Make the duck fly
        // BONUS TODO: if (rand.nextInt(5) == 0) duck.fly();
    }
}
