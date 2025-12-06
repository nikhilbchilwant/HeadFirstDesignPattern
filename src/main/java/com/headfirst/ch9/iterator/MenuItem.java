package com.headfirst.ch9.iterator;

/**
 * MenuItem - represents a single item on the menu.
 * This is provided for you.
 */
public class MenuItem {
    private String name;
    private String description;
    private boolean vegetarian;
    private double price;
    
    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isVegetarian() {
        return vegetarian;
    }
}
