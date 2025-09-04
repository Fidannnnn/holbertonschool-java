import java.util.*;

    public class Program {
        public static void main(String[] args) {
            Person person1 = new Person(1, "John Bannins", "Developer", 23, 3200);
            Person person2 = new Person(2, "Derry Collier", "Developer", 45, 8600);
            Person person3 = new Person(3, "Mikey Berg", "Product Owner", 51, 11350);
            Person person4 = new Person(4, "Diana Hayes", "Product Owner", 33, 7400);
            Person person5 = new Person(5, "Ellen Costa", "Product Owner", 51, 12500);
            Person person6 = new Person(6, "Jane Doe", "Analyst QA", 42, 5200);
            Person person7 = new Person(7, "Haseeb Roche", "Analyst QA", 21, 3200);
            Person person8 = new Person(8, "Jadene Everett", "Analyst QA", 39, 4860);
            Person person9 = new Person(9, "Andrei Melendez", "Analyst QA", 42, 5330);
            Person person10 = new Person(10, "Branden Irwin", "Analyst QA", 21, 2800);

            List<Person> allPeople = List.of(person1, person2, person3, person4, person5,
                person6, person7, person8, person9, person10);

            Map<String, Long> people1 = PeopleQuery.getPeopleCountByPosition(allPeople);
            Map<String, Long> people2 = PeopleQuery.getPeopleCountByPosition(
                List.of(person1, person2, person3, person4, person9, person10)
            );
            Map<String, Long> people3 = PeopleQuery.getPeopleCountByPosition(
                List.of(person1, person3, person4, person5, person9)
            );

            System.out.println(people1);
            System.out.println();
            System.out.println(people2);
            System.out.println();
            System.out.println(people3);
        }
    }