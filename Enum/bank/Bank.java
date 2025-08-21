import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public Branch findBranch(String branchName) {
        for (Branch b : branches) {
            if (b.getName().equals(branchName)) return b;
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) != null) return false;
        branches.add(new Branch(branchName));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch b = findBranch(branchName);
        if (b == null) return false;
        return b.newCustomer(customerName, initialTransaction);
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch b = findBranch(branchName);
        if (b == null) return false;
        return b.addCustomerTransaction(customerName, amount);
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch b = findBranch(branchName);
        if (b == null) return false;

        List<Customer> cs = b.getCustomers();
        for (int i = 0; i < cs.size(); i++) {
            Customer c = cs.get(i);
            int idx = i + 1;
            System.out.println("Client: " + c.getName() + " [" + idx + "]");
            if (printTransactions) {
                List<Double> ts = c.getTransactions();
                for (int t = 0; t < ts.size(); t++) {
                    int tIdx = t + 1;
                    System.out.println("  [" + tIdx + "] value " + ts.get(t));
                }
            }
        }
        return true;
    }
}
