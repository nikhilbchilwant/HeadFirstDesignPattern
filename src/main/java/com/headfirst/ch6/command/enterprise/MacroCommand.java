package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

/**
 * Enterprise-grade MacroCommand.
 * Features: immutable command array, aggregate error handling, detailed logging.
 */
public class MacroCommand implements Command {
    private final Command[] commands;
    private LocalDateTime lastExecutionTime;

    /**
     * Constructs a MacroCommand with validation and defensive copy.
     * @param commands array of commands to execute (cannot be null or empty)
     */
    public MacroCommand(Command[] commands) {
        Objects.requireNonNull(commands, "Commands array cannot be null");
        if (commands.length == 0) {
            throw new IllegalArgumentException("Commands array cannot be empty");
        }
        // Defensive copy for immutability
        this.commands = Arrays.copyOf(commands, commands.length);
        System.out.println("[LOG] MacroCommand created with " + commands.length + " commands");
    }

    @Override
    public void execute() throws CommandExecutionException {
        System.out.println("[LOG] Executing MacroCommand with " + commands.length + " sub-commands");
        var errors = new StringBuilder();
        
        for (int i = 0; i < commands.length; i++) {
            try {
                System.out.println("[LOG] Executing sub-command " + (i + 1) + "/" + commands.length + 
                                 ": " + commands[i].getDescription());
                commands[i].execute();
            } catch (CommandExecutionException e) {
                errors.append("Command ").append(i).append(" failed: ")
                      .append(e.getMessage()).append("; ");
            }
        }
        
        lastExecutionTime = LocalDateTime.now();
        
        if (errors.length() > 0) {
            throw new CommandExecutionException("MacroCommand partial failure: " + errors);
        }
        System.out.println("[LOG] MacroCommand executed successfully");
    }

    @Override
    public void undo() throws CommandExecutionException {
        System.out.println("[LOG] Undoing MacroCommand in REVERSE order");
        var errors = new StringBuilder();
        
        // Execute in reverse (LIFO)
        for (int i = commands.length - 1; i >= 0; i--) {
            try {
                System.out.println("[LOG] Undoing sub-command " + (commands.length - i) + "/" + 
                                 commands.length + ": " + commands[i].getDescription());
                commands[i].undo();
            } catch (CommandExecutionException e) {
                errors.append("Undo of command ").append(i).append(" failed: ")
                      .append(e.getMessage()).append("; ");
            }
        }
        
        if (errors.length() > 0) {
            throw new CommandExecutionException("MacroCommand undo partial failure: " + errors);
        }
        System.out.println("[LOG] MacroCommand undo successful");
    }

    @Override
    public String getDescription() {
        return "Macro with " + commands.length + " commands";
    }

    @Override
    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }
}
