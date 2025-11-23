package com.headfirst.ch1;

public class MiniDuckSimulator {
    public static void main(String[] args) {
        var mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        // Dynamic behavior change example
        var model = new MallardDuck();
        model.setFlyBehavior(new FlyNoWay());
        model.performFly();
    }
}
