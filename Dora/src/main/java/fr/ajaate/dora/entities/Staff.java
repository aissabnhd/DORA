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
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firsName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthday")
    private Instant birthday;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "rib")
    private String rib;
    @Column(name = "postcode")
    private int postcode;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "country")
    private String country;
    @Column(name = "link_calendar")
    private String linkCalendar;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "struct_belong_id", referencedColumnName = "id")
    private Struct structBelong;

    @OneToOne(mappedBy = "responsible")
    private Struct structResponsible;

    @ManyToMany
    @JoinTable(
            name = "staff_speciality",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns =@JoinColumn(name = "speciality_id")
    )
    private Set<Speciality> specialities;

    public Staff(String firsName, String lastName, Instant birthday, String nationality, String phoneNumber, String email, String rib, int postcode, String city, String street, String country, String linkCalendar) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.nationality = nationality;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.rib = rib;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.country = country;
        this.linkCalendar = linkCalendar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return postcode == staff.postcode &&
                Objects.equals(id, staff.id) &&
                Objects.equals(firsName, staff.firsName) &&
                Objects.equals(lastName, staff.lastName) &&
                Objects.equals(birthday, staff.birthday) &&
                Objects.equals(nationality, staff.nationality) &&
                Objects.equals(phoneNumber, staff.phoneNumber) &&
                Objects.equals(email, staff.email) &&
                Objects.equals(rib, staff.rib) &&
                Objects.equals(city, staff.city) &&
                Objects.equals(street, staff.street) &&
                Objects.equals(country, staff.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firsName, lastName, birthday, nationality, phoneNumber, email, rib, postcode, city, street, country);
    }
}
