package com.headfirst.appendix.memento;

// Memento: Stores the internal state of the Originator.
// Crucially, it should have a 'narrow' interface for the Caretaker (no data access)
// and a 'wide' interface for the Originator (full data access).
// In Java, we can simulate this by making the state fields private/protected 
// or by using an inner class.
public class GameMemento {
    private String level;
    private int score;

    public GameMemento(String level, int score) {
        this.level = level;
        this.score = score;
    }

    public String getSavedLevel() { return level; }
    public int getSavedScore() { return score; }
}
