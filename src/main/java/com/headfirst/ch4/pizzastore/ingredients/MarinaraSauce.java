package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Marinara sauce - used in NY style pizzas.
 */
public record MarinaraSauce() implements Sauce {
    
    @Override
    public String getDescription() {
        return "Marinara Sauce";
    }
}
