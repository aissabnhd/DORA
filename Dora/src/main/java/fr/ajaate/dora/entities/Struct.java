package fr.ajaate.dora.entities;

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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_struct")
    private String nameStruct;
    @Column(name = "level")
    private int level;
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

    @OneToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "id")
    private Staff responsible;

    public Struct(String nameStruct, int level, int postCode, String city, String street, String country) {
        this.nameStruct = nameStruct;
        this.level = level;
        this.postCode = postCode;
        this.city = city;
        this.street = street;
        this.country = country;
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

}
