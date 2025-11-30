package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Concrete implementation of Clam Pizza.
 * TODO: Initialize name and toppings in constructor
 */
public class ClamPizza extends Pizza {
    // TODO: Implement constructor
    public ClamPizza() {
        name = "Clam Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();
        toppings.add("Clams");
        toppings.add("Grated Parmesan Cheese");
    }

}
