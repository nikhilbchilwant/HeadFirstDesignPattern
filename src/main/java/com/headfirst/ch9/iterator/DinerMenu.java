package com.headfirst.ch9.iterator;

/**
 * DinerMenu - uses array to store menu items.
 * 
 * TODO: Complete this menu class.
 * 
 * YOUR TASKS:
 * 1. Add fields: MenuItem[] menuItems, int numberOfItems
 * 2. Initialize array in constructor (size 6)
 * 3. Add menu items using addItem()
 * 4. Implement createIterator() to return DinerMenuIterator
 */
public class DinerMenu {
    static final int MAX_ITEMS = 6;
    // TODO 1: Add fields
    MenuItem[] menuItems;
    int numberOfItems = 0;
    
    
    public DinerMenu() {
        // TODO 2: Initialize menuItems array with MAX_ITEMS size
        menuItems = new MenuItem[MAX_ITEMS];
        
        // TODO 3: Add menu items
        addItem("Vegetarian BLT",
            "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT",
            "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day",
            "Soup of the day, with a side of potato salad", false, 3.29);
        addItem("Hotdog",
            "A hot dog, with sauerkraut, relish, onions, topped with cheese",
            false, 3.05);
    }
    
    public void addItem(String name, String description, boolean vegetarian, double price) {
        // TODO: Create MenuItem and add to array
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full!");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }
    
    // TODO 4: Implement createIterator()
    public Iterator createIterator() {
        // TODO: Return new DinerMenuIterator(menuItems)
        return new DinerMenuIterator(menuItems);
    }
}
