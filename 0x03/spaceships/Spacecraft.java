// Spacecraft.java
public class Spacecraft {
    private int health;
    private int attack;

    public Spacecraft(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public String toString() {
        return "Health: " + getHealth() + " - Attack: " + getAttack();
    }
}
// Health: %d - Attack: %d