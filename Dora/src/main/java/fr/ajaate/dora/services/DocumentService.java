package fr.ajaate.dora.services;


import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DocumentService {

    public Document save(Document document);

    public Document update(Document document);

    public List<Document> getAll();
    public List<Document> getAllByType(DocumentType documentType);
    public List<Document> getAllByNature(DocumentNature documentNature);


    Optional<Document> findById(Long id);

    void deleteById(Long id);

    public Document validateDocument(Document document, Long idValidator);

    Set<Document> findDocumentsAllByActsId(Long actId);

    public String setDocumentContent(String content, String path);

    public List<String> getDocumentContent (String path   );

    int getNextId(String path);

    Optional<Document> getRemarqueOf(Long idDMP);
}
