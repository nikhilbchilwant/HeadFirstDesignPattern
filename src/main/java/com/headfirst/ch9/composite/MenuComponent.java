package com.headfirst.ch9.composite;

/**
 * MenuComponent - Abstract base class for both Menu and MenuItem.
 * This is the Component in the Composite Pattern.
 * 
 * TODO: Complete this class.
 * 
 * PATTERN: Composite Pattern
 * - Provides common interface for leaf (MenuItem) and composite (Menu)
 * - Default implementations throw UnsupportedOperationException
 * - Subclasses override only methods that make sense for them
 * 
 * YOUR TASKS:
 * 1. Add methods for MenuItem operations (getName, getDescription, getPrice, isVegetarian)
 * 2. Add methods for Menu operations (add, remove, getChild)
 * 3. Add print() method for displaying
 * 4. All methods should have default implementations that throw UnsupportedOperationException
 */
public abstract class MenuComponent {
    
    // TODO 1: Add MenuItem operation methods with default implementations
    public String getName() {
        throw new UnsupportedOperationException();
    }
    
    public String getDescription() {
        throw new UnsupportedOperationException();
    }
    
    public double getPrice() {
        throw new UnsupportedOperationException();
    }
    
    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }
    
    // TODO 2: Add Menu operation methods (composite operations)
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    
    // TODO 3: Add print() method
    public void print() {
        throw new UnsupportedOperationException();
    }
}
