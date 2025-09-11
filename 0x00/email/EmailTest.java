class EmailTest {

    public static boolean test_email_with_at_symbol() {
        String email = "email_test@domain.com";
        boolean actual = Person.emailValid(email);
        boolean expected = true;
        return actual == expected;
    }

    public static boolean test_email_without_at_symbol() {
        String email = "email_testdomain.com";
        boolean actual = Person.emailValid(email);
        boolean expected = false;
        return actual == expected;
    }

    public static boolean test_email_over_50_characters() {
        String email = "email_test_very_long_should_not_be_valid@domain.com";
        boolean actual = Person.emailValid(email);
        boolean expected = false;
        return actual == expected;
    }
}