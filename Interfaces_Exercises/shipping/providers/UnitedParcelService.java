package providers;

public class UnitedParcelService implements ShippingProvider {
    @Override
    public Shipping calculateShipping(double weightGrams, double value) {
        double weightKg = weightGrams / 1000.0;
        double rate = (weightKg > 2.0) ? 0.07 : 0.045; // >2kg => 7%, else 4.5%
        return new Shipping(value * rate, getShippingProviderType());
    }

    @Override
    public ShippingProviderType getShippingProviderType() {
        return ShippingProviderType.UPS;
    }
}
