public class BasicOperationTest {

    public static boolean test_addition() {
        BasicOperation op = new BasicOperation();
        double result = op.add(5, 3);
        double expected = 8;
        return result == expected;
    }

    public static boolean test_subtraction() {
        BasicOperation op = new BasicOperation();
        double result = op.subtract(5, 3);
        double expected = 2;
        return result == expected;
    }

    public static boolean test_multiplication() {
        BasicOperation op = new BasicOperation();
        double result = op.multiply(5, 3);
        double expected = 15;
        return result == expected;
    }

    public static boolean test_division() {
        BasicOperation op = new BasicOperation();
        double result = op.divide(9, 3);
        double expected = 3;
        return result == expected;
    }
}
