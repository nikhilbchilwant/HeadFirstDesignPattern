package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;
import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Pepperoni pizza that uses ingredient factory.
 */
public class PepperoniPizza extends Pizza {
    
    private PizzaIngredientFactory ingredientFactory;
    
    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    public void prepare() {
        this.name = "Pepperoni Pizza";
        Dough dough = ingredientFactory.createDough();
        Sauce sauce = ingredientFactory.createSauce();
        Cheese cheese = ingredientFactory.createCheese();
        this.setDough(dough);
        this.setSauce(sauce);
        this.setCheese(cheese);
        super.prepare();
    }
}
