// OrderBuilder.java
public class OrderBuilder extends OrderAbstractBuilder {
    private final Order order = new Order();

    @Override
    public void setSnack(SnackType type) {
        order.addItemInBox(new OrderItem(OrderItemType.SNACK, type.name()));
    }

    @Override
    public void setFries(FriesSize size) {
        order.addItemInBox(new OrderItem(OrderItemType.FRIES, size.name()));
    }

    @Override
    public void setToy(ToyType type) {
        order.addItemInBox(new OrderItem(OrderItemType.TOY, type.name()));
    }

    @Override
    public void setDrink(DrinkType type) {
        order.addItemOutOfBox(new OrderItem(OrderItemType.DRINK, type.name()));
    }

    public Order build() {
        return order;
    }
}
