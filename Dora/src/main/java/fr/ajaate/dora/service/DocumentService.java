package fr.ajaate.dora.service;


import fr.ajaate.dora.entities.Document;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DocumentService {

    public Document save(Document document);

    public Document update(Document document);

    public List<Document> getAll();

    Optional<Document> findById(Long id);

    void deleteById(Long id);

     public  boolean validateDocument(long idDocument, long idValidator, Instant dateValidation);

    public  boolean generatePDF(long idDocument);



}