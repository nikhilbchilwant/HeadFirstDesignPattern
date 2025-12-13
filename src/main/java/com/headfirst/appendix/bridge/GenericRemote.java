package com.headfirst.appendix.bridge;

// Refined Abstraction
public class GenericRemote extends RemoteControl {
    public GenericRemote(TV tv) {
        super(tv);
    }
    
    public void nextChannel() {
        tv.tuneChannel(tv.getCurrentChannel() + 1);
    }
    
    public void prevChannel() {
        tv.tuneChannel(tv.getCurrentChannel() - 1);
    }
}
