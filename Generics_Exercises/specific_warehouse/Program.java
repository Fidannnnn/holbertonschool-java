 import java.util.*;

    public class Program {
        public static void main(String[] args) {
            Food food1 = new Food("rice", 100, 15.9);
            Food food2 = new Food("beans", 80, 23.0);
            Food food3 = new Food("peanut", 165, 7.5);

            Electronic electronic1 = new Electronic("Smart TV LED 32 HD LG", 1452.55);
            Electronic electronic2 = new Electronic("Nintendo Switch", 2990);

            ElectronicWarehouse warehouse1 = new ElectronicWarehouse();
            warehouse1.addToInventory("TV LG", electronic1);
            warehouse1.addToInventory("Switch", electronic2);

            Electronic searchedElectronic1 = warehouse1.getFromInventory("Switch");

            System.out.println(searchedElectronic1);

            FoodWarehouse warehouse2 = new FoodWarehouse();
            warehouse2.addToInventory("beans", food2);
            warehouse2.addToInventory("peanut", food3);

            Food searchedFood1 = warehouse2.getFromInventory("beans");   

            System.out.println(searchedFood1);
        }
    }