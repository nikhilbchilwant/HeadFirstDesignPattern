package com.headfirst.appendix.mediator;

public class Alarm extends Colleague {
    public Alarm(Mediator mediator) {
        super(mediator);
    }
    
    public void receive(String message) {
        System.out.println("Alarm received: " + message);
    }
    
    public void raise() {
        System.out.println("Alarm is raising event...");
        // TODO: Send specific message to mediator (e.g., "ALARM_ON" -> mediator triggers Sprinkler/Lights)
        send("ALARM_ON");
    }
}
