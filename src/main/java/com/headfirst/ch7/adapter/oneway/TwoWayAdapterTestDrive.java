package com.headfirst.ch7.adapter;

/**
 * Test drive for TWO-WAY adapters.
 * Shows both TurkeyAdapter (Turkey→Duck) and DuckAdapter (Duck→Turkey).
 */
public class TwoWayAdapterTestDrive {
    
    public static void main(String[] args) {
        // Create original objects
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        
        // Create adapters in both directions
        Duck turkeyAdapter = new TurkeyAdapter(turkey);  // Turkey acting as Duck
        Turkey duckAdapter = new DuckAdapter(duck);      // Duck acting as Turkey
        
        System.out.println("=== Original Duck ===");
        testDuck(duck);
        
        System.out.println("\n=== Original Turkey ===");
        testTurkey(turkey);
        
        System.out.println("\n=== Turkey disguised as Duck (TurkeyAdapter) ===");
        testDuck(turkeyAdapter);
        
        System.out.println("\n=== Duck disguised as Turkey (DuckAdapter) ===");
        testTurkey(duckAdapter);
        
        System.out.println("\n=== Two-way adaptation complete! ===");
    }
    
    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }
    
    static void testTurkey(Turkey turkey) {
        turkey.gobble();
        turkey.fly();
    }
}
