package com.headfirst.ch6.command.enterprise;

/**
 * Custom exception for command execution failures.
 * Provides better error handling than generic exceptions.
 */
public class CommandExecutionException extends Exception {
    
    public CommandExecutionException(String message) {
        super(message);
    }
    
    public CommandExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
