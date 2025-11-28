package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.exception.InvalidPizzaTypeException;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * New York style pizza store - creates NY-style pizzas.
 * This is a "Concrete Creator" in the Factory Method pattern.
 * 
 * TODO: Override createPizza() to return NY-style pizzas based on type
 * TODO: Use switch expression to create NYStyleCheesePizza, NYStylePepperoniPizza, etc.
 * TODO: Throw exception for unsupported types
 */
public class NYPizzaStore extends PizzaStoreBase {
    
    @Override
    protected Pizza createPizza(PizzaType type) throws InvalidPizzaTypeException {
        return switch (type) {
            case CHEESE -> new NYStyleCheesePizza();
            case PEPPERONI -> new NYStylePepperoniPizza();
            case CLAM -> new NYStyleClamPizza();
            case VEGGIE -> new NYStyleVeggiePizza();
            default -> throw new InvalidPizzaTypeException("Invalid pizza type: " + type);
        };
    }
}
