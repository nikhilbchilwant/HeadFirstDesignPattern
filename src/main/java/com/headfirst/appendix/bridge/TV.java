package com.headfirst.appendix.bridge;

// Implementor Interface
public interface TV {
    // Define method to power on
    public void on();
    
    // Define method to power off
    public void off();
    
    // Define method to tune channel
    public void tuneChannel(int channel);

    public int getCurrentChannel();
}
