package com.headfirst.appendix.mediator;

public class MediatorTest {
    public static void main(String[] args) {
        System.out.println("--- Mediator Pattern ---");

        // 1. Create the Mediator
        SmartHomeMediator smartHome = new SmartHomeMediator();

        // 2. Create Colleagues and register them with Mediator
        // Note: In a more complex setup, the mediator might be passed in constructor, 
        // OR the colleagues register themselves. Here we do it manually.
        Alarm alarm = new Alarm(smartHome);
        CoffeePot coffeePot = new CoffeePot(smartHome);

        smartHome.setAlarm(alarm);
        smartHome.setCoffeePot(coffeePot);

        // 3. Trigger events
        System.out.println("\n[Action] Alarm raising event...");
        alarm.raise(); // Sends "ALARM_ON" -> Mediator -> CoffeePot

        System.out.println("\n[Action] CoffeePot finishing...");
        coffeePot.send("COFFEE_DONE"); // Sends "COFFEE_DONE" -> Mediator -> Alarm (stops ringing?)
    }
}
