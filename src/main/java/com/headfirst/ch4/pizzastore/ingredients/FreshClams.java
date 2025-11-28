package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Fresh clams - used in NY style pizzas (they're near the ocean!).
 */
public record FreshClams() implements Clams {
    
    @Override
    public String getDescription() {
        return "Fresh Clams";
    }
}
