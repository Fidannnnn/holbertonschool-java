import java.util.*;

    public class Program {
        public static void main(String[] args) {
            Blog blog1 = new Blog();

            Author author1 = new Author("John", "Bannons");
            Author author2 = new Author("Jane", "Doe");
            Author author3 = new Author("Peter", "Dirkly");

            Post post1 = new Post(author1, 
                "How to Implement Terraform",
                "Implementing IaC with Terraform bla bla bla",
                Categories.DEVOPS);

            Post post2 = new Post(author1, 
                "Working with the Set Interface in Java",
                "The Set interface is implemented by several collections in Java bla bla bla",
                Categories.DEVELOPMENT);            

            Post post3 = new Post(author2, 
               "Publishing GitLab Pipelines",
                "To publish pipelines in GitLab bla bla bla",
                Categories.DEVOPS);            

            Post post4 = new Post(author2, 
                "Azure Service Bus Where to Start",
                "First, it's necessary to understand that bla bla bla",
                Categories.DEVOPS);

            Post post5 = new Post(author2, 
                "TDD Made Simple",
                "The TDD software development process bla bla bla",
                Categories.DEVELOPMENT);       

            Post post6 = new Post(author3,
                "Hadoop: The Tool That Will Ease Your Data Processing",
                "Hadoop is a tool bla bla bla",
                Categories.DATA_SCIENCE);

            Post post7 = new Post(author3,
                "Hadoop: The Tool That Will Ease Your Data Processing",
                "The Hadoop tool bla bla bla",
                Categories.DATA_SCIENCE);

            blog1.addPost(post1);
            blog1.addPost(post2);
            blog1.addPost(post3);
            blog1.addPost(post4);
            blog1.addPost(post5);
            blog1.addPost(post6);

            try {
                blog1.addPost(post7);
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            Set<Author> authors = blog1.getAllAuthors();

            System.out.println(authors);

            Map<Categories, Integer> counting = blog1.getCountByCategory();

            System.out.println(counting);

            Set<Post> postsDevOps = blog1.getPostsByCategory(Categories.DEVOPS);

            System.out.println(postsDevOps);

            Set<Post> postsDev = blog1.getPostsByCategory(Categories.DESENVOLVIMENTO);

            System.out.println(postsDev); 

            Set<Post> postsData = blog1.getPostsByCategory(Categories.DATA_SCIENCE);

            System.out.println(postsData); 

            Set<Post> postsJaneDoe = blog1.getPostsByAuthor(new Author("Jane", "Doe"));

            System.out.println(postsJaneDoe);      

            Map<Categories, Set<Post>> postsByCategories = blog1.getAllPostsByCategories();

            System.out.println(postsByCategories);

            Map<Author, Set<Post>> postsByAuthor = blog1.getAllPostsByAuthor();

            System.out.println(postsByAuthor);        
        }
    }