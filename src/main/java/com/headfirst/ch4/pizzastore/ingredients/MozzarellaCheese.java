package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Mozzarella cheese - used in Chicago style pizzas.
 */
public record MozzarellaCheese() implements Cheese {
    
    @Override
    public String getDescription() {
        return "Mozzarella Cheese";
    }
}
