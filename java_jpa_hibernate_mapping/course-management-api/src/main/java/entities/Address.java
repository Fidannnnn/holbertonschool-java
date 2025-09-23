package entities;

import javax.persistence.*;

@Embeddable
public class Address {
    @Column(length=120) private String street;
    @Column(length=10)  private String number;   // << added
    @Column(length=80)  private String city;
    @Column(length=20)  private String zipCode;

    public Address() {}

    // keep existing constructor (no number)
    public Address(String street, String city, String zipCode) {
        this.street = street; this.city = city; this.zipCode = zipCode;
    }

    // optional constructor with number
    public Address(String street, String city, String zipCode, String number) {
        this.street = street; this.city = city; this.zipCode = zipCode; this.number = number;
    }

    public String getStreet() { return street; }
    public void setStreet(String v) { this.street = v; }

    public String getNumber() { return number; }            // << added
    public void setNumber(String v) { this.number = v; }    // << added

    public String getCity() { return city; }
    public void setCity(String v) { this.city = v; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String v) { this.zipCode = v; }
}
