package fr.ajaate.dora.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "hospitalizations")
public class Hospitalization {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_hospitalization")
    private Date dateHospitalization;
    @Column(name = "date_end_hospitalization")
    private Date dateEndHospitalization;
    @Column(name = "room_number")
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "dmp_id", nullable = false)
    private DMP dmp;

    @ManyToOne
    @JoinColumn(name = "struct_id", referencedColumnName = "id", nullable = false)
    private Struct struct;

    public Hospitalization() {
    }

    public Hospitalization(Date dateHospitalization, Date dateEndHospitalization, int roomNumber, DMP dmp, Struct struct) {
        this.dateHospitalization = dateHospitalization;
        this.dateEndHospitalization = dateEndHospitalization;
        this.roomNumber = roomNumber;
        this.dmp = dmp;
        this.struct = struct;
    }

    public Long getId() {
        return id;
    }

    public Date getDateHospitalization() {
        return dateHospitalization;
    }

    public void setDateHospitalization(Date dateHospitalization) {
        this.dateHospitalization = dateHospitalization;
    }

    public Date getDateEndHospitalization() {
        return dateEndHospitalization;
    }

    public void setDateEndHospitalization(Date dateEndHospitalization) {
        this.dateEndHospitalization = dateEndHospitalization;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public DMP getDmp() {
        return dmp;
    }

    public void setDmp(DMP dmp) {
        this.dmp = dmp;
    }

    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
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

    @Override
    public String toString() {
        return "Hospitalization{" +
                "id=" + id +
                ", dateHospitalization=" + dateHospitalization +
                ", dateEndHospitalization=" + dateEndHospitalization +
                ", roomNumber=" + roomNumber +
                ", dmp=" + dmp +
                ", struct=" + struct +
                '}';
    }
}
