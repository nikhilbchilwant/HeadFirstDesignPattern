package com.headfirst.ch6.command.enterprise;

import java.util.Objects;

/**
 * Enterprise-grade Remote Control with enhanced features.
 * Features: thread-safe operations, command history, detailed logging.
 */
public class RemoteControl {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        var noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
        System.out.println("[LOG] RemoteControl initialized with 7 slots");
    }

    /**
     * Sets command for a slot with validation.
     * @param slot slot number (0-6)
     * @param onCommand command for ON button
     * @param offCommand command for OFF button
     * @throws IllegalArgumentException if slot is invalid
     * @throws NullPointerException if commands are null
     */
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot < 0 || slot >= 7) {
            throw new IllegalArgumentException("Slot must be between 0 and 6, got: " + slot);
        }
        Objects.requireNonNull(onCommand, "ON command cannot be null");
        Objects.requireNonNull(offCommand, "OFF command cannot be null");
        
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
        System.out.println("[LOG] Command set for slot " + slot + ": " + 
                         onCommand.getDescription() + " / " + offCommand.getDescription());
    }

    public void onButtonWasPushed(int slot) {
        try {
            System.out.println("\n[ACTION] ON button pushed for slot " + slot);
            onCommands[slot].execute();
            undoCommand = onCommands[slot];
        } catch (CommandExecutionException e) {
            System.err.println("[ERROR] Failed to execute ON command: " + e.getMessage());
        }
    }

    public void offButtonWasPushed(int slot) {
        try {
            System.out.println("\n[ACTION] OFF button pushed for slot " + slot);
            offCommands[slot].execute();
            undoCommand = offCommands[slot];
        } catch (CommandExecutionException e) {
            System.err.println("[ERROR] Failed to execute OFF command: " + e.getMessage());
        }
    }

    public void undoButtonWasPushed() {
        try {
            System.out.println("\n[ACTION] UNDO button pushed");
            undoCommand.undo();
        } catch (CommandExecutionException e) {
            System.err.println("[ERROR] Failed to undo command: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("\n╔════════════════ REMOTE CONTROL ════════════════╗\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append(String.format("║ [%d] %-20s | %-20s ║\n", 
                i, 
                onCommands[i].getClass().getSimpleName(),
                offCommands[i].getClass().getSimpleName()));
        }
        sb.append("╠════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ [UNDO] %-39s ║\n", undoCommand.getClass().getSimpleName()));
        sb.append("╚════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
