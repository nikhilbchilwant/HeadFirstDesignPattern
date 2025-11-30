package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Chicago style veggie pizza.
 * TODO: Implement constructor with Chicago-style attributes and veggie toppings
 * TODO: Override cut() method for square slices
 */
public class ChicagoStyleVeggiePizza extends Pizza {
    
    public ChicagoStyleVeggiePizza() {
        // TODO: Set Chicago-style veggie attributes
        name = "Chicago Style Veggie Pizza";
        dough = new ThickCrustDough();
        sauce = new PlumTomatoSauce();
        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
