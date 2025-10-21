// ArmorDecorator.java
public class ArmorDecorator extends SpacecraftDecorator {
    public ArmorDecorator(Spacecraft spacecraft) {
        super(spacecraft);
    }

    @Override
    public int getHealth() {
        return spacecraft.getHealth() + 150;
    }
}
