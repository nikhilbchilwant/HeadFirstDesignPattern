package com.headfirst.ch4.pizzastore.exception;

/**
 * Custom exception for pizza creation errors.
 */
public class PizzaCreationException extends Exception {
    
    public PizzaCreationException(String message) {
        super(message);
    }
}
