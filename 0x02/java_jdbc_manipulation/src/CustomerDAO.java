import java.sql.Connection;

public interface CustomerDAO {

    public Connection connect(String connectionUrl);

    public void createTable(String connectionUrl);

    public void insert(String connectionUrl, Customer customer);

    public void selectAll(String connectionUrl);

    public void update(String connectionUrl, int id, String name, Integer age);

    public void delete(String connectionUrl, int id);
}
