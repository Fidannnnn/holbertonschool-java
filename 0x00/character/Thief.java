public class Thief extends Character {

    public Thief(String name,
                 int intelligence,
                 int strength,
                 int endurance,
                 int resilience,
                 int dexterity) {
        super(name, CharacterType.THIEF, intelligence, strength, endurance, resilience, dexterity);
        if (!(dexterity > strength && dexterity > intelligence)) {
            throw new IllegalArgumentException("Invalid attributes for THIEF");
        }
    }

    @Override
    public double getAttackDamage() {
        return (strength * 0.5) + (dexterity * 0.35) + (endurance * 0.1) + (intelligence * 0.05);
    }
}
