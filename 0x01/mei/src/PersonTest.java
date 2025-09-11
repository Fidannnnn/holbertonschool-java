import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.Calendar;

class PersonTest {

    private static Person person;

    @BeforeAll
    static void setupAll() {
        person = new Person();
        person.setName("Paul");
        person.setSurname("McCartney");
        person.setBirthDate(Person.ofYear(2000)); 
        person.setAnotherCompanyOwner(true); 
        person.setPensioner(true);          
        person.setPublicServer(true);   
        person.setSalary(0.0f);
    }

    @BeforeEach
    void reset() {
        person.setName("Paul");
        person.setSurname("McCartney");
        person.setBirthDate(Person.ofYear(2000));
        person.setAnotherCompanyOwner(true);
        person.setPensioner(true);
        person.setPublicServer(true);
        person.setSalary(0.0f);
    }

    @Test
    void show_full_name() {
        assertEquals("Paul McCartney", person.fullName());
    }

    @Test
    void test_calculateYearlySalary() {
        person.setSalary(1200.0f);
        assertEquals(14400.0f, person.calculateYearlySalary(), 0.0001f);
    }

    @Test
    void person_is_MEI() {
        person.setSalary(5000.0f); 
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        assertTrue(person.isMEI());
    }

    @Test
    void person_is_not_MEI() {
        person.setSalary(5000.0f); 
        person.setAnotherCompanyOwner(true); 
        person.setPensioner(false);
        person.setPublicServer(false);
        assertFalse(person.isMEI());
    }
}
