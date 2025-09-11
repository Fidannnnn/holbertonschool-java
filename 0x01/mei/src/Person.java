import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Person {

    private String name;
    private String surname;
    private Date birthDate; 
    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;

    private float salary;

    public Person() {}

    public Person(String name, String surname, Date birthDate,
                  boolean anotherCompanyOwner, boolean pensioner, boolean publicServer,
                  float salary) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.anotherCompanyOwner = anotherCompanyOwner;
        this.pensioner = pensioner;
        this.publicServer = publicServer;
        this.salary = salary;
    }

    public String fullName() {
        String n = (name == null) ? "" : name;
        String s = (surname == null) ? "" : surname;
        if (n.isEmpty()) return s;
        if (s.isEmpty()) return n;
        return n + " " + s;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public float calculateYearlySalary() {
        return salary * 12.0f;
    }

    public boolean isMEI() {
        if (calculateYearlySalary() >= 130000.0f) return false;
        if (getAge() <= 18) return false;
        if (anotherCompanyOwner) return false;
        if (pensioner) return false;
        if (publicServer) return false;
        return true;
    }

    private int getAge() {
        if (birthDate == null) return 0;
        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        // Adjust if birthday hasn't occurred yet this year
        int currMonth = today.get(Calendar.MONTH);
        int birthMonth = birth.get(Calendar.MONTH);
        int currDay = today.get(Calendar.DAY_OF_MONTH);
        int birthDay = birth.get(Calendar.DAY_OF_MONTH);

        if (currMonth < birthMonth || (currMonth == birthMonth && currDay < birthDay)) {
            age--;
        }
        return age;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public boolean isAnotherCompanyOwner() { return anotherCompanyOwner; }
    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) { this.anotherCompanyOwner = anotherCompanyOwner; }

    public boolean isPensioner() { return pensioner; }
    public void setPensioner(boolean pensioner) { this.pensioner = pensioner; }

    public boolean isPublicServer() { return publicServer; }
    public void setPublicServer(boolean publicServer) { this.publicServer = publicServer; }

    public static Date ofYear(int year) {
        return new GregorianCalendar(year, Calendar.JANUARY, 1).getTime();
    }
}
