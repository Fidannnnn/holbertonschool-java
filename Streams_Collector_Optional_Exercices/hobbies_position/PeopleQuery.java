import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PeopleQuery {

    private static int positionRank(String s) {
        if ("Product Owner".equals(s)) return 0;
        if ("Analyst QA".equals(s))    return 1;
        if ("Developer".equals(s))     return 2;
        return 3; // unknowns last
    }

    public static Map<String, TreeSet<String>> getHobbiesByPosition(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream().collect(Collectors.groupingBy(
            Person::getPosition,
            () -> new TreeMap<>(Comparator.comparingInt(PeopleQuery::positionRank)),
            Collectors.flatMapping(
                p -> p.getHobbies().stream().map(String::trim),
                Collectors.toCollection(TreeSet::new)
            )
        ));
    }
}
