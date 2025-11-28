package com.headfirst.ch4.pizzastore.ingredients;

/**
 * Sealed interface for dough ingredients.
 * Uses Java 17 sealed interfaces for type safety - only specific dough types are permitted.
 */
public sealed interface Dough permits ThinCrustDough, ThickCrustDough {
    String getDescription();
}
