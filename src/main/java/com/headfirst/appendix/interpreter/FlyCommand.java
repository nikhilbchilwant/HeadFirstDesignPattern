package com.headfirst.appendix.interpreter;

public class FlyCommand implements Expression {
    public boolean interpret(Context context) {
        // TODO: Check if context starts with "fly"
        if (context.startsWith("fly")) {
            context.skip("fly");
            // TODO: parse parsing logic for direction/distance if you want to be fancy
            context.addOutput(" Duck is flying!");
            return true;
        }
        return false;
    }
}
