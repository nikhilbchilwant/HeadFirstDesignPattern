package com.headfirst.ch9.composite;

/**
 * Waitress - Client for Composite Pattern.
 * Works with MenuComponent (treats leaf and composite uniformly).
 * 
 * TODO: Complete this class.
 * 
 * YOUR TASKS:
 * 1. Add field: MenuComponent allMenus
 * 2. Implement constructor
 * 3. Implement printMenu() - just call allMenus.print()!
 */
public class Waitress {
    // TODO 1: Add field
    MenuComponent allMenus;    
    
    // TODO 2: Implement constructor
    public Waitress(MenuComponent allMenus) {
        // TODO: Store allMenus
        this.allMenus = allMenus;
    }
    
    // TODO 3: Implement printMenu()
    public void printMenu() {
        // TODO: Call allMenus.print()
        allMenus.print();
    }
}
