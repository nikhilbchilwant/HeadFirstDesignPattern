package com.headfirst.appendix.visitor;

public class CalorieCountVisitor implements Visitor {
    private int totalCalories = 0;

    public void visit(Menu menu) {
        // Menu itself has no calories, maybe just print
        System.out.println("Entering Menu: " + menu.getName());
    }

    public void visit(MenuItem menuItem) {
        // MenuItem might add some base calories?
        System.out.println("Checking Item: " + menuItem.getName());
    }

    public void visit(Ingredient ingredient) {
        System.out.println("  + Ingredient: " + ingredient.getName() + " (" + ingredient.getCalories() + " cal)");
        totalCalories += ingredient.getCalories();
    }
    
    public int getTotalCalories() {
        return totalCalories;
    }
}
