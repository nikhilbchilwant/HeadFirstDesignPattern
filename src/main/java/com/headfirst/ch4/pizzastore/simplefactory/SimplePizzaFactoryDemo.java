package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Demo class to test Simple Factory pattern.
 * TODO: Implement main method to:
 *       1. Create SimplePizzaFactory
 *       2. Create PizzaStore with the factory
 *       3. Order various types of pizzas
 *       4. Print results
 */
public class SimplePizzaFactoryDemo {
    
    public static void main(String[] args) {
        // TODO: Implement demo
        SimplePizzaFactory simplePizzaFactory = new SimplePizzaFactory();
        PizzaStore pizzaStore = new PizzaStore(simplePizzaFactory);        
        pizzaStore.orderPizza(PizzaType.CHEESE);
        pizzaStore.orderPizza(PizzaType.PEPPERONI);
        pizzaStore.orderPizza(PizzaType.CLAM);
        pizzaStore.orderPizza(PizzaType.VEGGIE);
    }
}
