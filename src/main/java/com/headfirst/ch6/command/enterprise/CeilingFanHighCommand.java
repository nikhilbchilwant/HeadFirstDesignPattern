package com.headfirst.ch6.command.enterprise;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Enterprise-grade command to set ceiling fan to high.
 * Features: state-based undo, validation, error handling, logging.
 */
public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private CeilingFan.Speed prevSpeed;
    private LocalDateTime lastExecutionTime;

    /**
     * Constructs a CeilingFanHighCommand with validation.
     * @param ceilingFan the ceiling fan to control (cannot be null)
     */
    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = Objects.requireNonNull(ceilingFan, "CeilingFan cannot be null");
        System.out.println("[LOG] CeilingFanHighCommand created for: " + ceilingFan.getLocation());
    }

    @Override
    public void execute() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Executing CeilingFanHighCommand for: " + ceilingFan.getLocation());
            prevSpeed = ceilingFan.getSpeed();
            System.out.println("[LOG] Previous speed saved: " + prevSpeed);
            ceilingFan.high();
            lastExecutionTime = LocalDateTime.now();
            System.out.println("[LOG] CeilingFanHighCommand executed successfully");
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to set ceiling fan to high at " + ceilingFan.getLocation(), e);
        }
    }

    @Override
    public void undo() throws CommandExecutionException {
        try {
            System.out.println("[LOG] Undoing CeilingFanHighCommand, restoring to: " + prevSpeed);
            switch (prevSpeed) {
                case HIGH -> ceilingFan.high();
                case MEDIUM -> ceilingFan.medium();
                case LOW -> ceilingFan.low();
                case OFF -> ceilingFan.off();
            }
            System.out.println("[LOG] CeilingFanHighCommand undo successful");
        } catch (Exception e) {
            throw new CommandExecutionException(
                "Failed to undo ceiling fan high command at " + ceilingFan.getLocation(), e);
        }
    }

    @Override
    public String getDescription() {
        return "Set " + ceilingFan.getLocation() + " ceiling fan to HIGH";
    }

    @Override
    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }
}
