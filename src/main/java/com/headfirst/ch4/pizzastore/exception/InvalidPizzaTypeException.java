package com.headfirst.ch4.pizzastore.exception;

/**
 * Exception thrown when an invalid pizza type is requested.
 * TODO: Extend PizzaCreationException
 * TODO: Add constructors for message
 */
public class InvalidPizzaTypeException extends PizzaCreationException {

    public InvalidPizzaTypeException(String message) {
        super(message);
    }
}
