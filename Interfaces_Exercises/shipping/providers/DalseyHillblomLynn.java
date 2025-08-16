package providers;

public class DalseyHillblomLynn implements ShippingProvider {
    @Override
    public Shipping calculateShipping(double weightGrams, double value) {
        double weightKg = weightGrams / 1000.0;
        double rate = (weightKg > 5.0) ? 0.12 : 0.04; // >5kg => 12%, else 4%
        return new Shipping(value * rate, getShippingProviderType());
    }

    @Override
    public ShippingProviderType getShippingProviderType() {
        return ShippingProviderType.DHL;
    }
}
