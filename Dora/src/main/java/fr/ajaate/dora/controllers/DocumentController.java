package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;
import fr.ajaate.dora.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Document> save(@RequestBody Document document) {
        return new ResponseEntity<Document>(documentService.save(document), HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<Document> update(@RequestBody Document document) {
        return new ResponseEntity<Document>(documentService.update(document), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Document>> findAll() {
        return new ResponseEntity<List<Document>>(documentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Document> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Document>(documentService.findById(id).get(), HttpStatus.OK);
    }




    @PostMapping("/validate/{id}")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<Document> validate(@RequestBody Document document, @RequestParam Long id){
        return new ResponseEntity<Document>(documentService.validateDocument(document, id), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Document>> getbyType(@PathVariable("type") String type) {
        return new ResponseEntity<List<Document>>(documentService.getAllByType(DocumentType.valueOf(type)), HttpStatus.OK);
    }

    @GetMapping("/nature/{nature}")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Document>> getbyNature(@PathVariable("nature") String nature) {
        return new ResponseEntity<List<Document>>(documentService.getAllByNature(DocumentNature.valueOf(nature)), HttpStatus.OK);
    }
/*

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        documentService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
 */
}
