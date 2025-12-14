package com.headfirst.appendix.memento;

public class MementoTest {
    public static void main(String[] args) {
        System.out.println("--- Memento Pattern ---");
        
        GameOriginator game = new GameOriginator();
        GameCaretaker caretaker = new GameCaretaker();
        
        // 1. Initial State
        game.setLevel("Level 1");
        game.setScore(0);
        game.play(); // score becomes 100
        
        // 2. Save Game (Checkpoint)
        System.out.println(">>> Saving Game...");
        caretaker.saveState(game);
        
        // 3. Play more (and mess up)
        game.setLevel("Level 2 - Boss Fight");
        game.play(); // score becomes 200
        game.setScore(-500); // Oops, died
        game.play(); // score -400
        
        // 4. Undo! (Load Checkpoint)
        System.out.println(">>> Undo! Loading last save...");
        caretaker.undo(game);
        game.play(); // Should resume from Level 1, Score 100 -> 200
    }
}
