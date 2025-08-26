import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PhoneList {
    private final Map<String, HashSet<Phone>> phonesByPerson = new HashMap<>();

    public HashSet<Phone> addPhone(String person, Phone phone) {
        HashSet<Phone> personSet = phonesByPerson.computeIfAbsent(person, k -> new HashSet<>());

        if (personSet.contains(phone)) {
            throw new RuntimeException("Phone already exists for this person");
        }

        for (Map.Entry<String, HashSet<Phone>> e : phonesByPerson.entrySet()) {
            if (!e.getKey().equals(person) && e.getValue().contains(phone)) {
                throw new RuntimeException("Phone already belongs to another person");
            }
        }

        personSet.add(phone);
        return personSet;
    }

    public Set<Phone> isFind(String person) {
        HashSet<Phone> set = phonesByPerson.get(person);
        if (set == null || set.isEmpty()) return null;
        Map<String, Integer> freq = new HashMap<>();
        for (Phone p : set) {
            freq.put(p.getDdd(), freq.getOrDefault(p.getDdd(), 0) + 1);
        }
        String primaryDdd = null;
        int best = -1;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            String ddd = e.getKey();
            int count = e.getValue();
            if (count > best || (count == best && (primaryDdd == null || ddd.compareTo(primaryDdd) < 0))) {
                best = count;
                primaryDdd = ddd;
            }
        }

        LinkedHashSet<Phone> ordered = new LinkedHashSet<>();

        set.stream()
           .filter(p -> p.getDdd().equals(primaryDdd))
           .sorted((a, b) -> b.getNumber().compareTo(a.getNumber())) // number DESC
           .forEach(ordered::add);

        set.stream()
           .filter(p -> !p.getDdd().equals(primaryDdd))
           .sorted((a, b) -> {
               int byDdd = a.getDdd().compareTo(b.getDdd()); // DDD ASC
               if (byDdd != 0) return byDdd;
               return a.getNumber().compareTo(b.getNumber()); // number ASC
           })
           .forEach(ordered::add);

        return ordered;
    }
}
