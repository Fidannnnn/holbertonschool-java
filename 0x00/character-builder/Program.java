public class Program {
    public static void main(String[] args) {
        Director director = new Director();

        WarriorBuilder warriorBuilder = new WarriorBuilder();
        director.buildWarrior(warriorBuilder);

        MageBuilder mageBuilder = new MageBuilder();
        director.buildMage(mageBuilder);

        ThiefBuilder thiefBuilder = new ThiefBuilder();
        director.buildThief(thiefBuilder);

        try {
            Mage mage = mageBuilder.build();
            System.out.println(mage);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Thief thief = thiefBuilder.build();
            System.out.println(thief);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            Warrior warrior = warriorBuilder.build();
            System.out.println(warrior);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
