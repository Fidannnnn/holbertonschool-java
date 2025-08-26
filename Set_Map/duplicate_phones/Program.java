import java.util.*;

public class Program {
    private static void printSorted(Set<Phone> phones) {
        if (phones == null) {
            System.out.println("Phones not found");
            return;
        }
        // Stable, deterministic order based on the displayed string
        TreeSet<Phone> sorted = new TreeSet<>(Comparator.comparing(Phone::toString));
        sorted.addAll(phones);
        System.out.println(sorted);
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone("11", "9888-5551");
        Phone phone2 = new Phone("17", "99602-6725");
        Phone phone3 = new Phone("21", "9882-1514");
        Phone phone4 = new Phone("13", "8771-2344");
        Phone phone5 = new Phone("17", "3221-1788");
        Phone phone6 = new Phone("17", "3444-1112");
        Phone phone7 = new Phone("17", "3311-1566");

        Phone duplicatePhone1 = new Phone("11", "9888-5551");
        Phone duplicatePhone2 = new Phone("17", "3444-1112");

        PhoneList phoneList1 = new PhoneList();
        phoneList1.addPhone("John Doe", phone1);
        phoneList1.addPhone("John Doe", phone2);
        phoneList1.addPhone("John Doe", phone7);
        phoneList1.addPhone("Tom Smith", phone3);
        phoneList1.addPhone("Tom Smith", phone5);
        phoneList1.addPhone("Carlos Alberto", phone4);
        phoneList1.addPhone("Carlos Alberto", phone6);

        try { phoneList1.addPhone("John Doe", duplicatePhone1); }
        catch (Exception ex) { System.out.println(ex.getMessage()); }

        try { phoneList1.addPhone("John Doe", duplicatePhone2); }
        catch (Exception ex) { System.out.println(ex.getMessage()); }

        printSorted(phoneList1.isFind("John Doe"));
        printSorted(phoneList1.isFind("Tom Smith"));
        printSorted(phoneList1.isFind("Carlos Alberto"));
        printSorted(phoneList1.isFind("Richard Bob"));
    }
}
