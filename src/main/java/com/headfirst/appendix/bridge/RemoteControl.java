package com.headfirst.appendix.bridge;

// Abstraction
public abstract class RemoteControl {
    protected TV tv;
    
    public RemoteControl(TV tv) {
        this.tv = tv;
    }
    
    public void on() {
        tv.on();
    }
    
    public void off() {
        tv.off();
    }
    
    public void setChannel(int channel) {
        tv.tuneChannel(channel);
    }
}
