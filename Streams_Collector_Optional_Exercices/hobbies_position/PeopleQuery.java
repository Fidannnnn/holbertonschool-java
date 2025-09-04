import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeopleQuery {

    public static Map<String, TreeSet<String>> getHobbiesByPosition(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
            .collect(Collectors.groupingBy(
                Person::getPosition,
                Collectors.flatMapping(
                    p -> p.getHobbies().stream().map(String::trim), // trim to avoid leading spaces
                    Collectors.toCollection(TreeSet::new)            // unique + sorted
                )
            ));
    }
}
