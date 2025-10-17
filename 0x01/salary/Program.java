public class Program {
    public static void main(String[] args) {
        SalaryService salaryService1 = new SalaryService();
        SalaryService salaryService2 = new SalaryService();

        double salaryValue1 = salaryService1.calculate(1200, 150, 3000, 10);
        double salaryValue2 = salaryService2.calculate(2500, 350, 10000, 15);

        System.out.printf("Salary 1: %.2f\n", salaryValue1);
        System.out.printf("UUID 1: %s\n\n", salaryService1.getUuid());

        System.out.printf("Salary 2: %.2f\n", salaryValue2);
        System.out.printf("UUID 2: %s\n", salaryService2.getUuid());
    }
}
