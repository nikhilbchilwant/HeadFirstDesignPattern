package com.headfirst.ch1;



/**
 * Demonstrates the Modern Strategy Pattern using Java 8+ Functional Interfaces.
 * 
 * In a professional context, if a Strategy interface has a single abstract method (SAM),
 * it is a Functional Interface. This allows us to inject behavior using Lambdas
 * or Method References without creating verbose concrete classes.
 */
public class FunctionalDuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        
        System.out.println("--- Scenario 1: Default Behavior ---");
        mallard.performFly();
        mallard.performQuack();

        // Use Case: Injecting ad-hoc behavior without creating a new class file
        // Useful for testing, one-off variations, or dynamic configuration.
        System.out.println("\n--- Scenario 2: Dynamic Behavior via Lambdas ---");
        
        mallard.setFlyBehavior(() -> System.out.println("🚀 Reviewing flight logs... Taking off with Lambda Power!"));
        mallard.setQuackBehavior(() -> System.out.println("🤖 Roboduck: Quack initialized."));
        
        mallard.performFly();
        mallard.performQuack();
        
        // Use Case: Reusing existing methods that match the signature
        System.out.println("\n--- Scenario 3: Method References ---");
        mallard.setFlyBehavior(FunctionalDuckSimulator::executeEmergencyTakeoff);
        mallard.performFly();
    }
    
    /**
     * A standalone method that matches the FlyBehavior signature (void -> void).
     * This can be reused as a strategy implementation.
     */
    private static void executeEmergencyTakeoff() {
        System.out.println("🚨 EMERGENCY: Engaging afterburners! Maximum thrust!");
    }
}

