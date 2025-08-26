import java.util.ArrayList;
import java.util.HashMap;

public class PhoneList {
    private HashMap<String, ArrayList<Phone>> phoneMap;

    public PhoneList() {
        phoneMap = new HashMap<>();
    }

    public void addPhone(String name, Phone phone) {
        phoneMap.putIfAbsent(name, new ArrayList<>());
        phoneMap.get(name).add(phone);
    }

    public ArrayList<Phone> isFind(String name) {
        return phoneMap.getOrDefault(name, null);
    }
}
