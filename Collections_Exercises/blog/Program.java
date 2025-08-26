import java.util.*;

    public class Program {
        public static void main(String[] args) {
            Blog blog1 = new Blog();

            Post post1 = new Post("John Bannons", 
                "How to implement Terraform",
                "Implementing IaC with Terraform bla bla bla",
                "DevOps");

            Post post2 = new Post("John Bannons", 
                "Working with the Set interface in Java",
                "The Set interface is implemented by several collections in Java bla bla bla",
                "Development");            

            Post post3 = new Post("Jane Doe", 
                "Publishing GitLab pipelines",
                "To publish pipelines in GitLab bla bla bla",
                "DevOps");            

            Post post4 = new Post("Jane Doe", 
                "Azure Service Bus where to start",
                "First, it's necessary to understand that bla bla bla",
                "DevOps");

            Post post5 = new Post("Jane Doe", 
                "TDD made simple",
                "The TDD software development process bla bla bla",
                "Development");       

            blog1.addPost(post1);
            blog1.addPost(post2);
            blog1.addPost(post3);
            blog1.addPost(post4);
            blog1.addPost(post5);

            Set<String> author = blog1.getAllAuthors();

            System.out.println(author);

            Map<String, Integer> counting = blog1.getCountByCategory();

            System.out.println(counting);
        }
    }