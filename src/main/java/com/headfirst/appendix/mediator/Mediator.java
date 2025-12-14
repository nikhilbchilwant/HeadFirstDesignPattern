package com.headfirst.appendix.mediator;

public interface Mediator {
    // Core method for colleagues to send messages
    void send(String message, Colleague colleague);
}
