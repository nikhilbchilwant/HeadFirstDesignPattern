package com.headfirst.ch5.singleton;

/**
 * Eager Singleton - THREAD-SAFE via Static Initialization
 * 
 * This creates the instance eagerly at class loading time.
 * The JVM guarantees that static initialization is thread-safe.
 * 
 * ✅ PROS:
 * - Thread-safe (JVM guarantees)
 * - No synchronization overhead
 * - Simple and straightforward
 * 
 * ❌ CONS:
 * - Instance is created even if never used (not lazy)
 * - Can't handle exceptions in constructor easily
 * - Uses memory even if singleton is never accessed
 * 
 * WHEN TO USE:
 * - When the singleton is always used
 * - When the singleton is cheap to create
 * - When you want simplicity over lazy loading
 */
public class EagerSingleton {
    
    // Instance created at class loading time
    // JVM guarantees this is thread-safe
    private static final EagerSingleton uniqueInstance = new EagerSingleton();
    
    private EagerSingleton() {
        System.out.println("⚡ EagerSingleton instance created eagerly!");
    }
    
    /**
     * Simply return the pre-created instance.
     * No synchronization needed!
     */
    public static EagerSingleton getInstance() {
        return uniqueInstance;
    }
    
    public void doSomething() {
        System.out.println("EagerSingleton doing something...");
    }
}
