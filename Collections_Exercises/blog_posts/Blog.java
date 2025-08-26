import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Blog {
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        for (Post p : posts) {
            if (p.getAuthor().equals(post.getAuthor())
                    && p.getTitle().equals(post.getTitle())) {
                throw new RuntimeException("Post already exists");
            }
        }
        posts.add(post);
    }

    public Set<Author> getAllAuthors() {
        TreeSet<Author> authors = new TreeSet<>();
        for (Post p : posts) {
            authors.add(p.getAuthor());
        }
        return authors;
    }

    public Map<Categories, Integer> getCountByCategory() {
        EnumMap<Categories, Integer> counts = new EnumMap<>(Categories.class);
        for (Post p : posts) {
            Categories c = p.getCategory();
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }

    public Set<Post> getPostsByAuthor(Author author) {
        TreeSet<Post> out = new TreeSet<>();
        for (Post p : posts) {
            if (p.getAuthor().equals(author)) {
                out.add(p);
            }
        }
        return out;
    }

    public Set<Post> getPostsByCategory(Categories category) {
        TreeSet<Post> out = new TreeSet<>();
        for (Post p : posts) {
            if (p.getCategory() == category) {
                out.add(p);
            }
        }
        return out;
    }

    public Map<Categories, Set<Post>> getAllPostsByCategories() {
        EnumMap<Categories, Set<Post>> map = new EnumMap<>(Categories.class);
        for (Post p : posts) {
            map.computeIfAbsent(p.getCategory(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }

    public Map<Author, Set<Post>> getAllPostsByAuthor() {
        TreeMap<Author, Set<Post>> map = new TreeMap<>();
        for (Post p : posts) {
            map.computeIfAbsent(p.getAuthor(), k -> new TreeSet<>()).add(p);
        }
        return map;
    }
}
