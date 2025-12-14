package com.headfirst.appendix.prototype;

// Prototype Interface
public interface Monster extends Cloneable {
    // We can use Java's Cloneable, or a custom method like 'copy()'
    // Using a custom method is often cleaner than dealing with CloneNotSupportedException
    Monster copy();
    
    void spitPoison();
}
