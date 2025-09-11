public class Program {

    public static void main(String[] args) {

        System.out.println("Testing Addition");
        boolean test = BasicOperationTest.test_addition();
        System.out.println(test);

        System.out.println("Testing Subtraction");
        test = BasicOperationTest.test_subtraction();
        System.out.println(test);

        System.out.println("Testing Multiplication");
        test = BasicOperationTest.test_multiplication();
        System.out.println(test);

        System.out.println("Testing Division");
        test = BasicOperationTest.test_division();
        System.out.println(test);
    }
}