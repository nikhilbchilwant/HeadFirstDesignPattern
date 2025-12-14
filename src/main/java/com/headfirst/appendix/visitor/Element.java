package com.headfirst.appendix.visitor;

public interface Element {
    // The "hook" that accepts a visitor
    void accept(Visitor visitor);
}
