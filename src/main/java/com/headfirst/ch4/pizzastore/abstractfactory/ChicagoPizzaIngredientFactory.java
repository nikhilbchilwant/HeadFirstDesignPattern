package com.headfirst.ch4.pizzastore.abstractfactory;

import com.headfirst.ch4.pizzastore.ingredients.*;

/**
 * Chicago Pizza Ingredient Factory - creates Chicago-style ingredient families.
 * Concrete factory creating: thick crust, plum tomato sauce, mozzarella cheese, frozen clams.
 * 
 * TODO: Implement PizzaIngredientFactory interface
 * TODO: Implement all create methods to return Chicago-style ingredients
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    
    // TODO: Implement createDough() - return new ThickCrustDough()
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }
    
    // TODO: Implement createSauce() - return new PlumTomatoSauce()
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }
    
    // TODO: Implement createCheese() - return new MozzarellaCheese()
    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }
    
    // TODO: Implement createClams() - return new FrozenClams()
    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
