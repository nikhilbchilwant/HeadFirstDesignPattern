package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * NY Pizza Ingredient Factory - creates NY-style ingredient families.
 * Concrete factory creating: thin crust, marinara sauce, reggiano cheese, fresh clams.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }
    
    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }
    
    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
    
    @Override
    public Clams createClams() {
        return new FreshClams();
    }
    
}
