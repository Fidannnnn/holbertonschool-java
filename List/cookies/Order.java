import java.util.ArrayList;
import java.util.Iterator;

public class Order {
    private ArrayList<CookieOrder> cookies;

    public Order() {
        this.cookies = new ArrayList<>();
    }

    public void addCookieOrder(CookieOrder order) {
        this.cookies.add(order);
    }

    public int getTotalBoxes() {
        int total = 0;
        for (CookieOrder c : cookies) {
            total += c.getBoxQuantity();
        }
        return total;
    }

    public int removeFlavor(String flavor) {
        int removed = 0;
        Iterator<CookieOrder> it = cookies.iterator();
        while (it.hasNext()) {
            CookieOrder c = it.next();
            if (c.getFlavor().equals(flavor)) {
                removed += c.getBoxQuantity();
                it.remove();
            }
        }
        return removed;
    }
}
