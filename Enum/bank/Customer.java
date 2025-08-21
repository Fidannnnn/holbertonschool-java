import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addTransaction(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public List<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double amount) {
        transactions.add(amount); // deposits only (per spec)
    }
}
