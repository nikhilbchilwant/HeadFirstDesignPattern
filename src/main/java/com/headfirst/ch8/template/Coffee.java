package com.headfirst.ch8.template;

/**
 * Concrete implementation for Coffee.
 * 
 * TODO: Complete this class to make coffee using the template method.
 * 
 * YOUR TASKS:
 * 1. Extend CaffeineBeverage
 * 2. Implement brew() - print "Dripping Coffee through filter"
 * 3. Implement addCondiments() - print "Adding Sugar and Milk"
 */
public class Coffee extends CaffeineBeverage{
    // TODO 1: Extend CaffeineBeverage
    
    // TODO 2: Implement brew() method
    @Override
    void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    
    // TODO 3: Implement addCondiments() method
    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
