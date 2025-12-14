package com.headfirst.appendix.memento;

// Originator: The object whose state we want to save
public class GameOriginator {
    private String level;
    private int score;

    public void setLevel(String level) {
        this.level = level;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    // Create Memento (Save State)
    public GameMemento saveGame() {
        return new GameMemento(level, score);
    }
    
    // Restore Memento (Load State)
    public void loadGame(GameMemento memento) {
        this.level = memento.getSavedLevel();
        this.score = memento.getSavedScore();
    }

    public void play() {
        // Simulate game progress
        score += 100;
        System.out.println("Playing... Level: " + level + ", Score: " + score);
    }
}
