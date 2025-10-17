public class Mage extends Character {

    public Mage(String name,
                int intelligence,
                int strength,
                int endurance,
                int resilience,
                int dexterity) {
        super(name, CharacterType.MAGE, intelligence, strength, endurance, resilience, dexterity);
        if (!(intelligence > strength && intelligence > dexterity)) {
            throw new IllegalArgumentException("Invalid attributes for MAGE");
        }
    }

    @Override
    public double getAttackDamage() {
        return (intelligence * 0.8) + (strength * 0.05) + (dexterity * 0.05) + (endurance * 0.1);
    }
}
