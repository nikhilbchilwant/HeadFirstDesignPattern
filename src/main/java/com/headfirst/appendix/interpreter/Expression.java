package com.headfirst.appendix.interpreter;

public interface Expression {
    // Interpret the context. Returns true if match found and processed.
    boolean interpret(Context context);
}
