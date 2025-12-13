package com.headfirst.appendix.builder;

public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("Testing Builder Pattern...");
        
        VacationBuilder outdoorsy = new OutdoorsVacationBuilder();
        TripDirector director = new TripDirector();
        
        director.construct(outdoorsy);
        
        Vacation vacation = outdoorsy.getVacation();
        System.out.println(vacation);
        
        System.out.println("--- Effective Java Builder ---");
        Pizza meatLovers = new Pizza.Builder(12, "Thin Crust")
                .addPepperoni()
                .addBacon()
                .addCheese()
                .build();
        System.out.println("Meat Lovers Pizza: " + meatLovers);

        Pizza veggie = new Pizza.Builder(10, "Deep Dish")
                .addMushrooms()
                .addCheese()
                .build();
        System.out.println("Veggie Pizza: " + veggie);
        
        System.out.println("Builder Pattern Test Completed.");
    }
}
