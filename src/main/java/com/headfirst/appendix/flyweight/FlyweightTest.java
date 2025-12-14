package com.headfirst.appendix.flyweight;

public class FlyweightTest {
    public static void main(String[] args) {
        System.out.println("--- Flyweight Pattern ---");

        // TODO: Simulate extensive forest creation
        // 1. Get TreeTypes from Factory
        // 2. Create many Trees sharing those types
        // 3. Draw them
        
        // Example:
        // TreeType type = TreeFactory.getTreeType("Oak", "Green", "Texture");
        // Tree tree = new Tree(10, 20, type);
        // tree.draw();

        // Create a forest of 1 million trees
        // Create a forest of 1 million trees
        for (int i = 0; i < 1000000; i++) {
            TreeType type = TreeFactory.getTreeType("Oak", "Green", "Texture");
            Tree tree = new Tree(i, i, type);
            // tree.draw(); // Don't print 1 million times!
        }
        
        System.out.println("Created 1,000,000 trees.");
        System.out.println("Unique TreeType objects created: " + TreeFactory.getUniqueTreeTypeCount());
        
        // Add another type to verify
        TreeFactory.getTreeType("Pine", "Green", "Texture");
        System.out.println("Unique TreeType objects after adding Pine: " + TreeFactory.getUniqueTreeTypeCount());
    }
}
