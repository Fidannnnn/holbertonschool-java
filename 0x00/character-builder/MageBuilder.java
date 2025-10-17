public class MageBuilder implements Builder {
    private String name;
    private CharacterType type = CharacterType.MAGE;
    private int intelligence;
    private int strength;
    private int endurance;
    private int resilience;
    private int dexterity;

    @Override public void setName(String name) { this.name = name; }
    @Override public void setType(CharacterType type) { this.type = type; }
    @Override public void setIntelligence(int intelligence) { this.intelligence = intelligence; }
    @Override public void setStrength(int strength) { this.strength = strength; }
    @Override public void setEndurance(int endurance) { this.endurance = endurance; }
    @Override public void setResilience(int resilience) { this.resilience = resilience; }
    @Override public void setDexterity(int dexterity) { this.dexterity = dexterity; }

    public Mage build() {
        // type is fixed to MAGE by requirement; ignore if caller set otherwise
        return new Mage(name, intelligence, strength, endurance, resilience, dexterity);
    }
}
