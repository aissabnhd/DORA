package fr.ajaate.dora.controllers;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.services.ActService;
import fr.ajaate.dora.services.AffectationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/affectation")
public class AffectationControllers {
    @Autowired
    private AffectationServices affectationServices;

    @Autowired
    private ActService actService;


    @PostMapping
    public ResponseEntity<Affectation> save(@RequestBody Affectation affectation) {
        Affectation savedAffectation = affectationServices.save(affectation);
        return new ResponseEntity<>(savedAffectation, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Affectation>> findAll() {
        return new ResponseEntity<List<Affectation>>(affectationServices.findAll(), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Affectation> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Affectation>(affectationServices.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/{id}/acts")
    public ResponseEntity<Set<Act>> findAllActsByAffectationId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<Act>> (actService.findAllByAffectationId(id), HttpStatus.OK);
    }

    @GetMapping("/date/{dateAffectation}")
    public ResponseEntity<Set<Affectation>> findAllByDateAffectation(@PathVariable("dateAffectation") Instant dateAffectation){
        return new ResponseEntity<Set<Affectation>>(affectationServices.findAllByDateAffectation(dateAffectation), HttpStatus.OK);
    }


/*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        affectationServices.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
*/


}