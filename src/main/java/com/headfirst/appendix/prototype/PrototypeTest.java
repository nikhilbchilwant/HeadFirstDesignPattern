package com.headfirst.appendix.prototype;

public class PrototypeTest {
    public static void main(String[] args) {
        System.out.println("--- Prototype Pattern ---");
        
        Monster dragonPrototype = new Dragon("Smaug");
        MonsterSpawner dragonSpawner = new MonsterSpawner(dragonPrototype);
        
        Monster zombiePrototype = new Zombie("Walker");
        MonsterSpawner zombieSpawner = new MonsterSpawner(zombiePrototype);
        
        // Spawn clones!
        Monster m1 = dragonSpawner.spawnMonster();
        m1.spitPoison();
        
        Monster m2 = zombieSpawner.spawnMonster();
        m2.spitPoison();
        
        Monster m3 = dragonSpawner.spawnMonster();
        System.out.println("Is m1 the same object as m3? " + (m1 == m3)); // Should be false
    }
}
