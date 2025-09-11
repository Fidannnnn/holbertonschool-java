import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void test_email_with_at_symbol() {
        assertTrue(Person.isEmailValid("email_test@domain.com"));
    }

    @Test
    void test_email_without_at_symbol() {
        assertFalse(Person.isEmailValid("email_testdomain.com"));
    }

    @Test
    void test_email_over_50_characters() {
        // length > 50 → invalid
        String tooLong = "email_test_very_long_should_not_be_valid@domain.com";
        assertEquals(false, Person.isEmailValid(tooLong));
    }
}
