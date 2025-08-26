public class Post {
    private final String author;
    private final String title;
    private final String body;
    private final String category;

    public Post(String author, String title, String body, String category) {
        this.author = author;
        this.title = title;
        this.body = body;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public String getCategory() {
        return category;
    }
}
