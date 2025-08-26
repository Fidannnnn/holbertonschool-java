import java.util.Objects;

public class Author implements Comparable<Author> {
    public String name;
    public String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author a = (Author) o;
        return Objects.equals(name, a.name) &&
               Objects.equals(surname, a.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public int compareTo(Author other) {
        return this.toString().compareTo(other.toString());
    }
}
