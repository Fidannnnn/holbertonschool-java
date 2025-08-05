import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Program {
    public static void main(String[] args) {
        // Create decimal format to use comma as decimal separator
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        Department engineeringDepartment = new Department(1000, 1100);
        Department documentationDepartment = new Department(1000, 800);

        Employee engineeringEmployee1 = new Employee(2300);
        Employee engineeringEmployee2 = new Employee(3650);
        Manager engineeringManager = new Manager(5800);

        Employee documentationEmployee1 = new Employee(2500);
        Employee documentationEmployee2 = new Employee(3000);
        Manager documentationManager = new Manager(4980);

        // Engineering Department
        System.out.printf("Fixed Salary: %s - Total Salary: %s - Bonus Amount: %s%n",
                df.format(engineeringEmployee1.getFixedSalary()),
                df.format(engineeringEmployee1.calculateTotalSalary(engineeringDepartment)),
                df.format(engineeringEmployee1.calculateBonus(engineeringDepartment)));

        System.out.printf("Fixed Salary: %s - Total Salary: %s - Bonus Amount: %s%n",
                df.format(engineeringEmployee2.getFixedSalary()),
                df.format(engineeringEmployee2.calculateTotalSalary(engineeringDepartment)),
                df.format(engineeringEmployee2.calculateBonus(engineeringDepartment)));

        System.out.printf("Fixed Salary: %s - Total Salary: %s - Bonus Amount: %s%n",
                df.format(engineeringManager.getFixedSalary()),
                df.format(engineeringManager.calculateTotalSalary(engineeringDepartment)),
                df.format(engineeringManager.calculateBonus(engineeringDepartment)));

        // Documentation Department
        System.out.printf("Fixed Salary: %s - Total Salary: %s - Bonus Amount: %s%n",
                df.format(documentationEmployee1.getFixedSalary()),
                df.format(documentationEmployee1.calculateTotalSalary(documentationDepartment)),
                df.format(documentationEmployee1.calculateBonus(documentationDepartment)));

        System.out.printf("Fixed Salary: %s - Total Salary: %s - Bonus Amount: %s%n",
                df.format(documentationEmployee2.getFixedSalary()),
                df.format(documentationEmployee2.calculateTotalSalary(documentationDepartment)),
                df.format(documentationEmployee2.calculateBonus(documentationDepartment)));

        System.out.printf("Fixed Salary: %s - Total Salary: %s - Bonus Amount: %s%n",
                df.format(documentationManager.getFixedSalary()),
                df.format(documentationManager.calculateTotalSalary(documentationDepartment)),
                df.format(documentationManager.calculateBonus(documentationDepartment)));
    }
}
