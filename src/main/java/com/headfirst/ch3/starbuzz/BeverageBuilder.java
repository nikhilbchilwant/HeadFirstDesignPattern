package com.headfirst.ch3.starbuzz;

public class BeverageBuilder {
    private Beverage beverage;

    public BeverageBuilder(Beverage beverage) {
        this.beverage = beverage;
    }

    public BeverageBuilder addMocha() {
        this.beverage = new Mocha(this.beverage);
        return this;
    }

    public BeverageBuilder addWhip() {
        this.beverage = new Whip(this.beverage);
        return this;
    }

    public Beverage build() {
        return this.beverage;
    }
}
