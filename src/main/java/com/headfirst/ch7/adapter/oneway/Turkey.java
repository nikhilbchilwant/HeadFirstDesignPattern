package com.headfirst.ch7.adapter.oneway;

/**
 * Adaptee interface - incompatible with Duck.
 * Turkeys gobble instead of quack, and fly short distances.
 */
public interface Turkey {
    public void gobble();
    public void fly();
}
