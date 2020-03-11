package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.enumeration.DocumentNature;
import fr.ajaate.dora.enumeration.DocumentType;
import fr.ajaate.dora.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/remarqueOf/{idDMP}")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Document> getRemarque(@PathVariable("idDMP") Long idDMP) {
        return new ResponseEntity<Document>(documentService.getRemarqueOf(idDMP).get(), HttpStatus.OK);
    }


    @RequestMapping(value = "/write/{id}", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> writeDocumentContent(@RequestBody String requestBodyString,@PathVariable("id") Long id ) throws Exception {
        Document document=documentService.findById(id).get();
        documentService.setDocumentContent(requestBodyString,document.getPath());
        return new ResponseEntity<String>(requestBodyString, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/reader/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> DocumentContentReader(@PathVariable("id") Long id) throws Exception {
        Document document=documentService.findById(id).get();

        List<String> lst = documentService.getDocumentContent(document.getPath());
        return new ResponseEntity<List<String>>(lst, HttpStatus.OK);
    }

    @PostMapping("/nextIdFile")
    public ResponseEntity<Integer> getNextId(@RequestBody String path){
        return new ResponseEntity<Integer>(documentService.getNextId(path), HttpStatus.OK);

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
