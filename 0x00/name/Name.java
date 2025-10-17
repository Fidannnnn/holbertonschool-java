import java.net.URL;
import java.util.Date;
import java.util.List;

public class Name {

    // Self-explanatory variables and method names
    public Date modifiedDate;
    public List<Testcase> findAllTestcasesByUser(Name.User user) {
        return null; // stub
    }

    // Prefer collections with clear field names (camelCase)
    public List<Account> accountList;

    // No prefixes in parameter names
    public void deleteUser(Name.User user) { }

    // Avoid mental mapping: name things by what they are
    public URL url;

    // Noun for class, verb for method
    public class TableRepresenter { }
    public void saveCar() { }

    // One word per concept (consistent verbs)
    public void saveUser() { }
    public void saveAccount() { }
    public void saveContract() { }

    // Use constants instead of magic numbers
    public static final int DAYS_IN_YEAR = 360;
    public static final int HOURS_IN_WEEK = 168;

    // --- Minimal placeholder types so this file compiles standalone ---
    public static class User { }
    public static class Account { }
    public static class Testcase { }
}
