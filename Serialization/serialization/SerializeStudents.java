import java.io.*;
import java.util.*;

public class SerializeStudents<T extends Serializable> {
    private final String fileName;

    public SerializeStudents(String fileName) {
        this.fileName = fileName;
    }

    // serialize: persist list to file, print on error
    public void serialize(List<T> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(students);
        } catch (Exception e) {
            System.out.println("Unable to serialize");
        }
    }

    // deserialize: read list from file, print on error and return empty list
    @SuppressWarnings("unchecked")
    public List<T> deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            return (List<T>) obj;
        } catch (Exception e) {
            System.out.println("Unable to deserialize");
            return new ArrayList<>();
        }
    }
}
