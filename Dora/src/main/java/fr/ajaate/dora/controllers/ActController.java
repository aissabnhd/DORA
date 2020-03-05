package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.services.ActService;
import fr.ajaate.dora.services.AffectationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/act")
public class ActController  {

    @Autowired
    private ActService actService;

    @PostMapping
    public ResponseEntity<Act> save(@RequestBody Act act) {
        return new ResponseEntity<>(actService.save(act), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Act>> findAll() {
        return new ResponseEntity<List<Act>>(actService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Act> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Act>(actService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/{id}/documents")
    public ResponseEntity<Set<Act>> findAllDocumentsByActId(@PathVariable("id") Long id){
        //TODO
        return null;
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<Set<Act>> findAllByDateAffectation(@PathVariable("date") Instant date){
        return new ResponseEntity<Set<Act>>(actService.findAllByDate(date), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        actService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}
