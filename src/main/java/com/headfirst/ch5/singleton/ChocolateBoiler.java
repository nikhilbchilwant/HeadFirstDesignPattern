package com.headfirst.ch5.singleton;

/**
 * ChocolateBoiler - Enum-based Singleton Pattern (THE RECOMMENDED APPROACH!)
 * 
 * This is Joshua Bloch's recommended way to implement a singleton in Java.
 * From "Effective Java": "A single-element enum type is the best way to implement a singleton"
 * 
 * WHY ENUM SINGLETON IS SUPERIOR:
 * 1. Thread-safe by default (JVM guarantees enum initialization is thread-safe)
 * 2. Serialization-safe (enum serialization is handled specially by JVM)
 * 3. Reflection-proof (cannot instantiate via reflection)
 * 4. Concise and elegant (minimal boilerplate)
 * 5. Lazy loading (initialized on first access)
 * 
 * This chocolate boiler controls an industrial chocolate boiler used to create
 * chocolate products. The boiler must be a singleton because:
 * - Only one physical boiler exists
 * - Multiple instances could cause safety issues (double-filling, burning chocolate)
 */
public enum ChocolateBoiler {
    
    /**
     * The single instance of ChocolateBoiler.
     * This is the ONLY instance that will ever exist.
     */
    INSTANCE;
    
    // State variables
    private boolean empty;
    private boolean boiled;
    
    /**
     * Constructor is called exactly once when enum is initialized.
     * This happens on first access to INSTANCE (lazy initialization).
     */
    ChocolateBoiler() {
        empty = true;
        boiled = false;
        System.out.println("🍫 ChocolateBoiler created! Starting empty and unboiled.");
    }
    
    /**
     * Fill the boiler with milk and chocolate mixture.
     * Can only fill when empty.
     */
    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            System.out.println("✅ Filling the boiler with milk/chocolate mixture...");
        } else {
            System.out.println("❌ Cannot fill! Boiler is already full.");
        }
    }
    
    /**
     * Drain the boiler of its contents.
     * Can only drain when boiler is full and contents are boiled.
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
            System.out.println("✅ Draining the boiled milk and chocolate...");
        } else {
            if (isEmpty()) {
                System.out.println("❌ Cannot drain! Boiler is empty.");
            } else {
                System.out.println("❌ Cannot drain! Chocolate hasn't been boiled yet.");
            }
        }
    }
    
    /**
     * Boil the contents of the boiler.
     * Can only boil when boiler is full and contents are not yet boiled.
     */
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
            System.out.println("✅ Boiling the milk and chocolate mixture...");
        } else {
            if (isEmpty()) {
                System.out.println("❌ Cannot boil! Boiler is empty.");
            } else {
                System.out.println("❌ Cannot boil! Already boiled.");
            }
        }
    }
    
    public boolean isEmpty() {
        return empty;
    }
    
    public boolean isBoiled() {
        return boiled;
    }
    
    /**
     * Get current state as a string.
     */
    public String getState() {
        return String.format("ChocolateBoiler State: %s, %s", 
            empty ? "Empty" : "Full",
            boiled ? "Boiled" : "Unboiled");
    }
}
