public class Employee {
    private double fixedSalary;

    public Employee(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public double calculateBonus(Department department) {
        // Regular employees: 10% of salary if department reached target
        if (department.reachedTarget()) {
            return fixedSalary * 0.10;
        } else {
            return 0;
        }
    }

    public double calculateTotalSalary(Department department) {
        return fixedSalary + calculateBonus(department);
    }
}
