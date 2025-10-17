public class Program {
    public static void main(String[] args) {
        CharacterFactory middleEarthCharacterFactory = new WesterosCharacterFactory();
        CharacterFactory westerosCharacterFactory = new MiddleEarthCharacterFactory();

        try {
            Character mageGandalf = middleEarthCharacterFactory.createCharacter(CharacterType.MAGE, "Gandalf");
            System.out.println(mageGandalf);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character thiefFrodo = middleEarthCharacterFactory.createCharacter(CharacterType.THIEF, "Frodo");
            System.out.println(thiefFrodo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character warriorAragorn = middleEarthCharacterFactory.createCharacter(CharacterType.WARRIOR, "Aragorn");
            System.out.println(warriorAragorn);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character mageMelisandre = westerosCharacterFactory.createCharacter(CharacterType.MAGE, "Melisandre");
            System.out.println(mageMelisandre);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character thiefOberynMartell = westerosCharacterFactory.createCharacter(CharacterType.THIEF, "Oberyn Martell");
            System.out.println(thiefOberynMartell);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character warriorKhalDrogo = westerosCharacterFactory.createCharacter(CharacterType.WARRIOR, "Khal Drogo");
            System.out.println(warriorKhalDrogo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character invalidWarrior = new Warrior("Invalid Warrior", 8, 3, 3, 3, 4);
            System.out.println(invalidWarrior);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character invalidThief = new Thief("Invalid Thief", 8, 3, 3, 3, 4);
            System.out.println(invalidThief);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Character invalidMage = new Mage("Invalid Mage", 1, 8, 7, 7, 10);
            System.out.println(invalidMage);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
