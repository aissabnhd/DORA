package fr.ajaate.dora.model;

import java.util.Date;
import java.util.List;

public class Staff {
    private int idStaff;
    private String name;
    private String firstname;
    private Date birth;
    private String phone_number;
    private String phone_number_secondary;
    private String country;
    private String city;
    private String postal_code;
    private String street;
    private List<Integer> specialities;

    public Staff(int idStaff, String name, String firstname, Date birth, String phone_number, String phone_number_secondary, String country, String city, String postal_code, String street, List<Integer> specialities) {
        this.idStaff = idStaff;
        this.name = name;
        this.firstname = firstname;
        this.birth = birth;
        this.phone_number = phone_number;
        this.phone_number_secondary = phone_number_secondary;
        this.country = country;
        this.city = city;
        this.postal_code = postal_code;
        this.street = street;
        this.specialities = specialities;
    }

    public int getIdStaff() {
        return idStaff;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getBirth() {
        return birth;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPhone_number_secondary() {
        return phone_number_secondary;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getStreet() {
        return street;
    }

    public List<Integer> getSpecialities() {
        return specialities;
    }

    public void setIdStaff(int idStaff) {
        this.idStaff = idStaff;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPhone_number_secondary(String phone_number_secondary) {
        this.phone_number_secondary = phone_number_secondary;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSpecialities(List<Integer> specialities) {
        this.specialities = specialities;
    }
}
