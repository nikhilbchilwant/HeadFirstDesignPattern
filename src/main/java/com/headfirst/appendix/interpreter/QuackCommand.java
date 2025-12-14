package com.headfirst.appendix.interpreter;

public class QuackCommand implements Expression {
    public boolean interpret(Context context) {
        // TODO: Check if context starts with "quack"
        if (context.startsWith("quack")) {
            context.skip("quack");
            context.addOutput(" Duck quacks!");
            return true;
        }
        return false;
    }
}
