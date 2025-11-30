package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * New York style clam pizza.
 * TODO: Implement constructor with NY-style attributes and fresh clams
 */
public class NYStyleClamPizza extends Pizza {
    
    public NYStyleClamPizza() {
        // TODO: Set NY-style clam attributes
        name = "NY Style Clam Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();
        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams");
    }
}
