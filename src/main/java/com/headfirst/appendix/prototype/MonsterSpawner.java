package com.headfirst.appendix.prototype;

public class MonsterSpawner {
    private Monster prototype;
    
    // The spawner doesn't know if it's a Dragon or Zombie.
    // It just knows it has a "Prototype" it can copy.
    public MonsterSpawner(Monster prototype) {
        this.prototype = prototype;
    }
    
    public Monster spawnMonster() {
        return prototype.copy();
    }
}
