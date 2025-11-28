package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;
import com.headfirst.ch4.pizzastore.model.Pizza;

/**
 * Clam pizza that uses ingredient factory.
 */
public class ClamPizza extends Pizza {

    private PizzaIngredientFactory pizzaIngredientFactory;
    
    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }
        
    @Override
    public void prepare() {
        this.name = "Clam Pizza";
        Dough dough = pizzaIngredientFactory.createDough();
        Sauce sauce = pizzaIngredientFactory.createSauce();
        Cheese cheese = pizzaIngredientFactory.createCheese();
        Clams clams = pizzaIngredientFactory.createClams();
        this.setDough(dough);
        this.setSauce(sauce);
        this.setCheese(cheese);
        this.setClams(clams);
        super.prepare();
    }
}
