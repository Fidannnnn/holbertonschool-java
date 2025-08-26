import java.util.*;

public class Program {
    public static void main(String[] args) {
        Phone phone1 = new Phone("11", "9888-5551");
        Phone phone2 = new Phone("17", "99602-6725");
        Phone phone3 = new Phone("21", "9882-1514");
        Phone phone4 = new Phone("13", "8771-2344");
        Phone phone5 = new Phone("17", "3221-1788");
        Phone phone6 = new Phone("17", "3444-1112");
        Phone phone7 = new Phone("17", "3311-1566");

        PhoneList phoneList1 = new PhoneList();
        phoneList1.addPhone("John Doe", phone1);
        phoneList1.addPhone("John Doe", phone2);
        phoneList1.addPhone("John Doe", phone7);
        phoneList1.addPhone("Tom Smith", phone3);
        phoneList1.addPhone("Tom Smith", phone5);
        phoneList1.addPhone("Carlos Alberto", phone4);
        phoneList1.addPhone("Carlos Alberto", phone6);

        ArrayList<Phone> johnPhones = phoneList1.isFind("John Doe");
        if (johnPhones == null) System.out.println("Phones not found");
        else System.out.println(johnPhones);

        ArrayList<Phone> tomPhones = phoneList1.isFind("Tom Smith");
        if (tomPhones == null) System.out.println("Phones not found");
        else System.out.println(tomPhones);

        ArrayList<Phone> carlosPhones = phoneList1.isFind("Carlos Alberto");
        if (carlosPhones == null) System.out.println("Phones not found");
        else System.out.println(carlosPhones);

        ArrayList<Phone> richardPhones = phoneList1.isFind("Richard Bob");
        if (richardPhones == null) System.out.println("Phones not found");
        else System.out.println(richardPhones);
    }
}
