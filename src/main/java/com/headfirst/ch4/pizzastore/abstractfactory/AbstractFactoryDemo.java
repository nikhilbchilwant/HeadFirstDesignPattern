package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.exception.PizzaCreationException;
import com.headfirst.ch4.pizzastore.factorymethod.PizzaStoreBase;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Demo for Abstract Factory pattern.
 * Shows how ingredient families are created together.
 * 
 * TODO: Implement main method to:
 *       1. Create NY and Chicago stores with factory
 *       2. Order pizzas and observe ingredient composition
 *       3. Compare how different factories create different ingredient families
 */
public class AbstractFactoryDemo {
    
    public static void main(String[] args) throws PizzaCreationException {
        // TODO: Create stores
        PizzaStoreBase nyStore = new NYPizzaStoreWithFactory();
        PizzaStoreBase chicagoStore = new ChicagoPizzaStoreWithFactory();
        
        // TODO: Order pizzas and print results
        // Show how the same pizza type gets different ingredients based on factory
        Pizza pizza = nyStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        
        pizza = chicagoStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
