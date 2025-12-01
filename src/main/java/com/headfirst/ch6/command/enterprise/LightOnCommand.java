package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Enterprise-grade command to turn on a light.
 * Features: immutability, validation, error handling, logging, metadata.
 */
public class LightOnCommand implements Command {
    private final Light light;
    private LocalDateTime lastExecutionTime;

    /**
     * Constructs a LightOnCommand with validation.
     * @param light the light to control (cannot be null)
     * @throws NullPointerException if light is null
     */
    public LightOnCommand(Light light) {
        this.light = Objects.requireNonNull(light, "Light cannot be null");
        System.out.println("[LOG] LightOnCommand created for: " + light.getLocation());
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Executing LightOnCommand for: " + light.getLocation());
            light.on();
            lastExecutionTime = LocalDateTime.now();
            System.out.println("[LOG] LightOnCommand executed successfully at: " + lastExecutionTime);
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to turn on light at " + light.getLocation(), e);
        }
    }

    @Override
    public void undo() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Undoing LightOnCommand for: " + light.getLocation());
            light.off();
            System.out.println("[LOG] LightOnCommand undo successful");
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to undo light on command at " + light.getLocation(), e);
        }
    }

    @Override
    public String getDescription() {
        return "Turn on " + light.getLocation() + " light";
    }

    @Override
    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }
}
