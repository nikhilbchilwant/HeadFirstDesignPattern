package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Concrete implementation of Cheese Pizza.
 * TODO: Initialize name and toppings in constructor
 */
public class CheesePizza extends Pizza {
    // TODO: Implement constructor
    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }

}
