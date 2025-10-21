// Program.java
public class Program {
    public static void main(String[] args) {
        OrderBuilder builder1 = new OrderBuilder();

        builder1.setFries(FriesSize.LARGE);
        builder1.setDrink(DrinkType.COKE);
        builder1.setToy(ToyType.CAR);
        builder1.setSnack(SnackType.CHEESEBURGER);

        Order order1 = builder1.build();

        System.out.println(order1);

        OrderBuilder builder2 = new OrderBuilder();

        builder2.setFries(FriesSize.SMALL);
        builder2.setDrink(DrinkType.WATER);

        Order order2 = builder2.build();

        System.out.println(order2);
    }
}
