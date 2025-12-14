package com.headfirst.appendix.visitor;

public class VisitorTest {
    public static void main(String[] args) {
        System.out.println("--- Visitor Pattern ---");
        
        // 1. Build the Object Structure
        Menu dinnerMenu = new Menu("Dinner Menu");
        
        MenuItem steak = new MenuItem("Steak Dinner");
        steak.addIngredient(new Ingredient("Beef", 500));
        steak.addIngredient(new Ingredient("Potatoes", 200));
        
        MenuItem salad = new MenuItem("Side Salad");
        salad.addIngredient(new Ingredient("Lettuce", 20));
        salad.addIngredient(new Ingredient("Dressing", 150));
        
        dinnerMenu.addItem(steak);
        dinnerMenu.addItem(salad);
        
        // 2. Use Visitor to calculate calories
        // Notice: We don't ask the menu for calories. We ask a Visitor to go calculate it.
        CalorieCountVisitor calorieCounter = new CalorieCountVisitor();
        dinnerMenu.accept(calorieCounter);
        
        System.out.println("Total Calories: " + calorieCounter.getTotalCalories());
    }
}
