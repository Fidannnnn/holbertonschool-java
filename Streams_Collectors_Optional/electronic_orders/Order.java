import java.util.List;

public class Order {
    private final int code;
    private final List<Product> products;
    private final Client client;

    public Order(int code, List<Product> products, Client client) {
        this.code = code;
        this.products = products;
        this.client = client;
    }

    public int getCode() { return code; }
    public List<Product> getProducts() { return products; }
    public Client getClient() { return client; }

    @Override
    public String toString() {
        return String.format("[%d] %s", code, client.getName());
    }
}
