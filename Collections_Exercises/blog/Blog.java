import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Blog {
    private final List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        posts.add(post);
    }

    // Return authors sorted by name
    public Set<String> getAllAuthors() {
        TreeSet<String> authors = new TreeSet<>();
        for (Post p : posts) {
            authors.add(p.getAuthor());
        }
        return authors;
    }

    // Return category -> count, sorted by category name
    public Map<String, Integer> getCountByCategory() {
        TreeMap<String, Integer> counts = new TreeMap<>();
        for (Post p : posts) {
            String cat = p.getCategory();
            counts.put(cat, counts.getOrDefault(cat, 0) + 1);
        }
        return counts;
    }
}
