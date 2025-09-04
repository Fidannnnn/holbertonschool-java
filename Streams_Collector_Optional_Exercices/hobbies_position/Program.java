import java.util.*;

    public class Program {
            public static void main(String[] args) {
                Person person1 = new Person(1, "John Bannins", "Developer", 23, 3200,
                            List.of("listening to music", "watching soccer", "watching series", "walking"));
          Person person2 = new Person(2, "Derry Collier", "Developer", 45, 8600,
                            List.of("watching soccer", "watching movies"));
          Person person3 = new Person(3, "Mikey Berg", "Product Owner", 51, 11350,
                            List.of("listening to music", "playing soccer", "watching series"));
          Person person4 = new Person(4, "Diana Hayes", "Product Owner", 33, 7400,
                            List.of("playing soccer", "watching movies", "walking"));
          Person person5 = new Person(5, "Ellen Costa", "Product Owner", 51, 12500,
                            List.of("listening to music", "watching soccer", "watching movies"));
          Person person6 = new Person(6, "Jane Doe", "Analyst QA", 42, 5200,
                            List.of("watching soccer", "watching movies"));
          Person person7 = new Person(7, "Haseeb Roche", "Analyst QA", 21, 3200,
                            List.of("watching series", "walking"));
          Person person8 = new Person(8, "Jadene Everett", "Analyst QA", 39, 4860,
                            List.of("watching series"));
          Person person9 = new Person(9, "Andrei Melendez", "Analyst QA", 42, 5330,
                            List.of("listening to music", "watching series", "walking"));
          Person person10 = new Person(10, "Branden Irwin", "Analyst QA", 21, 2800,
                            List.of("playing soccer", "watching series", "walking"));

           List<Person> allPeople = List.of(person1, person2, person3, person4, person5,
               person6, person7, person8, person9, person10);

                    Map<String, TreeSet<String>> people1 = PeopleQuery.getHobbiesByPosition(allPeople);
                    Map<String, TreeSet<String>> people2 = PeopleQuery.getHobbiesByPosition(
                            List.of(person1, person2, person3, person4, person9, person10)
                    );
                    Map<String, TreeSet<String>> people3 = PeopleQuery.getHobbiesByPosition(
                            List.of(person1, person3, person4, person5, person9)
                    );

                    System.out.println(people1);
                    System.out.println();
                    System.out.println(people2);
                    System.out.println();
                    System.out.println(people3);
            }
    }