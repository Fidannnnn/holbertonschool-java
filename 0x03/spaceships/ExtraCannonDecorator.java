// ExtraCannonDecorator.java
public class ExtraCannonDecorator extends SpacecraftDecorator {
    public ExtraCannonDecorator(Spacecraft spacecraft) {
        super(spacecraft);
    }

    @Override
    public int getAttack() {
        return spacecraft.getAttack() + 75;
    }
}
