package com.headfirst.ch7.adapter.twoway;

/**
 * The actual implementation (adaptee).
 * This could be a third-party library or your core logic.
 */
public class VendorImplementation {
    
    public void doWork() {
        System.out.println("VendorImplementation: Doing the actual work");
    }
    
    public String getData() {
        return "Data from VendorImplementation";
    }
}
