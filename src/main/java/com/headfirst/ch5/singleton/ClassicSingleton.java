package com.headfirst.ch5.singleton;

/**
 * Classic Singleton Pattern - LAZY INITIALIZATION (NOT THREAD-SAFE!)
 * 
 * This is the original, simplest form of the Singleton pattern.
 * 
 * ⚠️ WARNING: This implementation is NOT thread-safe!
 * In a multi-threaded environment, multiple threads could create multiple instances.
 * 
 * WHEN TO USE:
 * - Single-threaded applications only
 * - Learning/educational purposes
 * - Quick prototypes where thread-safety isn't a concern
 * 
 * WHY IT FAILS IN MULTI-THREADED ENVIRONMENTS:
 * Two threads could both check (uniqueInstance == null) at the same time,
 * both see it as null, and both create a new instance!
 */
public class ClassicSingleton {
    
    // Static variable to hold the single instance
    private static ClassicSingleton uniqueInstance;
    
    // Private constructor prevents instantiation from outside
    private ClassicSingleton() {
        System.out.println("📦 ClassicSingleton instance created");
    }
    
    /**
     * Get the single instance (lazy initialization).
     * ⚠️ NOT THREAD-SAFE!
     */
    public static ClassicSingleton getInstance() {
        if (uniqueInstance == null) {
            // 🐛 RACE CONDITION HERE! Multiple threads could enter this block
            uniqueInstance = new ClassicSingleton();
        }
        return uniqueInstance;
    }
    
    public void doSomething() {
        System.out.println("ClassicSingleton doing something...");
    }
}
