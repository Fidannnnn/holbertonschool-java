import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) != null) return false;
        customers.add(new Customer(customerName, initialTransaction));
        return true;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer c = findCustomer(customerName);
        if (c == null) return false;
        c.addTransaction(amount);
        return true;
    }

    public Customer findCustomer(String customerName) {
        for (Customer c : customers) {
            if (c.getName().equals(customerName)) return c;
        }
        return null;
    }
}
