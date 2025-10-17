public class SalaryService {

    private SalaryCalculatorService calculator = SalaryCalculatorService.getSalaryCalculatorService();

    public double calculate(double grossSalary, double discountValue, double salesValue, double commissionPercentage) {
        return calculator.calculateNetSalary(grossSalary, discountValue, salesValue, commissionPercentage);
    }

    public String getUuid() {
        return calculator.uuid.toString();
    }
}
