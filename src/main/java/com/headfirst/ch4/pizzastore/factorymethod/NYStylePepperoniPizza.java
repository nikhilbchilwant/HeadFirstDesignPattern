package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * New York style pepperoni pizza.
 * TODO: Implement constructor with NY-style attributes and pepperoni toppings
 */
public class NYStylePepperoniPizza extends Pizza {
    
    public NYStylePepperoniPizza() {
        // TODO: Set NY-style pepperoni attributes
        name = "NY Style Pepperoni Pizza";
        dough = new ThinCrustDough();
        sauce = new MarinaraSauce();
        toppings.add("Grated Reggiano Cheese");
        toppings.add("Sliced Pepperoni");
    }
}
