import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Order {
    private double discountPercentage;
    private ItemOrder[] items;

    public Order(double discountPercentage, ItemOrder[] items) {
        this.discountPercentage = discountPercentage;
        this.items = items;
    }

    public double calculateTotal() {
        double total = 0.0;
        if (items != null) {
            for (ItemOrder item : items) {
                if (item != null && item.getProduct() != null) {
                    total += item.getProduct().getNetPrice() * item.getQuantity();
                }
            }
        }
        total -= total * discountPercentage / 100.0;
        return total;
    }

    public void presentOrderSummary() {
        DecimalFormat df = new DecimalFormat("#0.00",
                DecimalFormatSymbols.getInstance(Locale.FRANCE));

        double totalProducts = 0.0;

        System.out.println("------- ORDER SUMMARY -------");

        for (ItemOrder item : items) {
            if (item != null && item.getProduct() != null) {
                String type = item.getProduct().getClass().getSimpleName();
                String title = item.getProduct().getTitle();
                double price = item.getProduct().getNetPrice();
                int qty = item.getQuantity();
                double lineTotal = price * qty;

                totalProducts += lineTotal;

                System.out.printf("Type: %s  Title: %s  Price: %s  Quant: %d  Total: %s%n",
                        type, title, df.format(price), qty, df.format(lineTotal));
            }
        }

        System.out.println("----------------------------");
        double discountAmount = totalProducts * discountPercentage / 100.0;
        System.out.println("DISCOUNT: " + df.format(discountAmount));
        System.out.println("TOTAL PRODUCTS: " + df.format(totalProducts));
        System.out.println("----------------------------");
        System.out.println("TOTAL ORDER: " + df.format(totalProducts - discountAmount));
        System.out.println("----------------------------");
    }

}
