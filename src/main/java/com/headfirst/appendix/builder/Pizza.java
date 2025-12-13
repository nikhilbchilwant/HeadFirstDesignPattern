package com.headfirst.appendix.builder;

// "Effective Java" Style Builder
// Useful when you have many constructor parameters, some required, some optional.
public class Pizza {
    // Required parameters
    private final int size;
    private final String crust;
    
    // Optional parameters (initialized to default values)
    private final boolean pepperoni;
    private final boolean cheese;
    private final boolean mushrooms;
    private final boolean bacon;
    
    // Private constructor so only the Builder can create it
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.pepperoni = builder.pepperoni;
        this.cheese = builder.cheese;
        this.mushrooms = builder.mushrooms;
        this.bacon = builder.bacon;
    }
    
    // Static Inner Builder Class
    public static class Builder {
        // Required parameters
        private final int size;
        private final String crust;
        
        // Optional parameters - initialized to default values
        private boolean pepperoni = false;
        private boolean cheese = false;
        private boolean mushrooms = false;
        private boolean bacon = false;
        
        public Builder(int size, String crust) {
            this.size = size;
            this.crust = crust;
        }
        
        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;    
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }
        
        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }
        
        public Builder addBacon() {
            this.bacon = true;
            return this;
        }
        
        public Pizza build() {
            return new Pizza(this);
        }
    }
    
    @Override
    public String toString() {
        return "Pizza{" +
                "size=" + size +
                ", crust='" + crust + '\'' +
                ", pepperoni=" + pepperoni +
                ", cheese=" + cheese +
                ", mushrooms=" + mushrooms +
                ", bacon=" + bacon +
                '}';
    }
}
