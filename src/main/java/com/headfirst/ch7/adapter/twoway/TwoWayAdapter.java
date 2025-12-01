package com.headfirst.ch7.adapter.twoway;

/**
 * TWO-WAY ADAPTER - Implements BOTH interfaces!
 * 
 * This allows the adapter to be used with:
 * - Old code that expects OldVendorInterface
 * - New code that expects NewVendorInterface
 * 
 * KEY CONCEPT: A single class implementing multiple interfaces.
 * This solves the migration problem where you have both old and new code.
 * 
 * TODO: Complete this class to bridge old and new interfaces.
 * 
 * YOUR TASKS:
 * 1. Add a private VendorImplementation field
 * 2. Complete the constructor
 * 3. Implement oldMethod() - delegates to vendor.doWork()
 * 4. Implement getOldData() - delegates to vendor.getData()
 * 5. Implement newMethod() - delegates to vendor.doWork()
 * 6. Implement fetchData() - delegates to vendor.getData()
 * 
 * NOTICE: Both old and new methods can call the same underlying methods!
 */
public class TwoWayAdapter implements OldVendorInterface, NewVendorInterface {
    
    // TODO 1: Add private VendorImplementation field
    private VendorImplementation vendor;
    
    
    // TODO 2: Complete constructor
    public TwoWayAdapter(VendorImplementation vendor) {
        // TODO: Store the vendor implementation
        this.vendor = vendor;
    }
    
    // ========== OLD VENDOR INTERFACE METHODS ==========
    
    // TODO 3: Implement oldMethod() from OldVendorInterface
    @Override
    public void oldMethod() {
        this.vendor.doWork();
        System.out.println("TwoWayAdapter: Called via OLD interface");
    }
    
    // TODO 4: Implement getOldData() from OldVendorInterface
    @Override
    public String getOldData() {
        return this.vendor.getData();
    }
    
    // ========== NEW VENDOR INTERFACE METHODS ==========
    
    // TODO 5: Implement newMethod() from NewVendorInterface
    @Override
    public void newMethod() {
        this.vendor.doWork();
        System.out.println("TwoWayAdapter: Called via NEW interface");
    }
    
    // TODO 6: Implement fetchData() from NewVendorInterface
    @Override
    public String fetchData() {
        return this.vendor.getData();
    }
}
