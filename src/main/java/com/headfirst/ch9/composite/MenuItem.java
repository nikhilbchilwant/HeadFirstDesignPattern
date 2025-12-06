package com.headfirst.ch9.composite;

/**
 * MenuItem - Leaf in the Composite Pattern.
 * Represents individual menu items (cannot have children).
 * 
 * TODO: Complete this class.
 * 
 * YOUR TASKS:
 * 1. Add fields: name, description, vegetarian, price
 * 2. Implement constructor
 * 3. Override getName(), getDescription(), getPrice(), isVegetarian()
 * 4. Override print() to display menu item
 */
public class MenuItem extends MenuComponent {
    // TODO 1: Add fields
    String name;
    String description;
    boolean vegetarian;
    double price;
    
    
    // TODO 2: Implement constructor
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        // TODO: Initialize all fields
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    
    // TODO 3: Override getter methods
    @Override
    public String getName() {
        // TODO: Return name
        return name;
    }
    
    @Override
    public String getDescription() {
        // TODO: Return description
        return description;
    }
    
    @Override
    public double getPrice() {
        // TODO: Return price
        return price;
    }
    
    @Override
    public boolean isVegetarian() {
        // TODO: Return vegetarian
        return vegetarian;
    }
    
    // TODO 4: Override print()
    @Override
    public void print() {
        // TODO: Print menu item details
        // Format: "  " + getName() + (isVegetarian() ? "(v)" : "") + ", " + getPrice() + " -- " + getDescription()
        System.out.println("  " + getName() + (isVegetarian() ? "(v)" : "") + ", " + getPrice() + " -- " + getDescription());
    }
}
