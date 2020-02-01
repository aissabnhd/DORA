package fr.ajaate.dora.service;


import fr.ajaate.dora.dao.DocumentRepository;

import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.enumeration.DocumentType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository  documentRepository;

    public Document createDocument(Document d){
        return documentRepository.save(d);
    }

    public Optional<Document> getOne(Long id) {
        return documentRepository.findById(id);
    }

    public Iterable<Document> getAll() {
        return documentRepository.findAll();
    }






}