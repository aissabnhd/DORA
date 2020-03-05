package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> save(@RequestBody Document document) {
        return new ResponseEntity<Document>(documentService.save(document), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Document> update(@RequestBody Document document) {
        return new ResponseEntity<Document>(documentService.update(document), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Document>> findAll() {
        return new ResponseEntity<List<Document>>(documentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Document>(documentService.findById(id).get(), HttpStatus.OK);
    }


    @PostMapping("/validate/{id}")
    public ResponseEntity<Document> validate(@RequestBody Document document, @RequestParam Long id){
        return new ResponseEntity<Document>(documentService.validateDocument(document, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        documentService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
