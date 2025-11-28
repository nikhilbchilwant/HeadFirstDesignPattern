package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Pizza Store that uses SimplePizzaFactory to create pizzas.
 * This is the client of the Simple Factory pattern.
 * TODO: Add SimplePizzaFactory field
 * TODO: Implement constructor that accepts the factory
 * TODO: Implement orderPizza(PizzaType) method that:
 *       1. Uses factory to create pizza
 *       2. Calls prepare(), bake(), cut(), box() on the pizza
 *       3. Returns the pizza
 */
public class PizzaStore {
    
    // TODO: Add factory field
    private SimplePizzaFactory simplePizzaFactory;
    
    // TODO: Implement constructor
    public PizzaStore(SimplePizzaFactory simplePizzaFactory) {
        this.simplePizzaFactory = simplePizzaFactory;
    }
    
    /**
     * Orders a pizza of the given type.
     * @param type The type of pizza to order
     * @return The prepared pizza
     */
    public Pizza orderPizza(PizzaType type) {
        // TODO: Implement order pizza workflow
        Pizza pizza = simplePizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
