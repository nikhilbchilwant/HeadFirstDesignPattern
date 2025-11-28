package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.exception.InvalidPizzaTypeException;
import com.headfirst.ch4.pizzastore.exception.PizzaCreationException;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Abstract pizza store implementing the Factory Method pattern.
 * This is the "Creator" in the Factory Method pattern.
 * 
 * The orderPizza() method is the template method - it's the same for all stores.
 * The createPizza() method is the factory method - subclasses override it to create region-specific pizzas.
 * 
 * TODO: Implement orderPizza() template method that:
 *       1. Calls createPizza() to get a pizza
 *       2. Calls prepare(), bake(), cut(), box() on the pizza
 *       3. Returns the pizza
 * TODO: Declare abstract createPizza() method that subclasses will implement
 */
public abstract class PizzaStoreBase {

    /**
     * Orders a pizza - this is the template method.
     * It's the same for all stores, but relies on the factory method createPizza().
     * @param type The type of pizza to order
     * @return The prepared pizza
     * @throws PizzaCreationException 
     */
    public Pizza orderPizza(PizzaType type) throws PizzaCreationException {
        Pizza pizza;
        try {
            pizza = createPizza(type);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            return pizza;
        } catch (InvalidPizzaTypeException e) {
            throw new PizzaCreationException(e.getMessage());
        }
    }
    
    /**
     * Factory method - subclasses implement this to create region-specific pizzas.
     * This is the "factory method" that gives the pattern its name.
     * @param type The type of pizza to create
     * @return A concrete Pizza instance specific to this store's region
     * @throws InvalidPizzaTypeException 
     */
    protected abstract Pizza createPizza(PizzaType type) throws InvalidPizzaTypeException;
}
