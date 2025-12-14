package com.headfirst.appendix.visitor;

import java.util.ArrayList;
import java.util.List;

public class MenuItem implements Element {
    private String name;
    private List<Ingredient> ingredients = new ArrayList<>();

    public MenuItem(String name) {
        this.name = name;
    }
    
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }
    
    public List<Ingredient> getIngredients() { return ingredients; }
    public String getName() { return name; }

    public void accept(Visitor visitor) {
        // Double Dispatch: First visit the item itself
        visitor.visit(this);
        
        // Then assume responsibility to pass visitor to children (or let visitor handle iteration)
        // Usually, the Element just visits itself. The Visitor logic decides whether to traverse children.
        // BUT, often the traversal logic is inside the Element structure.
        // Let's implement traversal here for simplicity:
        for (Ingredient i : ingredients) {
            i.accept(visitor);
        }
    }
}
