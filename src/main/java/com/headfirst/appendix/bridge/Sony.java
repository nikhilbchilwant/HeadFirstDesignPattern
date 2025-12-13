package com.headfirst.appendix.bridge;

// Concrete Implementor
public class Sony implements TV {
    private int currentChannel = 1;

    public void on() {
        System.out.println("Sony TV is on");
    }
    
    public void off() {
        System.out.println("Sony TV is off");
    }
    
    public void tuneChannel(int channel) {
        this.currentChannel = channel;
        System.out.println("Sony TV is tuned to channel " + currentChannel);
    }

    public int getCurrentChannel() {
        return currentChannel;
    }
}
