package fr.ajaate.dora.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;


@Data
@NoArgsConstructor
@ToString
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

    @OneToMany(mappedBy = "dmp")
    private Set<Hospitalization> hospitalizations;

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
}
