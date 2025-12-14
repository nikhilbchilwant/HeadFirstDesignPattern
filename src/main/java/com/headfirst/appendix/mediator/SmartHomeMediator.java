package com.headfirst.appendix.mediator;

public class SmartHomeMediator implements Mediator {
    // References to specific colleagues
    private Alarm alarm;
    private CoffeePot coffeePot;
    // Sprinkler, Calendar, etc.

    public void setAlarm(Alarm alarm) { this.alarm = alarm; }
    public void setCoffeePot(CoffeePot coffeePot) { this.coffeePot = coffeePot; }

    public void send(String message, Colleague sender) {
        // TODO: Central Logic
        // if (sender == alarm && message == "ALARM_ON") -> coffeePot.receive(message)
        
        System.out.println("Mediator: coordinating for msg '" + message + "'");
        
        if (sender == alarm) {
            // Logic: If alarm goes off, tell coffee pot to start
            if (coffeePot != null) {
                coffeePot.receive(message);
            }
        }

        if (sender == coffeePot) {
            // Logic: If coffee pot is ready, tell alarm to stop
            if (alarm != null) {
                alarm.receive(message);
            }
        }
    }
}
