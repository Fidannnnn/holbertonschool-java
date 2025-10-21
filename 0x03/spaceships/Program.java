// Program.java
public class Program {
    public static void main(String[] args) {
        Spacecraft spacecraft = new Spacecraft(100, 50);
        System.out.println(spacecraft);

        Spacecraft armoredSpacecraft = new ArmorDecorator(new Spacecraft(120, 30));
        System.out.println(armoredSpacecraft);

        Spacecraft armoredLaserSpacecraft = new LaserDecorator(new ArmorDecorator(new Spacecraft(60, 20)));
        System.out.println(armoredLaserSpacecraft);        

        Spacecraft armoredNanoBotsSpacecraft = new NanoBotsDecorator(new ArmorDecorator(new Spacecraft(100, 100)));
        System.out.println(armoredNanoBotsSpacecraft);       

        Spacecraft laserNanoBotsSpacecraft = new NanoBotsDecorator(new LaserDecorator(new Spacecraft(75, 30)));
        System.out.println(laserNanoBotsSpacecraft);      

        Spacecraft fullyDecoratedSpacecraft = new ExtraCannonDecorator(
            new ArmorDecorator(
                new NanoBotsDecorator(
                    new LaserDecorator(new Spacecraft(50, 50))
                )
            )
        );
        System.out.println(fullyDecoratedSpacecraft);
    }
}
