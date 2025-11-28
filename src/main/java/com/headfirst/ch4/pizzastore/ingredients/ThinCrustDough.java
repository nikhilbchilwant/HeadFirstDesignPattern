package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Thin crust dough - used in NY style pizzas.
 * Immutable ingredient implementation using Java 17 record.
 */
public record ThinCrustDough() implements Dough {
    
    @Override
    public String getDescription() {
        return "Thin Crust Dough";
    }
}
