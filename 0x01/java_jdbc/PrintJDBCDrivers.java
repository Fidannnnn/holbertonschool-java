import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {

    // Try to proactively load common JDBC drivers so they register with DriverManager
    private static final String[] CANDIDATE_DRIVERS = new String[] {
        // SQLite
        "org.sqlite.JDBC",
        // MySQL / MariaDB
        "com.mysql.cj.jdbc.Driver",
        "org.mariadb.jdbc.Driver",
        // PostgreSQL
        "org.postgresql.Driver",
        // Oracle
        "oracle.jdbc.OracleDriver",
        // Microsoft SQL Server
        "com.microsoft.sqlserver.jdbc.SQLServerDriver",
        // IBM DB2
        "com.ibm.db2.jcc.DB2Driver",
        // H2 / Derby (often present for demos)
        "org.h2.Driver",
        "org.apache.derby.jdbc.EmbeddedDriver"
    };

    public static void main(String[] args) {
        // Best-effort: load any drivers present on the classpath
        for (String className : CANDIDATE_DRIVERS) {
            try {
                Class.forName(className);
            } catch (Throwable ignored) {
                // It's fine if a given driver isn't on the classpath
            }
        }

        // Enumerate registered drivers
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        if (!drivers.hasMoreElements()) {
            System.out.println("No JDBC drivers found on the classpath.");
            return;
        }

        int idx = 1;
        while (drivers.hasMoreElements()) {
            Driver d = drivers.nextElement();

            String className = d.getClass().getName();
            int major = d.getMajorVersion();
            int minor = d.getMinorVersion();

            // Try to get the library (artifact) version from the JAR manifest, if available
            String implVersion = null;
            Package p = d.getClass().getPackage();
            if (p != null) {
                implVersion = p.getImplementationVersion(); // may be null if not declared
            }

            System.out.println("Driver #" + idx++);
            System.out.println("  Name (class): " + className);
            System.out.println("  JDBC version: " + major + "." + minor);
            System.out.println("  Library version: " + (implVersion != null ? implVersion : "unknown"));
        }
    }
}
