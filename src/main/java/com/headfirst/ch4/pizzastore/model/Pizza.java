package com.headfirst.ch4.pizzastore.model;

import com.headfirst.ch4.pizzastore.ingredients.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract base class for all pizzas.
 */
public abstract class Pizza {
    protected String name;
    protected Dough dough;
    protected Sauce sauce;
    protected Cheese cheese;
    protected Clams clams;
    protected List<String> toppings = new ArrayList<>();

    public void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough..." + dough);
        System.out.println("Adding sauce..." + sauce);
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("    " + topping);
        }
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Clams getClams() {
        return clams;
    }

    public void setClams(Clams clams) {
        this.clams = clams;
    }

    public void bake() {
        System.out.println("Baking for 25 minutes at 350°F");
    }

    public void cut() {
        System.out.println("Cutting the pizza into 8 slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public List<String> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza [name=" + name + ", dough=" + dough + ", sauce=" + sauce + ", toppings=" + toppings + "]";
    }
}
