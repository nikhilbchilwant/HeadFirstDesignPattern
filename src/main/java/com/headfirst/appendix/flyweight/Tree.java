package com.headfirst.appendix.flyweight;

// Context: Stores extrinsic state (unique data)
public class Tree {
    private int x;
    private int y;
    private TreeType type; // Reference to Flyweight

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y);
    }
}
