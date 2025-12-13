package com.headfirst.appendix.builder;

// Abstract Builder
public abstract class VacationBuilder {
    // Hold reference to Vacation product
    protected Vacation vacation;
    
    public void createVacation() {
        // Instantiate vacation
        vacation = new Vacation();
    }
    
    public abstract void buildDay1();
    public abstract void buildDay2();
    public abstract void buildDay3();
    public abstract void addHotel();
    public abstract void addSpecialEvent();
    
    public Vacation getVacation() {
        // return vacation
        return vacation;
    }
}
