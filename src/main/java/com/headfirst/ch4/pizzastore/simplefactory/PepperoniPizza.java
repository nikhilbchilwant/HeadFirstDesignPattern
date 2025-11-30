package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Concrete implementation of Pepperoni Pizza.
 * TODO: Initialize name and toppings in constructor
 */
public class PepperoniPizza extends Pizza {
    // TODO: Implement constructor
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }

}
