public class CustomerTest {

    public static void main(String[] args) {

            String url = "jdbc:sqlite:sqlite_database_marco_2022.db";

            // 1) Creating the database
            CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
            customerDAOImpl.connect(url);

            // 2) Creating the table 
            customerDAOImpl.createTable(url);

            // 3) Inserting customers
                            Customer c1 = new Customer();
                            c1.setName("Danilo R. Pereira");
                            c1.setAge(37);
                            c1.setCpf("111.111.111-11");
                            c1.setRg("222.222.222-22");

                            Customer customer2 = new Customer();
                            customer2.setName("Joao Oliveira Silva");
                            customer2.setAge(55);
                            customer2.setCpf("888.111.111-11");
                            customer2.setRg("777.222.222-22");

                            customerDAOImpl.insert(url, c1);
                            customerDAOImpl.insert(url, customer2);

                            // 4) Selecting all customers
                            customerDAOImpl.selectAll(url);

                            // 5) Updating a customer
                            customerDAOImpl.update(url, 1, "Danilo Rodrigues Pereira", 38);
                            customerDAOImpl.selectAll(url);

                            // 6) Deleting a customer
                            customerDAOImpl.delete(url, 2);
                            customerDAOImpl.selectAll(url);
    }

}