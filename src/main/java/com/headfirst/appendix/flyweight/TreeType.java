package com.headfirst.appendix.flyweight;

// Flyweight: Stores intrinsic state (shared data)
public class TreeType {
    private String name;
    private String color;
    private String otherTreeData; // e.g. texture, model

    public TreeType(String name, String color, String otherTreeData) {
        this.name = name;
        this.color = color;
        this.otherTreeData = otherTreeData;
    }

    // Operation based on extrinsic state (x, y)
    public void draw(int x, int y) {
        // TODO: Print drawing instruction using extrinsic state (x, y) and intrinsic state (name, color)
        System.out.println("Drawing " + name + " tree at (" + x + ", " + y + ")");
    }
}
