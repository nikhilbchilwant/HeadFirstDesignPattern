package com.headfirst.ch3.starbuzz;

public class HouseBlend implements Beverage {
    private String description;

    public HouseBlend() {
        description = "House Blend Coffee";
    }
 
    public String getDescription() {
        return description;
    }

    public double cost() {
        return 0.89;
    }
}
