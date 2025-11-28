package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.exception.PizzaCreationException;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Test drive for the Factory Method pattern.
 * Demonstrates how different stores create different regional pizzas.
 */
public class PizzaTestDrive {
    
    public static void main(String[] args) throws PizzaCreationException {
        // Create regional stores
        PizzaStoreBase nyStore = new NYPizzaStore();
        PizzaStoreBase chicagoStore = new ChicagoPizzaStore();
        
        // Ethan orders from NY
        Pizza pizza = nyStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");
        
        // Joel orders from Chicago
        pizza = chicagoStore.orderPizza(PizzaType.CHEESE);
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
        
        // More orders to show the pattern
        pizza = nyStore.orderPizza(PizzaType.CLAM);
        System.out.println("Maria ordered a " + pizza.getName() + "\n");
        
        pizza = chicagoStore.orderPizza(PizzaType.PEPPERONI);
        System.out.println("Alex ordered a " + pizza.getName() + "\n");
        
        pizza = nyStore.orderPizza(PizzaType.VEGGIE);
        System.out.println("Sarah ordered a " + pizza.getName() + "\n");
    }
}
