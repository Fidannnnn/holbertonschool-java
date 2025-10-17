public class MiddleEarthCharacterFactory extends CharacterFactory {

    @Override
    public Character createCharacter(CharacterType type, String name) {
        switch (type) {
            case MAGE:
                // intelligence:10, strength:2, endurance:5, resilience:3, dexterity:4
                return new Mage(name, 10, 2, 5, 3, 4);
            case THIEF:
                // intelligence:2, strength:6, endurance:8, resilience:5, dexterity:10
                return new Thief(name, 2, 6, 8, 5, 10);
            case WARRIOR:
                // intelligence:1, strength:8, endurance:5, resilience:10, dexterity:6
                return new Warrior(name, 1, 8, 5, 10, 6);
            default:
                throw new IllegalArgumentException("Unknown character type");
        }
    }
}
