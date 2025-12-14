package com.headfirst.appendix.visitor;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Element {
    private String name;
    private List<MenuItem> items = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }
    
    public void addItem(MenuItem item) {
        items.add(item);
    }

    public String getName() { return name; }

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (MenuItem item : items) {
            item.accept(visitor);
        }
    }
}
