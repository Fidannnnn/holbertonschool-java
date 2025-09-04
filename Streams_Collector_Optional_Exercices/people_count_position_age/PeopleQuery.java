import java.util.*;
import java.util.stream.Collectors;

public class PeopleQuery {

    private static int positionRank(String s) {
        if ("Product Owner".equals(s)) return 0;
        if ("Analyst QA".equals(s))    return 1;
        if ("Developer".equals(s))     return 2;
        return 3;
    }

    public static Map<String, Map<Integer, Long>> getPeopleCountByPositionAndAge(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream().collect(
            Collectors.groupingBy(
                Person::getPosition,
                () -> new TreeMap<>(Comparator.comparingInt(PeopleQuery::positionRank)), // outer order
                Collectors.groupingBy(
                    Person::getAge,
                    TreeMap::new,              
                    Collectors.counting()
                )
            )
        );
    }
}
