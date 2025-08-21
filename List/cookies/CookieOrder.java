public class CookieOrder {
    private String flavor;
    private int boxQuantity;

    public CookieOrder(String flavor, int boxQuantity) {
        this.flavor = flavor;
        this.boxQuantity = boxQuantity;
    }

    public String getFlavor() {
        return flavor;
    }

    public int getBoxQuantity() {
        return boxQuantity;
    }
}
