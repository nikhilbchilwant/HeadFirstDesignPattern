package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Concrete implementation of Pepperoni Pizza.
 * TODO: Initialize name and toppings in constructor
 */
public class PepperoniPizza extends Pizza {
    // TODO: Implement constructor
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }

}
