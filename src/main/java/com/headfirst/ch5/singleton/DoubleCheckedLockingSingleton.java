package com.headfirst.ch5.singleton;

/**
 * Double-Checked Locking Singleton - THREAD-SAFE with OPTIMIZED PERFORMANCE
 * 
 * This is an optimization that reduces synchronization overhead.
 * It only synchronizes when the instance is null (first time only).
 * 
 * ✅ PROS:
 * - Thread-safe
 * - Lazy initialization
 * - Minimal synchronization overhead (only on first call)
 * - Good performance after initialization
 * 
 * ❌ CONS:
 * - Complex and tricky to get right
 * - MUST use volatile keyword (or it breaks!)
 * - Had issues in pre-Java 5 (memory model problems)
 * 
 * IMPORTANT: The 'volatile' keyword is ESSENTIAL!
 * Without it, the double-checked locking pattern can fail due to:
 * - Instruction reordering
 * - Memory visibility issues across threads
 * 
 * WHEN TO USE:
 * - When you need both lazy initialization AND good performance
 * - When getInstance() is called frequently
 * - When you understand the complexity (otherwise use enum!)
 */
public class DoubleCheckedLockingSingleton {
    
    // volatile is CRITICAL for double-checked locking to work correctly!
    // It prevents instruction reordering and ensures memory visibility
    private static volatile DoubleCheckedLockingSingleton uniqueInstance;
    
    private DoubleCheckedLockingSingleton() {
        System.out.println("🔒🔒 DoubleCheckedLockingSingleton instance created");
    }
    
    /**
     * Double-checked locking for optimal performance.
     * 
     * First check (outside synchronized): Avoids synchronization overhead after initialization
     * Synchronized block: Ensures thread-safety during initialization
     * Second check (inside synchronized): Prevents race condition
     */
    public static DoubleCheckedLockingSingleton getInstance() {
        // First check (no locking) - fast path for already initialized instance
        if (uniqueInstance == null) {
            // Synchronize only when instance is null
            synchronized (DoubleCheckedLockingSingleton.class) {
                // Second check (with locking) - prevents race condition
                if (uniqueInstance == null) {
                    uniqueInstance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return uniqueInstance;
    }
    
    public void doSomething() {
        System.out.println("DoubleCheckedLockingSingleton doing something...");
    }
}
