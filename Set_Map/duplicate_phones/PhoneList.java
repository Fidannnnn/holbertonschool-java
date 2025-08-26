import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneList {
    private HashMap<String, HashSet<Phone>> phoneMap;

    public PhoneList() {
        phoneMap = new HashMap<>();
    }

    public Set<Phone> addPhone(String name, Phone phone) {
        // check if another person already has this phone
        for (String person : phoneMap.keySet()) {
            if (!person.equals(name) && phoneMap.get(person).contains(phone)) {
                throw new IllegalArgumentException("Phone already belongs to another person");
            }
        }

        phoneMap.putIfAbsent(name, new HashSet<>());

        if (phoneMap.get(name).contains(phone)) {
            throw new IllegalArgumentException("Phone already exists for this person");
        }

        phoneMap.get(name).add(phone);
        return phoneMap.get(name);
    }

    public Set<Phone> isFind(String name) {
        return phoneMap.getOrDefault(name, null);
    }
}
