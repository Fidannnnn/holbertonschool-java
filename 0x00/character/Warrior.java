public class Warrior extends Character {

    public Warrior(String name,
                   int intelligence,
                   int strength,
                   int endurance,
                   int resilience,
                   int dexterity) {
        super(name, CharacterType.WARRIOR, intelligence, strength, endurance, resilience, dexterity);
        if (!(strength > intelligence && strength > dexterity)) {
            throw new IllegalArgumentException("Invalid attributes for WARRIOR");
        }
    }

    @Override
    public double getAttackDamage() {
        return (strength * 0.8) + (endurance * 0.05) + (dexterity * 0.1) + (intelligence * 0.05);
    }
}
