package fr.ajaate.dora.services.implementation;

import fr.ajaate.dora.dao.DocumentRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;
import fr.ajaate.dora.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DocumentImplementation implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    StaffRepository staffRepository;

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document update(Document document) {
        if(!document.getValidation())
            if(documentRepository.existsById(document.getId()))
                return documentRepository.save(document);
            else
                throw new IllegalStateException("Le document avec l'id " + document.getId() + " n'existe pas ");
            else
                throw new IllegalStateException("Le document avec l'id "+ document.getId() + " est déja validé");

    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> getAllByType(DocumentType documentType) {
        return documentRepository.findAllByType(documentType);
    }

    @Override
    public List<Document> getAllByNature(DocumentNature documentNature) {
        return documentRepository.findAllByNature(documentNature);
    }


    @Override
    public Optional<Document> findById(Long id) {
        return documentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
         documentRepository.deleteById(id);
    }

    @Override
    public Document validateDocument(Document document, Long idValidator) {
        if (documentRepository.existsById(document.getId()))
            if(!document.getValidation()){
                document.setValidation(true);
                document.setDateValidation(Instant.now());
                Optional<Staff> optionalStaff = staffRepository.findById(idValidator);
                if(!optionalStaff.isPresent())
                    throw new IllegalStateException("Le staff avec l'id "+ idValidator + " n'existe pas");
                document.setStaffValidator(optionalStaff.get());
                return document;
            }else
                throw new IllegalStateException("Le document avec l'id "+ document.getId() + " est déja validé");
        else
            throw new IllegalStateException("Le document avec l'id " + document.getId() + " n'existe pas");
    }

    @Override
    public Set<Document> findDocumentsAllByActsId(Long actId) {
        return documentRepository.findAllByActId(actId);
    }


}
