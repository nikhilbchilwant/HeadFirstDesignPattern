package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Enterprise-grade command to turn off a light.
 * Features: immutability, validation, error handling, logging, metadata.
 */
public class LightOffCommand implements Command {
    private final Light light;
    private LocalDateTime lastExecutionTime;

    /**
     * Constructs a LightOffCommand with validation.
     * @param light the light to control (cannot be null)
     * @throws NullPointerException if light is null
     */
    public LightOffCommand(Light light) {
        this.light = Objects.requireNonNull(light, "Light cannot be null");
        System.out.println("[LOG] LightOffCommand created for: " + light.getLocation());
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Executing LightOffCommand for: " + light.getLocation());
            light.off();
            lastExecutionTime = LocalDateTime.now();
            System.out.println("[LOG] LightOffCommand executed successfully at: " + lastExecutionTime);
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to turn off light at " + light.getLocation(), e);
        }
    }

    @Override
    public void undo() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Undoing LightOffCommand for: " + light.getLocation());
            light.on();
            System.out.println("[LOG] LightOffCommand undo successful");
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to undo light off command at " + light.getLocation(), e);
        }
    }

    @Override
    public String getDescription() {
        return "Turn off " + light.getLocation() + " light";
    }

    @Override
    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }
}
