package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.exception.InvalidPizzaTypeException;
import com.headfirst.ch4.pizzastore.factorymethod.PizzaStoreBase;
import com.headfirst.ch4.pizzastore.model.Pizza;
import com.headfirst.ch4.pizzastore.model.PizzaType;

/**
 * Chicago Pizza Store using Abstract Factory.
 * This store creates pizzas and provides them with Chicago ingredient factory.
 */
public class ChicagoPizzaStoreWithFactory extends PizzaStoreBase {
    
    @Override
    protected Pizza createPizza(PizzaType type) throws InvalidPizzaTypeException {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        
        return switch (type) {
            case CHEESE -> new CheesePizza(ingredientFactory);
            case PEPPERONI -> new PepperoniPizza(ingredientFactory);
            case CLAM -> new ClamPizza(ingredientFactory);
            case VEGGIE -> new VeggiePizza(ingredientFactory);
            default -> throw new InvalidPizzaTypeException("Invalid pizza type: " + type);
        };
    }
}
