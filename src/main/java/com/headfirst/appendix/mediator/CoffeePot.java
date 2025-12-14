package com.headfirst.appendix.mediator;

public class CoffeePot extends Colleague {
    public CoffeePot(Mediator mediator) {
        super(mediator);
    }
    
    public void receive(String message) {
        // TODO: React to alarm?
        // if message == "ALARM_ON" -> "CoffeePot: I am starting now!"
        System.out.println("CoffeePot received: " + message);
        if (message.equals("ALARM_ON")) {
            System.out.println("CoffeePot: Good morning! Brewing coffee...");
        }
    }
}
