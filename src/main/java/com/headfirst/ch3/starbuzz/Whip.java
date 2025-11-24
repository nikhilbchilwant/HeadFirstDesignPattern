package com.headfirst.ch3.starbuzz;

public class Whip implements CondimentDecorator {

    private final Beverage beverage;
 
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Beverage getWrappedBeverage() {
        return beverage;
    }
 
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
 
    public double cost() {
        return .10 + beverage.cost();
    }
}
