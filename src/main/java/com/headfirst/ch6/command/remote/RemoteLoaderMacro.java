package com.headfirst.ch6.command.remote;

/**
 * Test class demonstrating MacroCommand (Party Mode).
 */
public class RemoteLoaderMacro {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        // Create all the devices
        Light livingRoomLight = new Light("Living Room");
        Stereo stereo = new Stereo("Living Room");
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        // Create commands for party mode
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        // Create macro commands for party mode
        Command[] partyOn = { livingRoomLightOn, stereoOn, ceilingFanHigh };
        Command[] partyOff = { livingRoomLightOff, stereoOff, ceilingFanOff };

        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        // Load macro commands into slot 0
        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(0);

        System.out.println("\n--- Pushing Macro Off ---");
        remoteControl.offButtonWasPushed(0);

        System.out.println("\n--- Pushing Macro Undo ---");
        remoteControl.undoButtonWasPushed();
    }
}
