package fr.ajaate.dora.service.implementation;

import com.sun.xml.fastinfoset.dom.DOMDocumentSerializer;

import fr.ajaate.dora.dao.DocumentRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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
        return null;
    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
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
    public boolean validateDocument(long idDocument, long idValidator, Instant dateValidation) {
        Optional<Document> document=documentRepository.findById(idDocument);
        if (document.isPresent()) {

            Document document1=document.get();
            document1.setValidation(Boolean.TRUE);
            document1.setDateValidation(dateValidation);
            document1.setStaffValidator(staffRepository.getOne(idValidator));
            return  true;
        }
        else return  false;

    }

    @Override
    public boolean generatePDF(long idDocument) {
        Optional<Document> document=documentRepository.findById(idDocument);
        if (document.isPresent()) {

            Document document1=document.get();

            return  true;
        }
        else return  false;
    }
}
