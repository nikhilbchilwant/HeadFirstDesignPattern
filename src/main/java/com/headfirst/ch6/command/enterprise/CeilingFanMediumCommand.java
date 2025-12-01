package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Enterprise-grade command to set ceiling fan to medium.
 */
public class CeilingFanMediumCommand implements Command {
    private final CeilingFan ceilingFan;
    private CeilingFan.Speed prevSpeed;
    private LocalDateTime lastExecutionTime;

    public CeilingFanMediumCommand(CeilingFan ceilingFan) {
        this.ceilingFan = Objects.requireNonNull(ceilingFan, "CeilingFan cannot be null");
        System.out.println("[LOG] CeilingFanMediumCommand created for: " + ceilingFan.getLocation());
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Executing CeilingFanMediumCommand");
            prevSpeed = ceilingFan.getSpeed();
            ceilingFan.medium();
            lastExecutionTime = LocalDateTime.now();
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to set ceiling fan to medium", e);
        }
    }

    @Override
    public void undo() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Undoing CeilingFanMediumCommand");
            switch (prevSpeed) {
                case HIGH -> ceilingFan.high();
                case MEDIUM -> ceilingFan.medium();
                case LOW -> ceilingFan.low();
                case OFF -> ceilingFan.off();
            }
        } catch (Exception e) {
            throw new CommandExecutionException("Failed to undo ceiling fan medium command", e);
        }
    }

    @Override
    public String getDescription() {
        return "Set " + ceilingFan.getLocation() + " ceiling fan to MEDIUM";
    }

    @Override
    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }
}
