
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    // One customer -> many phones
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones = new ArrayList<>();

    // One customer -> many addresses
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Customer() {}

    public Customer(Long id, String firstName, String lastName, String email) {
        this.id = id; this.firstName = firstName; this.lastName = lastName; this.email = email;
    }

    // Utility helpers ensure both sides of the relationship stay in sync
    public void addPhone(Phone p) {
        if (p == null) return;
        p.setCustomer(this);
        phones.add(p);
    }
    public void removePhone(Phone p) {
        if (p == null) return;
        p.setCustomer(null);
        phones.remove(p);
    }
    public void addAddress(Address a) {
        if (a == null) return;
        a.setCustomer(this);
        addresses.add(a);
    }
    public void removeAddress(Address a) {
        if (a == null) return;
        a.setCustomer(null);
        addresses.remove(a);
    }

    // Getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public List<Phone> getPhones() { return phones; }
    public void setPhones(List<Phone> phones) {
        this.phones.clear();
        if (phones != null) {
            phones.forEach(this::addPhone);
        }
    }
    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) {
        this.addresses.clear();
        if (addresses != null) {
            addresses.forEach(this::addAddress);
        }
    }
}
