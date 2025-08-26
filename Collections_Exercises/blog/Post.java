import java.util.Objects;

public class Post implements Comparable<Post> {
    private final Author author;
    private final String title;
    private final String body;
    private final Categories category;

    public Post(Author author, String title, String body, Categories category) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.category = category;
    }

    public Author getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
    public Categories getCategory() { return category; }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post p = (Post) o;
        return Objects.equals(author, p.author) &&
               Objects.equals(title, p.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title);
    }

    @Override
    public int compareTo(Post other) {
        int byTitle = this.title.compareTo(other.title);
        if (byTitle != 0) return byTitle;
        return this.author.toString().compareTo(other.author.toString());
    }
}
