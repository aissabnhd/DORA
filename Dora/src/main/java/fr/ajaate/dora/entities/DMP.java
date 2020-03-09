package fr.ajaate.dora.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;



@Entity
@Table (name = "DMP")
public class DMP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "social_security_number")
    private String socialSecurityNumber;
    @Column(name = "first_Name")
    private String firsName;
    @Column(name = "last_Name")
    private String lastName;
    @Column(name = "birthday")
    private Instant birthday;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "postcode")
    private int postcode;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "country")
    private String country;
    @Column(name = "allergy")
    private String allergy;

    public DMP() {
    }

    public DMP(String socialSecurityNumber, String firsName, String lastName, Instant birthday, String nationality, String phoneNumber, String email, int postcode, String city, String street, String country, String allergy) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.country = country;
        this.allergy = allergy;
    }

    public Long getId() {
        return id;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DMP dmp = (DMP) o;
        return postcode == dmp.postcode &&
                Objects.equals(id, dmp.id) &&
                Objects.equals(socialSecurityNumber, dmp.socialSecurityNumber) &&
                Objects.equals(firsName, dmp.firsName) &&
                Objects.equals(lastName, dmp.lastName) &&
                Objects.equals(birthday, dmp.birthday) &&
                Objects.equals(nationality, dmp.nationality) &&
                Objects.equals(phoneNumber, dmp.phoneNumber) &&
                Objects.equals(email, dmp.email) &&
                Objects.equals(city, dmp.city) &&
                Objects.equals(street, dmp.street) &&
                Objects.equals(country, dmp.country) &&
                Objects.equals(allergy, dmp.allergy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, socialSecurityNumber, firsName, lastName, birthday, nationality, phoneNumber, email, postcode, city, street, country, allergy);
    }

    @Override
    public String toString() {
        return "DMP{" +
                "id=" + id +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", nationality='" + nationality + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", postcode=" + postcode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", country='" + country + '\'' +
                ", allergy='" + allergy + '\'' +
                '}';
    }
}
