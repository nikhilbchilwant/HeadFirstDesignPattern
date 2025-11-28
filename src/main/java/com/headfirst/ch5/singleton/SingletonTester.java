package com.headfirst.ch5.singleton;

/**
 * Comprehensive Singleton Pattern Demonstration
 * 
 * This class tests all singleton implementations and demonstrates:
 * 1. The enum-based singleton (ChocolateBoiler) in action
 * 2. Singleton uniqueness across all implementations
 * 3. Thread-safety concerns
 * 4. Best practices
 */
public class SingletonTester {
    
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("    SINGLETON PATTERN DEMONSTRATION");
        System.out.println("=======================================================\n");
        
        // Part 1: Enum Singleton (ChocolateBoiler) - THE RECOMMENDED WAY!
        demonstrateChocolateBoiler();
        
        System.out.println("\n=======================================================\n");
        
        // Part 2: Test singleton uniqueness
        testSingletonUniqueness();
        
        System.out.println("\n=======================================================\n");
        
        // Part 3: Thread-safety demonstration
        demonstrateThreadSafety();
        
        System.out.println("\n=======================================================\n");
        
        // Part 4: Summary and recommendations
        printSummary();
    }
    
    /**
     * Demonstrate the enum-based ChocolateBoiler singleton.
     * This shows the RECOMMENDED approach to singletons in Java.
     */
    private static void demonstrateChocolateBoiler() {
        System.out.println("ENUM SINGLETON DEMONSTRATION (ChocolateBoiler)");
        System.out.println("-------------------------------------------------------");
        
        // Get the singleton instance
        ChocolateBoiler boiler = ChocolateBoiler.INSTANCE;
        
        System.out.println("\nInitial state: " + boiler.getState());
        
        // Try to fill
        System.out.println("\nAttempting to fill...");
        boiler.fill();
        System.out.println(boiler.getState());
        
        // Try to fill again (should fail)
        System.out.println("\nAttempting to fill again...");
        boiler.fill();
        
        // Try to drain without boiling (should fail)
        System.out.println("\nAttempting to drain without boiling...");
        boiler.drain();
        
        // Boil the chocolate
        System.out.println("\nBoiling the chocolate...");
        boiler.boil();
        System.out.println(boiler.getState());
        
        // Now drain should work
        System.out.println("\nAttempting to drain...");
        boiler.drain();
        System.out.println(boiler.getState());
        
        // Verify it's truly a singleton
        System.out.println("\nVerifying singleton behavior:");
        ChocolateBoiler boiler2 = ChocolateBoiler.INSTANCE;
        System.out.println("boiler == boiler2: " + (boiler == boiler2));
        System.out.println("Same state? " + boiler2.getState());
    }
    
    /**
     * Test that all singleton implementations return the same instance.
     */
    private static void testSingletonUniqueness() {
        System.out.println("TESTING SINGLETON UNIQUENESS");
        System.out.println("-------------------------------------------------------");
        System.out.println("Each singleton should return the SAME instance on multiple calls:\n");
        
        // Test Classic Singleton
        System.out.println("1. ClassicSingleton:");
        ClassicSingleton classic1 = ClassicSingleton.getInstance();
        ClassicSingleton classic2 = ClassicSingleton.getInstance();
        System.out.println("   Same instance? " + (classic1 == classic2) + " OK");
        
        // Test Synchronized Singleton
        System.out.println("\n2. SynchronizedSingleton:");
        SynchronizedSingleton sync1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton sync2 = SynchronizedSingleton.getInstance();
        System.out.println("   Same instance? " + (sync1 == sync2) + " OK");
        
        // Test Eager Singleton
        System.out.println("\n3. EagerSingleton:");
        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("   Same instance? " + (eager1 == eager2) + " OK");
        
        // Test Double-Checked Locking Singleton
        System.out.println("\n4. DoubleCheckedLockingSingleton:");
        DoubleCheckedLockingSingleton dcl1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton dcl2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println("   Same instance? " + (dcl1 == dcl2) + " OK");
        
        // Test Enum Singleton
        System.out.println("\n5. ChocolateBoiler (Enum):");
        ChocolateBoiler boiler1 = ChocolateBoiler.INSTANCE;
        ChocolateBoiler boiler2 = ChocolateBoiler.INSTANCE;
        System.out.println("   Same instance? " + (boiler1 == boiler2) + " OK");
        
        System.out.println("\nAll singletons maintain uniqueness!");
    }
    
    /**
     * Demonstrate thread-safety concerns with multi-threaded access.
     * Note: Classic singleton might fail this test!
     */
    private static void demonstrateThreadSafety() {
        System.out.println("THREAD-SAFETY DEMONSTRATION");
        System.out.println("-------------------------------------------------------");
        System.out.println("Creating multiple threads to access singletons...\n");
        
        // Test enum singleton with multiple threads
        System.out.println("Testing Enum Singleton (ChocolateBoiler):");
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int threadNum = i + 1;
            threads[i] = new Thread(() -> {
                ChocolateBoiler boiler = ChocolateBoiler.INSTANCE;
                System.out.println("  Thread " + threadNum + ": Got instance " + 
                    System.identityHashCode(boiler));
            });
            threads[i].start();
        }
        
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("All threads got the same instance (same hash code)!");
        System.out.println("\nNote: Enum singleton is inherently thread-safe!");
    }
    
    /**
     * Print summary and recommendations.
     */
    private static void printSummary() {
        System.out.println("SUMMARY & RECOMMENDATIONS");
        System.out.println("-------------------------------------------------------");
        System.out.println("\nBEST PRACTICE: Use Enum Singleton!");
        System.out.println("   - Thread-safe by default");
        System.out.println("   - Serialization-safe");
        System.out.println("   - Reflection-proof");
        System.out.println("   - Concise and elegant");
        System.out.println("   - No performance overhead");
        
        System.out.println("\nOther Implementations (for learning):");
        System.out.println("   WARNING: Classic: Simple but NOT thread-safe");
        System.out.println("   Note:    Synchronized: Thread-safe but slow");
        System.out.println("   Note:    Eager: Thread-safe but not lazy");
        System.out.println("   Note:    Double-Checked: Complex but optimized");
        
        System.out.println("\nRemember:");
        System.out.println("   \"A single-element enum type is the best way");
        System.out.println("    to implement a singleton\" - Joshua Bloch");
        
        System.out.println("\n=======================================================");
    }
}
