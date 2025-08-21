public class Program {
        public static void main(String[] args) {
            Mobile mobile = new Mobile();

            Contact contact1 = new Contact("Jane Doe", "998211555", NumberType.MOBILE);
            Contact contact2 = new Contact("John Bannons", "32214332", NumberType.HOME);

            try {
                mobile.addContact(contact1);
                mobile.addContact(contact2);
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.updateContact(contact1, new Contact("Jane Doe", "998211556", NumberType.MOBILE));
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.updateContact(new Contact("John Bannons", "32214332", NumberType.HOME),
                    new Contact("John Bannons", "32214333", NumberType.HOME));
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.updateContact(new Contact("John Bannons", "32214332", NumberType.HOME),
                    new Contact("John Bannons", "32214333", NumberType.HOME));
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.updateContact(new Contact("John", "32214332", NumberType.HOME),
                    new Contact("John Bannons", "32214333", NumberType.HOME));
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.updateContact(contact2,
                    new Contact("Jane Doe", "32214333", NumberType.HOME));
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.removeContact(contact1);
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");

            try {
                mobile.removeContact(new Contact("Jane", "32214333", NumberType.HOME));
                mobile.listContacts();
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("-----");
        }
    }
