// NanoBotsDecorator.java
public class NanoBotsDecorator extends SpacecraftDecorator {
    public NanoBotsDecorator(Spacecraft spacecraft) {
        super(spacecraft);
    }

    @Override
    public int getAttack() {
        return spacecraft.getAttack() + 25;
    }
}
