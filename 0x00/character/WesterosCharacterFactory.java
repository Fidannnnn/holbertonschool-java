public class WesterosCharacterFactory extends CharacterFactory {

    @Override
    public Character createCharacter(CharacterType type, String name) {
        switch (type) {
            case MAGE:
                // intelligence:8, strength:3, endurance:3, resilience:3, dexterity:4
                return new Mage(name, 8, 3, 3, 3, 4);
            case THIEF:
                // intelligence:1, strength:8, endurance:7, resilience:7, dexterity:10
                return new Thief(name, 1, 8, 7, 7, 10);
            case WARRIOR:
                // intelligence:0, strength:9, endurance:7, resilience:10, dexterity:7
                return new Warrior(name, 0, 9, 7, 10, 7);
            default:
                throw new IllegalArgumentException("Unknown character type");
        }
    }
}
