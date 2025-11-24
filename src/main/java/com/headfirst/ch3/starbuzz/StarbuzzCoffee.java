package com.headfirst.ch3.starbuzz;

public class StarbuzzCoffee {
 
    public static void main(String args[]) {
        // Order 1: Simple Espresso
        Beverage beverage = BeverageFactory.createBeverage(BeverageType.ESPRESSO);
        System.out.println(beverage.getDescription() + " $" + String.format("%.2f", beverage.cost()));
 
        // Order 2: House Blend with Double Mocha and Whip
        Beverage beverage2 = new BeverageBuilder(BeverageFactory.createBeverage(BeverageType.HOUSE_BLEND))
                .addMocha()
                .addMocha()
                .addWhip()
                .build();
        System.out.println(beverage2.getDescription() + " $" + String.format("%.2f", beverage2.cost()));        
    }
}
