package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.exception.InvalidPizzaTypeException;
import com.headfirst.ch4.pizzastore.factorymethod.PizzaStoreBase;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * NY Pizza Store using Abstract Factory.
 * This store creates pizzas and provides them with NY ingredient factory.
 */
public class NYPizzaStoreWithFactory extends PizzaStoreBase {
    
    @Override
    protected Pizza createPizza(PizzaType type) throws InvalidPizzaTypeException {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        
        return switch (type) {
            case CHEESE -> new CheesePizza(ingredientFactory);
            case PEPPERONI -> new PepperoniPizza(ingredientFactory);
            case CLAM -> new ClamPizza(ingredientFactory);
            case VEGGIE -> new VeggiePizza(ingredientFactory);
            default -> throw new InvalidPizzaTypeException("Invalid pizza type: " + type);
        };
    }
}
