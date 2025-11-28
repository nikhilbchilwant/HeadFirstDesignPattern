package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * New York style veggie pizza.
 * TODO: Implement constructor with NY-style attributes and veggie toppings
 */
public class NYStyleVeggiePizza extends Pizza {
    
    public NYStyleVeggiePizza() {
        // TODO: Set NY-style veggie attributes
        name = "NY Style Veggie Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onions");
        toppings.add("Mushrooms");
        toppings.add("Red Peppers");
    }
}
