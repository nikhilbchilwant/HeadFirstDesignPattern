package com.headfirst.ch3.starbuzz;

public interface Beverage {
    // Thread Safety Note: This string is not volatile. If shared across threads,
    // changes might not be immediately visible to other threads.

    public String getDescription();

    public double cost();
}
