import java.util.HashSet;
import java.util.TreeSet;

public class DuplicatedNumbers {
    public static TreeSet<Integer> isFind(int[] numbers) {
        HashSet<Integer> seen = new HashSet<>();
        TreeSet<Integer> duplicates = new TreeSet<>();

        for (int num : numbers) {
            // If already seen, add to duplicates
            if (!seen.add(num)) {
                duplicates.add(num);
            }
        }

        return duplicates;
    }
}
