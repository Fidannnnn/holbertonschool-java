public interface Storable<T> {
    void addToInventory(String name, T value);
    T getFromInventory(String name);
}
