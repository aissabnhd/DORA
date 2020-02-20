package fr.ajaate.dora.entities;

import fr.ajaate.dora.enumeration.DocumentType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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

    public Document(String type, String extension, Instant dateCreation, String path, Act act, Staff staffCreator) {

        this.type = type;
        this.extension = extension;
        this.dateCreation = dateCreation;

        this.path = path;
        this.act = act;
        this.staffCreator = staffCreator;
    }

    @ManyToOne
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "act_id", nullable = false)
    private Act act;


    @ManyToOne
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staffValidator;

    @ManyToOne
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staffCreator;

   /* public Document(Long id, DocumentType type, String extension, Instant dateCreation, Boolean validation, Instant dateValidation, String path) {
        this.id = id;
        this.type = type;
        this.extension = extension;
        this.dateCreation = dateCreation;
        this.validation = validation;
        this.dateValidation = dateValidation;
        this.path = path;
    }*/

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Instant getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Instant dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public Instant getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Instant dateValidation) {
        this.dateValidation = dateValidation;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Staff getStaffValidator() {
        return staffValidator;
    }

    public void setStaffValidator(Staff staffValidator) {
        this.staffValidator = staffValidator;
    }

    public Staff getStaffCreator() {
        return staffCreator;
    }

    public void setStaffCreator(Staff staffCreator) {
        this.staffCreator = staffCreator;
    }
}
