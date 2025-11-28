package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Sealed interface for cheese ingredients.
 */
public sealed interface Cheese permits ReggianoCheese, MozzarellaCheese {
    String getDescription();
}
