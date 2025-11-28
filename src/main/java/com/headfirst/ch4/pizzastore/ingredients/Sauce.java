package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Sealed interface for sauce ingredients.
 */
public sealed interface Sauce permits MarinaraSauce,PlumTomatoSauce {
    String getDescription();
}
