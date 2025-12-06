package com.headfirst.ch9.iterator;

import java.util.ArrayList;

/**
 * PancakeHouseMenuIterator - iterates over ArrayList of MenuItems.
 * 
 * TODO: Complete this iterator for ArrayList-based storage.
 * 
 * YOUR TASKS:
 * 1. Add fields: ArrayList<MenuItem> items and int position
 * 2. Implement constructor to store ArrayList
 * 3. Implement hasNext() - check if more items exist
 * 4. Implement next() - return current item and increment position
 */
public class PancakeHouseMenuIterator implements Iterator {
    // TODO 1: Add fields
    // ArrayList<MenuItem> items;
    // int position = 0;
    
    
    // TODO 2: Implement constructor
    public PancakeHouseMenuIterator(ArrayList<MenuItem> items) {
        // TODO: Store the items ArrayList
    }
    
    // TODO 3: Implement hasNext()
    @Override
    public boolean hasNext() {
        // TODO: Check if position < items.size()
        return false;
    }
    
    // TODO 4: Implement next()
    @Override
    public MenuItem next() {
        // TODO: Get item at position, increment position, return item
        return null;
    }
}
