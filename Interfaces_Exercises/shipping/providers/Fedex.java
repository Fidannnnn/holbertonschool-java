package providers;

public class Fedex implements ShippingProvider {
    @Override
    public Shipping calculateShipping(double weightGrams, double value) {
        double weightKg = weightGrams / 1000.0;
        double rate = (weightKg > 1.0) ? 0.10 : 0.05; // >1kg => 10%, else 5%
        return new Shipping(value * rate, getShippingProviderType());
    }

    @Override
    public ShippingProviderType getShippingProviderType() {
        return ShippingProviderType.FEDEX;
    }
}
