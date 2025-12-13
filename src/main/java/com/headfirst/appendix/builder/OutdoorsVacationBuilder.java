package com.headfirst.appendix.builder;

public class OutdoorsVacationBuilder extends VacationBuilder {
    public void buildDay1() {
        // Add hiking
        vacation.addEvent("Hiking");
    }
    
    public void buildDay2() {
        // Add rafting
        vacation.addEvent("Rafting");
    }
    
    public void buildDay3() {
        // Add climbing
        vacation.addEvent("Climbing");
    }
    
    public void addHotel() {
        // Add "Tent"
        vacation.setHotel("Tent");
    }
    
    public void addSpecialEvent() {
        // Add "Campfire"
        vacation.addEvent("Campfire");
    }
}
