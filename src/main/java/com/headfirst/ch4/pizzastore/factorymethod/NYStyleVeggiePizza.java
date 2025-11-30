package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * New York style veggie pizza.
 * TODO: Implement constructor with NY-style attributes and veggie toppings
 */
public class NYStyleVeggiePizza extends Pizza {
    
    public NYStyleVeggiePizza() {
        // TODO: Set NY-style veggie attributes
        name = "NY Style Veggie Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();
        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onions");
        toppings.add("Mushrooms");
        toppings.add("Red Peppers");
    }
}
