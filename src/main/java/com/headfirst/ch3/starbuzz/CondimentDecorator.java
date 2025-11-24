package com.headfirst.ch3.starbuzz;

public interface CondimentDecorator extends Beverage {

    /**
     * Returns the wrapped beverage that this decorator is enhancing.
     * 
     * @return the underlying beverage
     */
    Beverage getWrappedBeverage();
}
