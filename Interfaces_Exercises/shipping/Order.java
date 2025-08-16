import providers.Shipping;

public class Order {
    private final int code;
    // weight in GRAMS (as per spec)
    private final int weight;
    private final double total;
    private Shipping shipping;

    public Order(int code, int weight, double total) {
        this.code = code;
        this.weight = weight; // grams
        this.total = total;
    }

    public int getCode() { return code; }
    public int getWeight() { return weight; } // grams
    public double getTotal() { return total; }

    public Shipping getShipping() { return shipping; }
    public void setShipping(Shipping shipping) { this.shipping = shipping; }
}
