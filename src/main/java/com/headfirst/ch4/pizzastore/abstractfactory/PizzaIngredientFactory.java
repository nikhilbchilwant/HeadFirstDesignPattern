package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Abstract Factory interface for creating families of pizza ingredients.
 * Each regional factory will create compatible ingredient families.
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Clams createClams();
}
