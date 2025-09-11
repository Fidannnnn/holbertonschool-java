public class Person {
    public boolean checkUser(String username) {
        if (username == null) return false;
        if (username.length() < 8) return false;
        // Only letters and digits
        return username.matches("[A-Za-z0-9]+");
    }

    public boolean checkPassword(String password) {
        if (password == null) return false;
        if (password.length() < 8) return false;
        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^A-Za-z0-9].*");
        return hasUpper && hasDigit && hasSpecial;
    }
}
