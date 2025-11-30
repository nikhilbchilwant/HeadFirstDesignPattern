package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Chicago style pepperoni pizza.
 * TODO: Implement constructor with Chicago-style attributes and pepperoni
 * TODO: Override cut() method for square slices
 */
public class ChicagoStylePepperoniPizza extends Pizza {
    
    public ChicagoStylePepperoniPizza() {
        // TODO: Set Chicago-style pepperoni attributes
        name = "Chicago Style Pepperoni Pizza";
        dough = new ThickCrustDough();
        sauce = new PlumTomatoSauce();
        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Sliced Pepperoni");
    }
    
    @Override
    public void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
