import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.math.RoundingMode;

public class Order {
    private double discountPercentage;
    private ItemOrder[] items;

    public Order(double discountPercentage, ItemOrder[] items) {
        this.discountPercentage = discountPercentage;
        this.items = items != null ? items : new ItemOrder[0];
    }

    public double calculateTotal() {
        double totalProducts = 0.0;
        for (ItemOrder item : items) {
            if (item != null && item.getProduct() != null) {
                totalProducts += item.getProduct().getNetPrice() * item.getQuantity();
            }
        }
        return totalProducts - (totalProducts * discountPercentage / 100.0);
    }

    public void presentOrderSummary() {
        // Decimal format with comma decimal separator and proper rounding
        DecimalFormat df = new DecimalFormat("#0.00",
                DecimalFormatSymbols.getInstance(Locale.FRANCE));
        df.setRoundingMode(RoundingMode.HALF_UP);

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
