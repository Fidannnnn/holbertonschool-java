import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConnectionSQLite {

    private static final String DB_NAME = "sqlite_database_2022.db";
    private static final String JDBC_URL = "jdbc:sqlite:" + DB_NAME;

    /**
     * Connects to (and creates if not exists) the SQLite database
     * named sqlite_database_2022.db in the current working directory.
     */
    public static Connection initConnection() throws ClassNotFoundException, SQLException {
        // Ensure the SQLite driver registers with DriverManager (good for older JDKs/tooling)
        Class.forName("org.sqlite.JDBC");
        // Will create the file if it doesn't exist
        return DriverManager.getConnection(JDBC_URL);
    }

    public static void main(String[] args) {
        try (Connection conn = initConnection()) {
            DatabaseMetaData meta = conn.getMetaData();
            Path dbPath = Paths.get(DB_NAME).toAbsolutePath();

            System.out.println("Connected successfully.");
            System.out.println("Driver: " + meta.getDriverName() + " " + meta.getDriverVersion());
            System.out.println("Database file: " + dbPath);
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found on classpath: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        }
    }
}
