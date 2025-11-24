package com.headfirst.ch3.starbuzz;

public class Espresso implements Beverage {

    private String description;
    
    public Espresso() {
        description = "Espresso";
    }

    public String getDescription() {
        return description;
    }
  
    public double cost() {
        return 1.99;
    }
}
