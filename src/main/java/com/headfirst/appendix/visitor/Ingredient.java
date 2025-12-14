package com.headfirst.appendix.visitor;

public class Ingredient implements Element {
    private String name;
    private int calories;

    public Ingredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public int getCalories() { return calories; }
    public String getName() { return name; }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
