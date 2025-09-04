import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleQuery {
    public static TreeMap<String, TreeSet<Person>> getPeopleGroupedByPositionInReverseOrder(List<Person> people) {
        return people.stream().collect(
            Collectors.groupingBy(
                Person::getPosition,
                () -> new TreeMap<>(Comparator.reverseOrder()),      // keys (positions) in reverse order
                Collectors.toCollection(TreeSet::new)                 // values as sorted TreeSet<Person>
            )
        );
    }
}
