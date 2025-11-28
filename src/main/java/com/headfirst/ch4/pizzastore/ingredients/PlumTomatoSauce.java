package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Plum tomato sauce - used in Chicago style pizzas.
 */
public record PlumTomatoSauce() implements Sauce {
    
    @Override
    public String getDescription() {
        return "Plum Tomato Sauce";
    }
}
