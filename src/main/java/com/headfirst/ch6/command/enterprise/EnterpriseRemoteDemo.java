package com.headfirst.ch6.command.enterprise;

/**
 * Demonstrates enterprise-grade Command Pattern implementation.
 * Features: logging, error handling, validation, metadata, state-based undo.
 */
public class EnterpriseRemoteDemo {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   ENTERPRISE COMMAND PATTERN DEMONSTRATION       ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // Create remote control
        var remoteControl = new RemoteControl();

        // Create receivers
        var livingRoomLight = new Light("Living Room");
        var kitchenLight = new Light("Kitchen");
        var ceilingFan = new CeilingFan("Living Room");

        // Create commands with validation
        var livingRoomLightOn = new LightOnCommand(livingRoomLight);
        var livingRoomLightOff = new LightOffCommand(livingRoomLight);
        var kitchenLightOn = new LightOnCommand(kitchenLight);
        var kitchenLightOff = new LightOffCommand(kitchenLight);
        
        var ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
        var ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        var ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // Load commands
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanMedium, ceilingFanOff);
        remoteControl.setCommand(3, ceilingFanHigh, ceilingFanOff);

        System.out.println(remoteControl);

        // Test 1: Basic on/off with undo
        System.out.println("\n═══════════════ TEST 1: Basic Commands ═══════════════");
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();

        // Test 2: State-based undo with ceiling fan
        System.out.println("\n═══════════════ TEST 2: State-Based Undo ═══════════════");
        remoteControl.onButtonWasPushed(2);  // Medium
        remoteControl.onButtonWasPushed(3);  // High
        System.out.println("\n[TEST] Now undoing - should restore to MEDIUM");
        remoteControl.undoButtonWasPushed();

        // Test 3: MacroCommand
        System.out.println("\n═══════════════ TEST 3: MacroCommand ═══════════════");
        Command[] partyOn = { livingRoomLightOn, kitchenLightOn, ceilingFanHigh };
        Command[] partyOff = { livingRoomLightOff, kitchenLightOff, ceilingFanOff };
        
        var partyOnMacro = new MacroCommand(partyOn);
        var partyOffMacro = new MacroCommand(partyOff);
        
        remoteControl.setCommand(6, partyOnMacro, partyOffMacro);
        
        System.out.println("\n[TEST] Activating PARTY MODE");
        remoteControl.onButtonWasPushed(6);
        
        System.out.println("\n[TEST] Deactivating PARTY MODE");
        remoteControl.offButtonWasPushed(6);
        
        System.out.println("\n[TEST] Undoing PARTY OFF (should reverse back on)");
        remoteControl.undoButtonWasPushed();

        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("║           ENTERPRISE FEATURES DEMONSTRATED       ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ ✓ Immutability (final fields)                   ║");
        System.out.println("║ ✓ Validation (Objects.requireNonNull)           ║");
        System.out.println("║ ✓ Error Handling (try-catch, custom exception)  ║");
        System.out.println("║ ✓ Logging (structured output)                   ║");
        System.out.println("║ ✓ Metadata (timestamps, descriptions)           ║");
        System.out.println("║ ✓ Type Safety (enum for fan speeds)             ║");
        System.out.println("║ ✓ Modern Java (var, switch expressions)         ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
