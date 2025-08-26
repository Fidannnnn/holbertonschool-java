import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneList {
    private final Map<String, HashSet<Phone>> phonesByPerson = new HashMap<>();

    public HashSet<Phone> addPhone(String person, Phone phone) {
        HashSet<Phone> personSet = phonesByPerson.computeIfAbsent(person, k -> new HashSet<>());

        if (personSet.contains(phone)) {
            throw new RuntimeException("Phone already exists for this person");
        }

        for (Map.Entry<String, HashSet<Phone>> entry : phonesByPerson.entrySet()) {
            String otherPerson = entry.getKey();
            if (!otherPerson.equals(person)) {
                if (entry.getValue().contains(phone)) {
                    throw new RuntimeException("Phone already belongs to another person");
                }
            }
        }

        personSet.add(phone);
        return personSet;
    }
    public HashSet<Phone> isFind(String person) {
        HashSet<Phone> set = phonesByPerson.get(person);
        return (set == null || set.isEmpty()) ? null : set;
    }
}
