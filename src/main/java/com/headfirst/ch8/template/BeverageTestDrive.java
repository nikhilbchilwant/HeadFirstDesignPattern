package com.headfirst.ch8.template;

/**
 * Test drive for Template Method Pattern.
 * Shows how the template method enforces the algorithm structure.
 */
public class BeverageTestDrive {
    
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        
        System.out.println("Making tea...");
        tea.prepareRecipe();
        
        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();
    }
}
