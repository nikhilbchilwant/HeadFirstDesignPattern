package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;
import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Cheese pizza that uses ingredient factory.
 * Instead of hardcoding ingredients, it gets them from the factory.
 */
public class CheesePizza extends Pizza {
    
    private PizzaIngredientFactory ingredientFactory;
    
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    public void prepare() {
        this.name = "Cheese Pizza";
        Dough dough = ingredientFactory.createDough();
        Sauce sauce = ingredientFactory.createSauce();
        Cheese cheese = ingredientFactory.createCheese();
        this.setDough(dough);
        this.setSauce(sauce);
        this.setCheese(cheese);
        super.prepare();
    }
}
