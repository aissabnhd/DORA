package fr.ajaate.dora.entities;

import fr.ajaate.dora.enumeration.DocumentNature;
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
    @Column(name = "nature")
    private DocumentNature nature;

    @Column(name = "type")
    private DocumentType type;
    @Column(name = "extension")
    private String extension;
    @Column(name = "date_creation")
    private Instant dateCreation;
    @Column(name = "validation")
    private boolean validation;
    @Column(name = "date_validation")
    private Instant dateValidation;
    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "act_id", nullable = false)
    private Act act;


    @ManyToOne
    @JoinColumn(name = "staff_validator_id")
    private Staff staffValidator;

    @ManyToOne
    @JoinColumn(name = "staff_creator_id")
    private Staff staffCreator;

    public Document(DocumentNature nature,DocumentType type, String extension, Instant dateCreation, String path, Act act, Staff staffCreator) {
        this.nature=nature;
        this.type = type;
        this.extension = extension;
        this.dateCreation = dateCreation;

        this.path = path;
        this.act = act;
        this.staffCreator = staffCreator;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(type, document.type) &&
                Objects.equals(nature, document.nature) &&
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

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
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

    public DocumentNature getNature() {
        return nature;
    }

    public void setNature(DocumentNature nature) {
        this.nature = nature;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
}
