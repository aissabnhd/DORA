package fr.ajaate.dora.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;


@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "acts")
public class Act {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "date")
    private Instant date;

    @ManyToOne
    @JoinColumn(name="affectation_id")
    private Affectation affectation;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    public Act(String type, Instant date, Staff staff) {
        this.type = type;
        this.date = date;
        this.staff = staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Act act = (Act) o;
        return Objects.equals(id, act.id) &&
                Objects.equals(type, act.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }
}
