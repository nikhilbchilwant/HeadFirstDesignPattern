package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Sealed interface for clam ingredients.
 */
public sealed interface Clams permits FreshClams, FrozenClams {
    String getDescription();
}
