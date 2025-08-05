public class Manager extends Employee {

    public Manager(double fixedSalary) {
        super(fixedSalary);
    }

    @Override
    public double calculateBonus(Department department) {
        if (department.reachedTarget()) {
            double baseBonus = getFixedSalary() * 0.20;
            double extraBonus = 0.01 * (department.getAchievedTargetValue() - department.getTargetValue());
            return baseBonus + extraBonus;
        } else {
            return 0;
        }
    }
}
