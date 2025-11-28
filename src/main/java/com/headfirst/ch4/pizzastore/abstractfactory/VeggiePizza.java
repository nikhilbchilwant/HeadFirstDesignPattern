package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;
import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Veggie pizza that uses ingredient factory.
 */
public class VeggiePizza extends Pizza {
    
    private PizzaIngredientFactory ingredientFactory;
    
    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    
    @Override
    public void prepare() {
        this.name = "Veggie Pizza";
        Dough dough = ingredientFactory.createDough();
        Sauce sauce = ingredientFactory.createSauce();
        Cheese cheese = ingredientFactory.createCheese();
        this.setDough(dough);
        this.setSauce(sauce);
        this.setCheese(cheese);
        super.prepare();
    }
}
