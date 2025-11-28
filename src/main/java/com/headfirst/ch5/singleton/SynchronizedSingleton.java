package com.headfirst.ch5.singleton;

/**
 * Synchronized Singleton - THREAD-SAFE but with PERFORMANCE OVERHEAD
 * 
 * This fixes the thread-safety issue by synchronizing the getInstance() method.
 * 
 * ✅ PROS:
 * - Thread-safe
 * - Simple to understand
 * - Lazy initialization
 * 
 * ❌ CONS:
 * - Synchronization overhead on EVERY call to getInstance()
 * - Can reduce performance by up to 100x
 * - Synchronization is only needed for the first call!
 * 
 * WHEN TO USE:
 * - When getInstance() is not called frequently
 * - When the singleton is cheap to create
 * - When simplicity is more important than performance
 */
public class SynchronizedSingleton {
    
    private static SynchronizedSingleton uniqueInstance;
    
    private SynchronizedSingleton() {
        System.out.println("🔒 SynchronizedSingleton instance created");
    }
    
    /**
     * Thread-safe getInstance using synchronization.
     * ⚠️ Performance cost: synchronized on every call!
     */
    public static synchronized SynchronizedSingleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new SynchronizedSingleton();
        }
        return uniqueInstance;
    }
    
    public void doSomething() {
        System.out.println("SynchronizedSingleton doing something...");
    }
}
