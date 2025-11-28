package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Reggiano cheese - used in NY style pizzas.
 */
public record ReggianoCheese() implements Cheese {
    
    @Override
    public String getDescription() {
        return "Reggiano Cheese";
    }
}
