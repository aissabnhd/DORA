package fr.ajaate.dora.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.ajaate.dora.entities.enumeration.Level;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@ToString
@NoArgsConstructor
@Entity
@Table(name = "struct")
public class Struct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_struct")
    private String nameStruct;
    @Column(name = "level")
    private Level level;
    @Column(name = "postcode")
    private int postCode;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "country")
    private String country;

    @OneToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    private Speciality speciality;

    @OneToOne
    @JoinColumn(name = "struct_id", referencedColumnName = "id")
    private Struct struct;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff responsible;



    public Struct(String nameStruct, Level level, int postCode, String city, String street, String country) {
        this.nameStruct = nameStruct;
        this.level = level;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.country = country;
    }

    public Struct(String nameStruct, Level level, Struct parent) {
        this.nameStruct = nameStruct;
        this.level = level;
        this.struct = parent;
    }

    public Struct(String nameStruct, Level level, Struct parent, Staff responsible) {
        this.nameStruct = nameStruct;
        this.level = level;
        this.struct = parent;
        this.responsible = responsible;
    }

    public Struct(String nameStruct, Level level, int postCode, String city, String street, String country, Speciality spe, Staff responsible, Struct parent) {
        this.nameStruct = nameStruct;
        this.level = level;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.country = country;
        this.speciality = spe;
        this.struct = parent;
        this.responsible = responsible;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Struct struct = (Struct) o;
        return id == struct.id &&
                level == struct.level &&
                postCode == struct.postCode &&
                Objects.equals(nameStruct, struct.nameStruct) &&
                Objects.equals(city, struct.city) &&
                Objects.equals(street, struct.street) &&
                Objects.equals(country, struct.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameStruct, level, postCode, city, street, country);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameStruct() {
        return nameStruct;
    }

    public void setNameStruct(String nameStruct) {
        this.nameStruct = nameStruct;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    public Staff getResponsible() {
        return responsible;
    }

    public void setResponsible(Staff responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        if (this.struct == null) {
            if(this.responsible != null) {
                return "Name : " + nameStruct + " | Level : " + this.getLevel() + " | Responsible : " + this.responsible + " | Parent : Racine " + "\n";
            }
            return "Name : " + nameStruct + " | Level : " + this.getLevel() + " | Parent : racine\n";
        } else if (this.responsible == null) {
            return "Name : " + nameStruct + " | Level : " + this.getLevel() + " | Responsible : Aucun" + " | Parent : " + this.struct + "\n";
        } else {
            return "Name : " + nameStruct + " | Level : " + this.getLevel() + " | Responsible : " + this.responsible + " | Parent : " + this.struct + "\n";
        }
    }
}
