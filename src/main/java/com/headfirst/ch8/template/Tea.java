package com.headfirst.ch8.template;

/**
 * Concrete implementation for Tea.
 * 
 * TODO: Complete this class to make tea using the template method.
 * 
 * YOUR TASKS:
 * 1. Extend CaffeineBeverage
 * 2. Implement brew() - print "Steeping the tea"
 * 3. Implement addCondiments() - print "Adding Lemon"
 */
public class Tea extends CaffeineBeverage {
    // TODO 1: Extend CaffeineBeverage
    
    // TODO 2: Implement brew() method
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }
    
        
    // TODO 3: Implement addCondiments() method
    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }
}
