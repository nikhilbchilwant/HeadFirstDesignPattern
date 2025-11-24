package com.headfirst.ch3.starbuzz;

public class Mocha implements CondimentDecorator {
    // Thread Safety Note: If the 'beverage' reference is shared and mutated by another thread,
    // this decorator might calculate cost based on stale state.
    // However, in this pattern, we typically construct the chain and then just read from it.

    private final Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Beverage getWrappedBeverage() {
        return beverage;
    }
 
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
 
    public double cost() {
        return .20 + beverage.cost();
    }
}
