package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Chicago style clam pizza.
 * TODO: Implement constructor with Chicago-style attributes and frozen clams (Chicago doesn't have fresh!)
 * TODO: Override cut() method for square slices
 */
public class ChicagoStyleClamPizza extends Pizza {
    
    public ChicagoStyleClamPizza() {
        // TODO: Set Chicago-style clam attributes
        // Hint: Chicago uses "Frozen Clams" not fresh!
        name = "Chicago Style Clam Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Frozen Clams");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
