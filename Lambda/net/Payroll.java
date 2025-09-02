public class Payroll {
    public static double calculateNet(Employee employee, SalaryCalculator calculator) {
        return calculator.calculate(employee.getSalary());
    }
}
