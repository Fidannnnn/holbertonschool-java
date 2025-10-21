// OrderItem.java
import java.util.Objects;

public class OrderItem {
    private final OrderItemType type;
    private final String name;

    public OrderItem(OrderItemType type, String name) {
        this.type = type;
        this.name = name;
    }

    public OrderItemType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    // Ensure set uniqueness by type+name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem that = (OrderItem) o;
        return type == that.type && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }
}
