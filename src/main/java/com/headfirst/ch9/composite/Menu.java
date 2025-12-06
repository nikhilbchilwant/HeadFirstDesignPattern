package com.headfirst.ch9.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Menu - Composite in the Composite Pattern.
 * Can contain MenuItems and other Menus (submenus).
 * 
 * TODO: Complete this class.
 * 
 * YOUR TASKS:
 * 1. Add fields: name, description, ArrayList<MenuComponent> menuComponents
 * 2. Implement constructor
 * 3. Override add(), remove(), getChild()
 * 4. Override getName(), getDescription()
 * 5. Override print() to recursively print menu and all children
 */
public class Menu extends MenuComponent {
    // TODO 1: Add fields
    ArrayList<MenuComponent> menuComponents;
    String name;
    String description;
    
    
    // TODO 2: Implement constructor
    public Menu(String name, String description) {
        // TODO: Initialize fields and create ArrayList
        this.name = name;
        this.description = description;
        menuComponents = new ArrayList<MenuComponent>();
    }   
    
    // TODO 3: Override composite operations
    @Override
    public void add(MenuComponent menuComponent) {
        // TODO: Add to menuComponents ArrayList
        menuComponents.add(menuComponent);
    }
    
    @Override
    public void remove(MenuComponent menuComponent) {
        // TODO: Remove from menuComponents ArrayList
        menuComponents.remove(menuComponent);
    }
    
    @Override
    public MenuComponent getChild(int i) {
        // TODO: Return child at index i
        return menuComponents.get(i);
    }
    
    // TODO 4: Override getName() and getDescription()
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
    
    // TODO 5: Override print() - RECURSIVE!
    @Override
    public void print() {
        // TODO: Print menu name and description
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");
        
        // TODO: Recursively print all children
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();  // Polymorphic call!
        }
    }
}
