package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * New York style cheese pizza.
 * Characteristics: Thin crust, marinara sauce, grated reggiano cheese.
 * 
 * TODO: Implement constructor to set name, dough, sauce, toppings
 * TODO: NY pizzas have thin crust and are cut into slices (diagonal cut)
 */
public class NYStyleCheesePizza extends Pizza {
    
    public NYStyleCheesePizza() {
        // TODO: Set NY-style attributes
        // name = "NY Style Sauce and Cheese Pizza";
        // dough = "Thin Crust Dough";
        // sauce = "Marinara Sauce";
        // Add toppings: "Grated Reggiano Cheese"
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");            
    }
}
