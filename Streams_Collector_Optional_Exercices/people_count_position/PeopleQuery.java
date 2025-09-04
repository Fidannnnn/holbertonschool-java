import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PeopleQuery {

    private static final java.util.Comparator<String> POSITION_ORDER =
        java.util.Comparator.comparingInt((String s) -> {
            switch (s) {
                case "Product Owner": return 0;
                case "Analyst QA":    return 1;
                case "Developer":     return 2;
                default:              return 3; 
            }
        });

    public static Map<String, Long> getPeopleCountByPosition(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream().collect(Collectors.groupingBy(
                Person::getPosition,
                () -> new TreeMap<>(POSITION_ORDER), 
                Collectors.counting()
        ));
    }
}
