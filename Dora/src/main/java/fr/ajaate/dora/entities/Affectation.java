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

    @OneToOne
    @JoinColumn(name = "struct_id", referencedColumnName = "id")
    private Struct struct;

    @ManyToMany
    private Set<Staff> listOfStaffs;

    public Affectation(Instant dateAffectation, Instant dateEndAffectation) {
        this.dateAffectation = dateAffectation;
        this.dateEndAffectation = dateEndAffectation;
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
