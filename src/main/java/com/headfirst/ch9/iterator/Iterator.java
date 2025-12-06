package com.headfirst.ch9.iterator;

/**
 * Iterator interface - provides uniform way to traverse collections.
 * 
 * TODO: Complete this interface.
 * 
 * YOUR TASKS:
 * 1. Declare hasNext() method - returns boolean
 * 2. Declare next() method - returns MenuItem
 */
public interface Iterator {
    // TODO 1: Declare hasNext() method
    boolean hasNext();
    
    // TODO 2: Declare next() method
    MenuItem next();
}
