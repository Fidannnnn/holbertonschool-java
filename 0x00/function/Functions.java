import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// --- Minimal placeholder for @PostMapping to avoid external deps ---
@Retention(RetentionPolicy.RUNTIME)
@interface PostMapping {
    String value();
}

public class Functions {

    // --- Dependencies (minimal placeholders) ---
    private final IncomeRepository inRepo = new IncomeRepository();
    private final ExpenseRepository outRepo = new ExpenseRepository();
    private final UserService userService = new UserService();
    private final EnvironmentService environmentService = new EnvironmentService();
    private final ReleaseService releaseService = new ReleaseService();
    private final VersionService versionService = new VersionService();

    // Do only 1 thing (Correct: B)
    public void saveIncome(Income income) {
        inRepo.save(income);
    }

    public void saveExpense(Expense expense) {
        outRepo.save(expense);
    }

    // Only 1 level of abstraction (Correct: A)
    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.save(user);
    }

    // Arguments (Correct: A) -> already satisfied by saveUser(User)
    // (No extra multi-arg overload)

    // No side effects (Correct: B)
    // Keep saveUser focused on saving; role changes live in a dedicated method.
    public void setRole(User user) {
        user.setRole(user);
    }

    // Avoid duplicates by extracting into new methods (Correct: B)
    public Environment getEnvironment() {
        return environmentService.getEnvironment(getVersion());
    }

    public Release getRelease() {
        return releaseService.getRelease(getVersion());
    }

    private String getVersion() {
        return versionService.getVersion();
    }

    // ----------------- Minimal placeholder types so this compiles -----------------
    public static class Income {}
    public static class Expense {}
    public static class User {
        boolean isAdmin;
        public void setRole(User u) { /* stub */ }
    }
    public static class Environment {}
    public static class Release {}

    public static class IncomeRepository { void save(Income i) { /* stub */ } }
    public static class ExpenseRepository { void save(Expense e) { /* stub */ } }

    public static class UserService {
        public User save(User u) { return u; }
    }

    public static class EnvironmentService {
        public Environment getEnvironment(String version) { return new Environment(); }
    }
    public static class ReleaseService {
        public Release getRelease(String version) { return new Release(); }
    }
    public static class VersionService {
        public String getVersion() { return "1.0.0"; }
    }
}
