import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PeopleQuery {

    public static Map<String, Double> getAverageSalaryByPosition(List<Person> people) {
        if (people == null) return Map.of();
        return people.stream()
                .collect(Collectors.groupingBy(
                        Person::getPosition,
                        Collectors.averagingDouble(Person::getSalary)
                ));
    }
}
