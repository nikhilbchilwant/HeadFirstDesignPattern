package com.headfirst.ch7.adapter.oneway;

/**
 * Test drive for the Adapter Pattern.
 * Shows how TurkeyAdapter makes a Turkey work where a Duck is expected.
 */
public class DuckTestDrive {
    
    public static void main(String[] args) {
        // Create a real duck
        Duck duck = new MallardDuck();
        
        // Create a turkey
        Turkey turkey = new WildTurkey();
        
        // Wrap turkey in adapter to make it look like a duck
        Duck turkeyAdapter = new TurkeyAdapter(turkey);
        
        System.out.println("The Turkey says...");
        turkey.gobble();
        turkey.fly();
        
        System.out.println("\nThe Duck says...");
        testDuck(duck);
        
        System.out.println("\nThe TurkeyAdapter says...");
        testDuck(turkeyAdapter);  // Passing turkey as a duck!
    }
    
    /**
     * This method expects a Duck.
     * Thanks to the adapter, we can pass a Turkey!
     */
    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
