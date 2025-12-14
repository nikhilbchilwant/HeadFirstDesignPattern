package com.headfirst.appendix.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Sequence implements Expression {
    private List<Expression> expressions = new ArrayList<>();
    
    public void addExpression(Expression expression) {
        expressions.add(expression);
    }

    public boolean interpret(Context context) {
        // TODO: Try to interpret each expression in list until one succeeds.
        // Or loop until data is empty?
        // Typically, a Sequence tries to match a sequence of tokens.
        
        // Simple implementation: try all commands on current context
        for (Expression e : expressions) {
            if (e.interpret(context)) {
                // If one matches, we might continue or return
                return true; 
            }
        }
        return false;
    }
}
