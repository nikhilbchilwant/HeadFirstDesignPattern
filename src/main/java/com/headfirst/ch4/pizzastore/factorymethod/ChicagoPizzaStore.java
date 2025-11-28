package com.headfirst.ch4.pizzastore.factorymethod;

import com.headfirst.ch4.pizzastore.exception.InvalidPizzaTypeException;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Chicago style pizza store - creates Chicago deep-dish pizzas.
 * This is a "Concrete Creator" in the Factory Method pattern.
 */
public class ChicagoPizzaStore extends PizzaStoreBase {
    
    @Override
    protected Pizza createPizza(PizzaType type) throws InvalidPizzaTypeException {
        return switch (type) {
            case CHEESE -> new ChicagoStyleCheesePizza();
            case PEPPERONI -> new ChicagoStylePepperoniPizza();
            case CLAM -> new ChicagoStyleClamPizza();
            case VEGGIE -> new ChicagoStyleVeggiePizza();
            default -> throw new InvalidPizzaTypeException("Invalid pizza type: " + type);
        };
    }
}
