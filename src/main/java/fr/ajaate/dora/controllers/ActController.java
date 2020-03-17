package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.services.ActService;
import fr.ajaate.dora.services.AffectationServices;
import fr.ajaate.dora.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/act")
public class ActController  {

    @Autowired
    private ActService actService;

    @Autowired
    private DocumentService documentService;

    @PostMapping
    @PreAuthorize("hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Act> save(@RequestBody Act act) {
        return new ResponseEntity<>(actService.save(act), HttpStatus.CREATED);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Act>> findAll() {
        return new ResponseEntity<List<Act>>(actService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Act> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Act>(actService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/{id}/documents")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Set<Document>> findAllDocumentsByActId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<Document>>(documentService.findDocumentsAllByActsId(id), HttpStatus.OK);
    }

    @GetMapping("/date/{date}")
    @PreAuthorize("hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Set<Act>> findAllByDateAffectation(@PathVariable("date") Instant date){
        return new ResponseEntity<Set<Act>>(actService.findAllByDate(date), HttpStatus.OK);
    }


/*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        actService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
*/


}
