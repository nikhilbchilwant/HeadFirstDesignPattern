package com.headfirst.appendix.prototype;

public class Dragon implements Monster {
    private String name;
    // Assume loading this takes time/resources...
    
    public Dragon(String name) {
        this.name = name;
        // System.out.println("Loading heavy dragon texture...");
    }
    
    public Monster copy() {
        // Simple Shallow Copy
        return new Dragon(this.name);
    }
    
    public void spitPoison() {
        System.out.println(name + " spits fire (not poison, I'm a dragon)!");
    }
}
