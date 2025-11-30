package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Concrete implementation of Veggie Pizza.
 * TODO: Initialize name and toppings in constructor
 */
public class VeggiePizza extends Pizza {
    // TODO: Implement constructor
    public VeggiePizza() {
        name = "Veggie Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan");
        toppings.add("Diced onion");
        toppings.add("Sliced mushrooms");
        toppings.add("Red pepper");
        toppings.add("Black olives");
    }

}
