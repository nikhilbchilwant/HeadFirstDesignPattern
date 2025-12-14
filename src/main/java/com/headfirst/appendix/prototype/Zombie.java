package com.headfirst.appendix.prototype;

public class Zombie implements Monster {
    private String name;
    
    public Zombie(String name) {
        this.name = name;
    }
    
    public Monster copy() {
        return new Zombie(this.name);
    }
    
    public void spitPoison() {
        System.out.println(name + " spits toxic goo!");
    }
}
