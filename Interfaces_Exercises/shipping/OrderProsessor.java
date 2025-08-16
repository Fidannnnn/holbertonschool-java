import providers.Shipping;
import providers.ShippingProvider;

public class OrderProcessor {
    private final ShippingProvider shippingProvider;

    public OrderProcessor(ShippingProvider shippingProvider) {
        this.shippingProvider = shippingProvider;
    }

    public void process(Order order) {
        // weight is in grams; providers will handle conversion/logic
        Shipping shipping = shippingProvider.calculateShipping(order.getWeight(), order.getTotal());
        order.setShipping(shipping);
    }
}
