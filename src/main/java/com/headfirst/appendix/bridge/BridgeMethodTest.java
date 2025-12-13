package com.headfirst.appendix.bridge;

public class BridgeMethodTest {
    public static void main(String[] args) {
        System.out.println("Testing Bridge Pattern...");
        
        TV sony = new Sony();
        GenericRemote remote = new GenericRemote(sony);
        
        remote.on();
        remote.setChannel(50);
        remote.nextChannel();
        remote.prevChannel();
        remote.off();
        
        System.out.println("Bridge Pattern Test Completed.");
    }
}
