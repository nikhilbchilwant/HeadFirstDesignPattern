package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;

/**
 * Enhanced Command interface with enterprise features.
 * Includes metadata support and proper error handling.
 */
public interface Command {
    /**
     * Executes the command.
     * @throws CommandExecutionException if execution fails
     */
    void execute() throws CommandExecutionException;
    
    /**
     * Undoes the command.
     * @throws CommandExecutionException if undo fails
     */
    void undo() throws CommandExecutionException;
    
    /**
     * Returns a human-readable description of the command.
     */
    String getDescription();
    
    /**
     * Returns the timestamp when this command was last executed.
     * Returns null if never executed.
     */
    LocalDateTime getLastExecutionTime();
}
