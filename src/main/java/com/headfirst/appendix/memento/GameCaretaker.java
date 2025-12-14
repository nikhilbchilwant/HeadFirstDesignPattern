package com.headfirst.appendix.memento;

import java.util.Stack;

// Caretaker: Keeps track of mementos (saves)
// It knows WHEN to save/restore, but not WHAT is inside the memento.
public class GameCaretaker {
    // Stack for Undo functionality
    private Stack<GameMemento> history = new Stack<>();
    
    public void saveState(GameOriginator game) {
        history.push(game.saveGame());
    }
    
    public void undo(GameOriginator game) {
        if (!history.isEmpty()) {
            game.loadGame(history.pop());
        } else {
            System.out.println("Nothing to undo!");
        }
    }
}
