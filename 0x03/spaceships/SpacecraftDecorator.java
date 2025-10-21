// SpacecraftDecorator.java
public class SpacecraftDecorator extends Spacecraft {
    protected Spacecraft spacecraft;

    public SpacecraftDecorator(Spacecraft spacecraft) {
        super(spacecraft.getHealth(), spacecraft.getAttack());
        this.spacecraft = spacecraft;
    }

    @Override
    public int getHealth() {
        return spacecraft.getHealth();
    }

    @Override
    public int getAttack() {
        return spacecraft.getAttack();
    }
}
// Spacecraft spacecraftDecorated