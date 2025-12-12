package com.headfirst.ch12.DuckSimulator;

public class DuckCall implements Quackable {
	Observable observable;
 
	public DuckCall() {
		observable = new Observable(this);
	}
 
	public void quack() {
		System.out.println("Kweak");
		notifyObservers();
	}
 
	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}
 
	public void notifyObservers() {
		observable.notifyObservers();
	}

	public String toString() {
		return "Duck Call";
	}
}
