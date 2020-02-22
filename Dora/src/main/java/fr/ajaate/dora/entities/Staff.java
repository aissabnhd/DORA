package fr.ajaate.dora.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor

@Entity
@Table(name = "staff",uniqueConstraints = {

        @UniqueConstraint(columnNames = "email")
})
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



    @Column(name = "password")
    private String password;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne
    @JoinColumn(name = "struct_belong_id", referencedColumnName = "id")
    private Struct structBelong;

    @OneToOne(mappedBy = "responsible")
    private Struct structResponsible;

    @ManyToMany(cascade = CascadeType.MERGE  ,fetch = FetchType.EAGER)
    @JoinTable(
            name = "staff_speciality",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns =@JoinColumn(name = "speciality_id")
    )
    private Set<Speciality> specialities;

    public Staff(String firsName, String lastName, Instant birthday, String nationality, String phoneNumber, String rib, int postcode,Set<Role> roles,  String city, String street, String country, String linkCalendar, String email, String password) {
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
        this.password=password;
        this.roles=roles;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
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

    public String getLinkCalendar() {
        return linkCalendar;
    }

    public void setLinkCalendar(String linkCalendar) {
        this.linkCalendar = linkCalendar;
    }


    public Struct getStructBelong() {
        return structBelong;
    }

    public void setStructBelong(Struct structBelong) {
        this.structBelong = structBelong;
    }

    public Struct getStructResponsible() {
        return structResponsible;
    }

    public void setStructResponsible(Struct structResponsible) {
        this.structResponsible = structResponsible;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
