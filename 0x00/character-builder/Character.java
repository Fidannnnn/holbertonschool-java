import java.util.Locale;

public abstract class Character {
    protected final String name;
    protected final CharacterType type;
    protected final int intelligence;
    protected final int strength;
    protected final int endurance;
    protected final int resilience;
    protected final int dexterity;

    public Character(String name,
                     CharacterType type,
                     int intelligence,
                     int strength,
                     int endurance,
                     int resilience,
                     int dexterity) {
        this.name = name;
        this.type = type;
        this.intelligence = intelligence;
        this.strength = strength;
        this.endurance = endurance;
        this.resilience = resilience;
        this.dexterity = dexterity;
    }

    public abstract double getAttackDamage();

    @Override
    public String toString() {
        String dmg = String.format(Locale.US, "%.2f", getAttackDamage());
        return "Character { name = " + name +
                ", type = " + type +
                ", intelligence = " + intelligence +
                ", strength = " + strength +
                ", endurance = " + endurance +
                ", resilience = " + resilience +
                ", dexterity = " + dexterity +
                ", attack damage = " + dmg + " }";
    }
}
