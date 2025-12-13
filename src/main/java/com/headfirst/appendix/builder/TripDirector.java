package com.headfirst.appendix.builder;

// Director
public class TripDirector {
    public void construct(VacationBuilder builder) {
        // Orchestrate the building process
        builder.createVacation();
        builder.buildDay1();
        builder.buildDay2();
        builder.buildDay3();
        builder.addHotel();
        builder.addSpecialEvent();
    }
}
