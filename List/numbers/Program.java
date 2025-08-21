import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();

        ManipulateArrayNumbers.addNumber(numbers, 1);
        ManipulateArrayNumbers.addNumber(numbers, 3);
        ManipulateArrayNumbers.addNumber(numbers, 6);
        ManipulateArrayNumbers.addNumber(numbers, 9);

        System.out.println(numbers);

        try {
            ManipulateArrayNumbers.addNumber(numbers, 9);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        ManipulateArrayNumbers.removeNumber(numbers, 3);
        ManipulateArrayNumbers.removeNumber(numbers, 9);

        System.out.println(numbers);

        try {
            // FIXED: class name is ManipulateArrayNumbers (not ...Numeros / ...Numeros)
            ManipulateArrayNumbers.removeNumber(numbers, 9);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

        ManipulateArrayNumbers.replaceNumber(numbers, 3, 5);

        System.out.println(numbers);

        ManipulateArrayNumbers.replaceNumber(numbers, 5, 3);

        System.out.println(numbers);
    }
}
