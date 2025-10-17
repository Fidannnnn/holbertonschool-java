import java.util.UUID;

public class SalaryCalculatorService {

    // Singleton instance
    private static SalaryCalculatorService instance;

    // Public UUID for verification
    public UUID uuid = UUID.randomUUID();

    // Private constructor
    private SalaryCalculatorService() { }

    // Factory method for singleton
    public static SalaryCalculatorService getSalaryCalculatorService() {
        if (instance == null) {
            instance = new SalaryCalculatorService();
        }
        return instance;
    }

    // Salary calculation logic
    public double calculateNetSalary(double grossSalary, double discountValue,
                                     double salesValue, double commissionPercentage) {
        return grossSalary - discountValue + (salesValue * (commissionPercentage / 100));
    }
}
