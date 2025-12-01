package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Enterprise-grade command to turn off ceiling fan.
 */
public class CeilingFanOffCommand implements Command {
    private final CeilingFan ceilingFan;
    private CeilingFan.Speed prevSpeed;
    private LocalDateTime lastExecutionTime;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = Objects.requireNonNull(ceilingFan, "CeilingFan cannot be null");
        System.out.println("[LOG] CeilingFanOffCommand created for: " + ceilingFan.getLocation());
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Executing CeilingFanOffCommand");
            prevSpeed = ceilingFan.getSpeed();
            ceilingFan.off();
            lastExecutionTime = LocalDateTime.now();
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to turn off ceiling fan", e);
        }
    }

    @Override
    public void undo() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Undoing CeilingFanOffCommand");
            switch (prevSpeed) {
                case HIGH -> ceilingFan.high();
                case MEDIUM -> ceilingFan.medium();
                case LOW -> ceilingFan.low();
                case OFF -> ceilingFan.off();
            }
        } catch (Exception e) {
            throw new CommandExecutionException("Failed to undo ceiling fan off command", e);
        }
    }

    @Override
    public String getDescription() {
        return "Turn off " + ceilingFan.getLocation() + " ceiling fan";
    }

    @Override
    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }
}
