package fr.ajaate.dora.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "staff",uniqueConstraints = {

        @UniqueConstraint(columnNames = "email")
})
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthday")
    private Date birthday;
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

    @Column(name = "key")
    private String key;

    @Column(name = "expire")
    private long expire;

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

    @ManyToMany
    @JoinTable(
            name = "staff_speciality",
            joinColumns = @JoinColumn(name = "staff_id"),
            inverseJoinColumns =@JoinColumn(name = "speciality_id")
    )
    private Set<Speciality> specialities;

    public Staff(){

    }

    public Staff(String firstName, String lastName, Date birthday, String nationality, String phoneNumber, String rib, int postcode,Set<Role> roles,  String city, String street, String country, String linkCalendar, String email, String password) {
        this.firstName = firstName;
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

    public Staff(String lastName) {
        this.lastName = lastName;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return postcode == staff.postcode &&
                Objects.equals(id, staff.id) &&
                Objects.equals(firstName, staff.firstName) &&
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
        return Objects.hash(id, firstName, lastName, birthday, nationality, phoneNumber, email, rib, postcode, city, street, country);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
