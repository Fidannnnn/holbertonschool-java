import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Connection connect(String connectionUrl) {
        if (connectionUrl == null || connectionUrl.isEmpty()) {
            System.err.println("Connection URL is null/empty");
            return null;
        }
        try {
            // Load SQLite driver if using SQLite URLs (harmless if not present)
            if (connectionUrl.startsWith("jdbc:sqlite:")) {
                try { Class.forName("org.sqlite.JDBC"); } catch (ClassNotFoundException ignore) {}
            }
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            System.err.println("Failed to obtain connection: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void createTable(String connectionUrl) {
        String sql =
            "CREATE TABLE IF NOT EXISTS customer (" +
            "  id   INTEGER PRIMARY KEY AUTOINCREMENT," +
            "  name TEXT," +
            "  age  INTEGER," +
            "  cpf  TEXT," +
            "  rg   TEXT" +
            ")";
        try (Connection c = connect(connectionUrl);
             Statement st = (c != null ? c.createStatement() : null)) {
            if (st == null) return;
            st.execute(sql);
        } catch (SQLException e) {
            System.err.println("createTable error: " + e.getMessage());
        }
    }

    @Override
    public void insert(String connectionUrl, Customer customer) {
        if (customer == null) return;

        // If id is provided, insert it; otherwise, let AUTOINCREMENT handle it
        boolean hasId = customer.getId() != null;

        String sqlWithId =
            "INSERT INTO customer (id, name, age, cpf, rg) VALUES (?, ?, ?, ?, ?)";
        String sqlAuto =
            "INSERT INTO customer (name, age, cpf, rg) VALUES (?, ?, ?, ?)";

        try (Connection c = connect(connectionUrl)) {
            if (c == null) return;

            if (hasId) {
                try (PreparedStatement ps = c.prepareStatement(sqlWithId)) {
                    ps.setInt(1, customer.getId());
                    ps.setString(2, customer.getName());
                    if (customer.getAge() == null) ps.setNull(3, java.sql.Types.INTEGER);
                    else ps.setInt(3, customer.getAge());
                    ps.setString(4, customer.getCpf());
                    ps.setString(5, customer.getRg());
                    ps.executeUpdate();
                }
            } else {
                try (PreparedStatement ps = c.prepareStatement(sqlAuto)) {
                    ps.setString(1, customer.getName());
                    if (customer.getAge() == null) ps.setNull(2, java.sql.Types.INTEGER);
                    else ps.setInt(2, customer.getAge());
                    ps.setString(3, customer.getCpf());
                    ps.setString(4, customer.getRg());
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("insert error: " + e.getMessage());
        }
    }

    @Override
    public void selectAll(String connectionUrl) {
        String sql = "SELECT id, name, age, cpf, rg FROM customer ORDER BY id";
        try (Connection c = connect(connectionUrl);
             Statement st = (c != null ? c.createStatement() : null)) {
            if (st == null) return;
            try (ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age"); if (rs.wasNull()) age = 0;
                    String cpf = rs.getString("cpf");
                    String rg = rs.getString("rg");
                    System.out.println(id + "|" + name + "|" + age + "|" + cpf + "|" + rg);
                }
            }
        } catch (SQLException e) {
            System.err.println("selectAll error: " + e.getMessage());
        }
    }

    @Override
    public void update(String connectionUrl, int id, String name, Integer age) {
        String sql = "UPDATE customer SET name = ?, age = ? WHERE id = ?";
        try (Connection c = connect(connectionUrl);
             PreparedStatement ps = (c != null ? c.prepareStatement(sql) : null)) {
            if (ps == null) return;
            ps.setString(1, name);
            if (age == null) ps.setNull(2, java.sql.Types.INTEGER);
            else ps.setInt(2, age);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("update error: " + e.getMessage());
        }
    }

    @Override
    public void delete(String connectionUrl, int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        try (Connection c = connect(connectionUrl);
             PreparedStatement ps = (c != null ? c.prepareStatement(sql) : null)) {
            if (ps == null) return;
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("delete error: " + e.getMessage());
        }
    }
}
