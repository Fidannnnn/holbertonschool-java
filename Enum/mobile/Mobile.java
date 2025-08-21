import java.util.ArrayList;

public class Mobile {
    private ArrayList<Contact> contacts;

    public Mobile() {
        this.contacts = new ArrayList<>();
    }

    // Return index of contact by name; -1 if not found
    public int getContactPosition(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // Add new contact (unique by name)
    public void addContact(Contact contact) {
        if (getContactPosition(contact.getName()) != -1) {
            throw new IllegalArgumentException("Could not add contact. Contact with this name already exists");
        }
        contacts.add(contact);
    }

    // Update existing contact (by oldContact name); ensure new name doesn't collide
    public void updateContact(Contact oldContact, Contact newContact) {
        int oldPos = getContactPosition(oldContact.getName());
        if (oldPos == -1) {
            throw new IllegalArgumentException("Could not modify contact. Contact does not exist");
        }

        int newPos = getContactPosition(newContact.getName());
        if (newPos != -1 && newPos != oldPos) {
            throw new IllegalArgumentException("Could not modify contact. Contact with this name already exists");
        }

        // Replace the old with the new
        contacts.set(oldPos, newContact);
    }

    // Remove existing contact (by name)
    public void removeContact(Contact contact) {
        int pos = getContactPosition(contact.getName());
        if (pos == -1) {
            throw new IllegalArgumentException("Could not remove contact. Contact does not exist");
        }
        contacts.remove(pos);
    }

    // Print all contacts in the required format
    public void listContacts() {
        for (Contact c : contacts) {
            System.out.println(c.getName() + " -> " + c.getPhoneNumber() + " (" + c.getType() + ")");
        }
    }
}
