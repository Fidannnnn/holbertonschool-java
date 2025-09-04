import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleQuery {

    public static Map<String, Long> getPeopleCountByPosition(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .collect(Collectors.groupingBy(Person::getPosition, Collectors.counting()));
    }

    public static Map<String, Map<Integer, Long>> getPeopleCountByPositionAndAge(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        )
                ));
    }
}
