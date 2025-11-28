package com.headfirst.ch4.pizzastore.simplefactory;

import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Simple Factory for creating pizzas.
 * This encapsulates pizza creation logic in one place.
 * TODO: Implement createPizza(PizzaType type) method
 * TODO: Use switch expression (Java 17) to create appropriate pizza
 * TODO: Throw exception for invalid type
 */
public class SimplePizzaFactory {
    
    /**
     * Creates a pizza based on the given type.
     * @param type The type of pizza to create
     * @return A concrete Pizza instance
     */
    public Pizza createPizza(PizzaType type) {
        // Using Java 17 enhanced switch expression (can be refactored to use arrow syntax)
        switch (type) {
            case CHEESE:
                return new CheesePizza();
            case PEPPERONI:
                return new PepperoniPizza();
            case CLAM:
                return new ClamPizza();
            case VEGGIE:
                return new VeggiePizza();
            default:
                throw new IllegalArgumentException("Invalid pizza type: " + type);
        }
    }
}
