package com.headfirst.ch8.template;

/**
 * Abstract base class for caffeine beverages.
 * Demonstrates the Template Method Pattern.
 * 
 * TODO: Complete this class to implement the template method pattern.
 * 
 * PATTERN: Template Method Pattern
 * - Define algorithm skeleton in template method
 * - Template method is FINAL (cannot be overridden)
 * - Some steps are abstract (subclasses must implement)
 * - Some steps are concrete (shared implementation)
 * 
 * YOUR TASKS:
 * 1. Implement prepareRecipe() template method (FINAL)
 * 2. Declare abstract methods: brew(), addCondiments()
 * 3. Implement concrete methods: boilWater(), pourInCup()
 * 
 * ALGORITHM STEPS (in prepareRecipe):
 * 1. boilWater()
 * 2. brew()          <- varies by beverage
 * 3. pourInCup()
 * 4. addCondiments() <- varies by beverage
 */
public abstract class CaffeineBeverage {
    
    // TODO 1: Implement the template method
    // HINT: Make it final so subclasses can't override the algorithm
    // HINT: Call the 4 steps in order
    final void prepareRecipe() {
        // TODO: Implement the algorithm steps
        // Step 1: boilWater()
        // Step 2: brew()
        // Step 3: pourInCup()
        // Step 4: addCondiments()
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }
    
    // TODO 2: Declare abstract methods that vary by beverage
    abstract void brew();
    abstract void addCondiments();
    
    
    // TODO 3: Implement concrete methods (same for all beverages)
    void boilWater() {
        // TODO: Print "Boiling water"  
        System.out.println("Boiling water");
    }
    
    void pourInCup() {
        // TODO: Print "Pouring into cup"
        System.out.println("Pouring into cup");
    }
}
