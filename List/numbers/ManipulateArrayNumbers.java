import java.util.List;

public class ManipulateArrayNumbers {

    // Returns index of number in list; -1 if not found
    public static int findNumberPosition(List<Integer> list, int number) {
        return list.indexOf(number);
    }

    // Adds number if not present; otherwise throws
    public static void addNumber(List<Integer> list, int number) {
        int pos = findNumberPosition(list, number);
        if (pos != -1) {
            throw new IllegalArgumentException("Number already in the list");
        }
        list.add(number);
    }

    // Removes number if present; otherwise throws
    public static void removeNumber(List<Integer> list, int number) {
        int pos = findNumberPosition(list, number);
        if (pos == -1) {
            throw new IllegalArgumentException("Number not found in the list");
        }
        list.remove(pos);
    }

    // If numberToReplace exists, replace it with replacementNumber; else just add replacementNumber
    public static void replaceNumber(List<Integer> list, int numberToReplace, int replacementNumber) {
        int pos = findNumberPosition(list, numberToReplace);
        if (pos == -1) {
            list.add(replacementNumber);
        } else {
            list.set(pos, replacementNumber);
        }
    }
}
