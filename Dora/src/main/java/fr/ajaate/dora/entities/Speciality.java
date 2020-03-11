package fr.ajaate.dora.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "speciality")
public class Speciality {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_role")
    private String nameRole;

    public  Speciality(){};

    public Speciality(String nameRole) {
        this.nameRole = nameRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Speciality that = (Speciality) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nameRole, that.nameRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRole);
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", nameRole='" + nameRole + '\'' +
                '}';
    }
}
