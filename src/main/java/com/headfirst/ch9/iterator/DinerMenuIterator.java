package com.headfirst.ch9.iterator;

/**
 * DinerMenuIterator - iterates over an array of MenuItems.
 * 
 * TODO: Complete this iterator for array-based storage.
 * 
 * YOUR TASKS:
 * 1. Add fields: MenuItem[] items and int position
 * 2. Implement constructor to store items array
 * 3. Implement hasNext() - check if more items exist
 * 4. Implement next() - return current item and increment position
 */
public class DinerMenuIterator implements Iterator {
    // TODO 1: Add fields
    MenuItem[] items;
    int position = 0;
    
    
    // TODO 2: Implement constructor
    public DinerMenuIterator(MenuItem[] items) {
        // TODO: Store the items array
        this.items = items;
    }
    
    // TODO 3: Implement hasNext()
    @Override
    public boolean hasNext() {
        // TODO: Check if position < items.length AND items[position] != null
        return (position < items.length && items[position] != null);
    }
    
    // TODO 4: Implement next()
    @Override
    public MenuItem next() {
        // TODO: Get current item, increment position, return item
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }
}
