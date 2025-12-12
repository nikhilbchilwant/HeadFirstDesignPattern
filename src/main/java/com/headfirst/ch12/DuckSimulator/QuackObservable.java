package com.headfirst.ch12.DuckSimulator;

/**
 * QuackObservable defines methods for registering and notifying observers.
 * All Quackables will extend this interface.
 */
public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
