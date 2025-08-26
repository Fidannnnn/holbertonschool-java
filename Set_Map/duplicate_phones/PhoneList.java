import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PhoneList {
    private HashMap<String, HashSet<Phone>> phoneMap;

    public PhoneList() {
        phoneMap = new HashMap<>();
    }

    public Set<Phone> addPhone(String name, Phone phone) {
        for (var entry : phoneMap.entrySet()) {
            String person = entry.getKey();
            if (!person.equals(name) && entry.getValue().contains(phone)) {
                throw new IllegalArgumentException("Phone already belongs to another person");
            }
        }

        phoneMap.putIfAbsent(name, new HashSet<>());

        HashSet<Phone> set = phoneMap.get(name);
        if (set.contains(phone)) {
            throw new IllegalArgumentException("Phone already exists for this person");
        }

        set.add(phone);
        return set;
    }

    public Set<Phone> isFind(String name) {
        return phoneMap.getOrDefault(name, null);
    }
}
