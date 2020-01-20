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
@Table(name = "hospitalizations")
public class Hospitalization {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_hospitalization")
    private Instant dateHospitalization;
    @Column(name = "date_end_hospitalization")
    private Instant dateEndHospitalization;
    @Column(name = "room_number")
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "dmp_id", nullable = false)
    private DMP dmp;

    @ManyToOne
    @JoinColumn(name = "struct_id", referencedColumnName = "id")
    private Struct struct;

    @OneToMany(mappedBy = "hospitalization")
    private Set<Affectation> affectations;


    public Hospitalization(Instant dateHospitalization, Instant dateEndHospitalization, int roomNumber) {
        this.dateHospitalization = dateHospitalization;
        this.dateEndHospitalization = dateEndHospitalization;
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospitalization that = (Hospitalization) o;
        return roomNumber == that.roomNumber &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber);
    }
}
