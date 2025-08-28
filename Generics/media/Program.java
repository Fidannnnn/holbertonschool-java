import java.util.*;
    public class Program {
        public static void main(String[] args) {
            Book book1 = new Book("The Great Gatsby", 1);
            Book book2 = new Book("The Lord of the Rings", 3);
            Book book3 = new Book("Harry Potter and the Philosopher's Stone", 1);

            Video video1 = new Video("Learning Java Generics", 25);
            Video video2 = new Video("Introducing Wildcards in Java Generics", 25);

            Newspaper newspaper1 = new Newspaper("The New York Times", 130);
            Newspaper newspaper2 = new Newspaper("The Wall Street Journal", 113);

            Library<Book> bookLibrary = new Library<>();
            bookLibrary.addMedia(book1);
            bookLibrary.addMedia(book2);
            bookLibrary.addMedia(book3);

            System.out.println(bookLibrary.getMediaList());

            Library<Media> mediaLibrary = new Library<>();
            mediaLibrary.addMedia(book1);
            mediaLibrary.addMedia(video1);
            mediaLibrary.addMedia(video2);
            mediaLibrary.addMedia(newspaper2);

            System.out.println(mediaLibrary.getMediaList());
        }
    }