package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;

/**
 * Null Object pattern implementation with logging.
 * Used as default command to eliminate null checks.
 */
public class NoCommand implements Command {
    
    @Override
    public void execute() {
        System.out.println("[LOG] NoCommand.execute() - No action performed");
    }
    
    @Override
    public void undo() {
        System.out.println("[LOG] NoCommand.undo() - No action to undo");
    }
    
    @Override
    public String getDescription() {
        return "No Command";
    }
    
    @Override
    public LocalDateTime getLastExecutionTime() {
        return null;
    }
}
