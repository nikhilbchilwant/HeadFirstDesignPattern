package com.headfirst.ch9.iterator;

import java.util.ArrayList;

/**
 * PancakeHouseMenu - uses ArrayList to store menu items.
 * 
 * TODO: Complete this menu class.
 * 
 * YOUR TASKS:
 * 1. Add field: ArrayList<MenuItem> menuItems
 * 2. Initialize ArrayList in constructor
 * 3. Add menu items using addItem()
 * 4. Implement createIterator() to return PancakeHouseMenuIterator
 */
public class PancakeHouseMenu {
    // TODO 1: Add field
    ArrayList<MenuItem> menuItems;
    
    
    public PancakeHouseMenu() {
        // TODO 2: Initialize menuItems ArrayList
        menuItems = new ArrayList<MenuItem>();
        
        
        // TODO 3: Add menu items
        addItem("K&B's Pancake Breakfast",
            "Pancakes with scrambled eggs, and toast", true, 2.99);
        addItem("Regular Pancake Breakfast",
            "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("Blueberry Pancakes",
            "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles",
            "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        // TODO: Create MenuItem and add to ArrayList
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
    
    // TODO 4: Implement createIterator()
    public Iterator createIterator() {
        // TODO: Return new PancakeHouseMenuIterator(menuItems)
        return new PancakeHouseMenuIterator(menuItems);
    }
}
