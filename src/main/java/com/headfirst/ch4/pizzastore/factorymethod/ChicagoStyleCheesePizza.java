package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Chicago style deep-dish cheese pizza.
 * Characteristics: Extra thick crust, plum tomato sauce, mozzarella cheese.
 * Chicago pizzas are cut into squares, not slices!
 * 
 * TODO: Implement constructor to set name, dough, sauce, toppings
 * TODO: Override cut() method to cut into squares instead of slices
 */
public class ChicagoStyleCheesePizza extends Pizza {
    
    public ChicagoStyleCheesePizza() {
        // TODO: Set Chicago-style attributes
        // name = "Chicago Style Deep Dish Cheese Pizza";
        // dough = "Extra Thick Crust Dough";
        // sauce = "Plum Tomato Sauce";
        // Add toppings: "Shredded Mozzarella Cheese"
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = new ThickCrustDough();
        sauce = new PlumTomatoSauce();
        toppings.add("Shredded Mozzarella Cheese");
    }
    
    @Override
    public void cut() {
        // TODO: Override to cut into squares
        System.out.println("Cutting the pizza into square slices");
    }
}
