import java.util.Locale;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);

        Product product1 = new Product(129.99, "Mouse Gamer");

        System.out.printf("%s - %.2f - %.2f\n",
                product1.getName(),
                product1.getPrice(),
                product1.priceWithMarkup.get());

        product1.updateMarkup.accept(15d);

        System.out.printf("%s - %.2f - %.2f\n",
                product1.getName(),
                product1.getPrice(),
                product1.priceWithMarkup.get());
    }
}
