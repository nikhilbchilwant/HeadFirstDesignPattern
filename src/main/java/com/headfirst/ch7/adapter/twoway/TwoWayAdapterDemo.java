package com.headfirst.ch7.adapter.twoway;

/**
 * Test demonstrating the Two-Way Adapter pattern.
 * Shows how ONE adapter can work with BOTH old and new code.
 */
public class TwoWayAdapterDemo {
    
    public static void main(String[] args) {
        // Create the actual implementation
        VendorImplementation vendor = new VendorImplementation();
        
        // Create ONE adapter that implements BOTH interfaces
        TwoWayAdapter adapter = new TwoWayAdapter(vendor);
        
        System.out.println("=== SCENARIO 1: Legacy code using OLD interface ===");
        useLegacyCode(adapter);  // Passes adapter as OldVendorInterface
        
        System.out.println("\n=== SCENARIO 2: Modern code using NEW interface ===");
        useModernCode(adapter);  // Passes adapter as NewVendorInterface
        
        System.out.println("\n=== KEY POINT ===");
        System.out.println("The SAME adapter object works with BOTH old and new code!");
        System.out.println("This allows gradual migration without rewriting everything.");
    }
    
    /**
     * OLD CODE - expects OldVendorInterface.
     * This represents legacy systems that haven't been updated yet.
     */
    static void useLegacyCode(OldVendorInterface oldVendor) {
        System.out.println("Legacy code calling old interface methods:");
        oldVendor.oldMethod();
        System.out.println("Data: " + oldVendor.getOldData());
    }
    
    /**
     * NEW CODE - expects NewVendorInterface.
     * This represents modernized systems using the new API.
     */
    static void useModernCode(NewVendorInterface newVendor) {
        System.out.println("Modern code calling new interface methods:");
        newVendor.newMethod();
        System.out.println("Data: " + newVendor.fetchData());
    }
}
