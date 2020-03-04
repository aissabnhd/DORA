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
@Table(name = "affectations")
public class Affectation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_affectation")
    private Instant dateAffectation;
    @Column(name = "date_end_affectation")
    private Instant dateEndAffectation;

    @ManyToOne
    @JoinColumn(name = "hospitalization_id", nullable = false)
    private Hospitalization hospitalization;

    @ManyToOne
    @JoinColumn(name = "struct_id", referencedColumnName = "id", nullable = false)
    private Struct struct;

    @ManyToMany
    @JoinTable(
            name = "affectation_staff",
            joinColumns = @JoinColumn(name = "affectation_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )

    private Set<Staff> listOfStaffs;

    public Affectation (){}

    public Affectation(Instant dateAffectation, Instant dateEndAffectation, Hospitalization hospitalization, Struct struct) {
        this.dateAffectation = dateAffectation;
        this.dateEndAffectation = dateEndAffectation;
        this.hospitalization = hospitalization;
        this.struct = struct;
    }

    public Long getId() {
        return id;
    }

    public Instant getDateAffectation() {
        return dateAffectation;
    }

    public Instant getDateEndAffectation() {
        return dateEndAffectation;
    }

    public Hospitalization getHospitalization() {
        return hospitalization;
    }

    public Struct getStruct() {
        return struct;
    }

    public Set<Staff> getListOfStaffs() {
        return listOfStaffs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateAffectation(Instant dateAffectation) {
        this.dateAffectation = dateAffectation;
    }

    public void setDateEndAffectation(Instant dateEndAffectation) {
        this.dateEndAffectation = dateEndAffectation;
    }

    public void setHospitalization(Hospitalization hospitalization) {
        this.hospitalization = hospitalization;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    public void setListOfStaffs(Set<Staff> listOfStaffs) {
        this.listOfStaffs = listOfStaffs;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affectation that = (Affectation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dateAffectation, that.dateAffectation) &&
                Objects.equals(dateEndAffectation, that.dateEndAffectation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateAffectation, dateEndAffectation);
    }

}
