package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Thick crust dough - used in Chicago style pizzas.
 * Immutable ingredient implementation using Java 17 record.
 */
public record ThickCrustDough() implements Dough {
    
    @Override
    public String getDescription() {
        return "Thick Crust Dough";
    }
}
