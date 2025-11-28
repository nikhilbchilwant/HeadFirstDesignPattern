package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Frozen clams - used in Chicago style pizzas (too far from ocean!).
 */
public record FrozenClams() implements Clams {
    
    @Override
    public String getDescription() {
        return "Frozen Clams";
    }
}
