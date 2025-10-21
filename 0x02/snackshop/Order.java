// Order.java
import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Order {
    private HashSet<OrderItem> itemsInBox = new HashSet<>();
    private HashSet<OrderItem> itemsOutOfBox = new HashSet<>();

    public void addItemInBox(OrderItem item) {
        // Keep only one of each OrderItemType inside the box
        itemsInBox.removeIf(i -> i.getType() == item.getType());
        itemsInBox.add(item);
    }

    public void addItemOutOfBox(OrderItem item) {
        // Keep only one of each OrderItemType outside the box
        itemsOutOfBox.removeIf(i -> i.getType() == item.getType());
        itemsOutOfBox.add(item);
    }

    private static final Comparator<OrderItem> OUT_COMPARATOR =
        Comparator.comparingInt(i -> orderIndexOut(i.getType()));
    private static final Comparator<OrderItem> IN_COMPARATOR =
        Comparator.comparingInt(i -> orderIndexIn(i.getType()));

    // For "Out of the Box" we expect only DRINK
    private static int orderIndexOut(OrderItemType t) {
        switch (t) {
            case DRINK: return 0;
            default: return 99;
        }
    }

    // For "In the Box" we want: TOY, FRIES, SNACK (to match the sample)
    private static int orderIndexIn(OrderItemType t) {
        switch (t) {
            case TOY:   return 0;
            case FRIES: return 1;
            case SNACK: return 2;
            default:    return 99;
        }
    }

    @Override
    public String toString() {
        String outSection =
            itemsOutOfBox.stream()
                .sorted(OUT_COMPARATOR)
                .map(i -> "\t\t\t- " + i.getType() + " " + i.getName())
                .collect(Collectors.joining("\n"));

        String inSection =
            itemsInBox.stream()
                .sorted(IN_COMPARATOR)
                .map(i -> "\t\t\t- " + i.getType() + " " + i.getName())
                .collect(Collectors.joining("\n"));

        StringBuilder sb = new StringBuilder();
        sb.append("\t\tOut of the Box:\n");
        if (!outSection.isEmpty()) {
            sb.append(outSection).append("\n");
        }
        sb.append("\t\tIn the Box:\n");
        if (!inSection.isEmpty()) {
            sb.append(inSection).append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }
}
