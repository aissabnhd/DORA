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
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "extension")
    private String extension;
    @Column(name = "date_creation")
    private Instant dateCreation;
    @Column(name = "validation")
    private Boolean validation;
    @Column(name = "date_validation")
    private Instant dateValidation;
    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "act_id", nullable = false)
    private Act act;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    public Document(Long id, String type, String extension, Instant dateCreation, Boolean validation, Instant dateValidation, String path) {
        this.id = id;
        this.type = type;
        this.extension = extension;
        this.dateCreation = dateCreation;
        this.validation = validation;
        this.dateValidation = dateValidation;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(type, document.type) &&
                Objects.equals(extension, document.extension) &&
                Objects.equals(dateCreation, document.dateCreation) &&
                Objects.equals(validation, document.validation) &&
                Objects.equals(dateValidation, document.dateValidation) &&
                Objects.equals(path, document.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, extension, dateCreation, validation, dateValidation, path);
    }
}
