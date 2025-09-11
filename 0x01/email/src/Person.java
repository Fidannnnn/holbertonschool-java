public class Person {
    public static boolean isEmailValid(String email) {
        if (email == null) return false;
        if (email.length() > 50) return false;
        if (!email.contains("@")) return false;
        return true;
    }
}
