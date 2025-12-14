package com.headfirst.appendix.visitor;

public interface Visitor {
    // Methods for each element type we can visit
    void visit(Menu menu);
    void visit(MenuItem menuItem);
    void visit(Ingredient ingredient);
}
