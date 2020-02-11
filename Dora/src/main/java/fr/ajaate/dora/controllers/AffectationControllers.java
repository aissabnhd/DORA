package fr.ajaate.dora.controllers;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Hospitalization;
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


    @PostMapping
    public ResponseEntity<Affectation> save(@RequestBody Affectation affectation) {
        Affectation savedAffectation = affectationServices.save(affectation);
        return new ResponseEntity<>(savedAffectation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        affectationServices.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Affectation> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Affectation>(affectationServices.findById(id).get(), HttpStatus.OK);
    }

    /*
    @GetMapping("/date/{dateAffectation}")
    public ResponseEntity<Set<Affectation>> findById(@PathVariable("dateAffectation") Instant dateAffectation){
        return new ResponseEntity<Set<Affectation>>(affectationServices.findAllByDateAffectation(dateAffectation), HttpStatus.OK);
    }
    */


    @GetMapping("/affectations")
    public ResponseEntity<List<Affectation>> listeAffectation() {
        List<Affectation> affectations = affectationServices.findAll();
        return new ResponseEntity<List<Affectation>>(affectations, HttpStatus.OK);
    }


    @GetMapping("/{hospitalization_id}/affectations")
    public ResponseEntity<Set<Affectation>> findAllByHospitalizationId(@PathVariable("hospitalization_id") Hospitalization hospitalization_id){
        return new ResponseEntity<Set<Affectation>>(affectationServices.findAllByHospitalization(hospitalization_id), HttpStatus.OK);
    }

/*
    créer une affectation FAIT
    modifier une affecation
    supprimer une affectation FAIT
    récupérer une affectation par id FAIT
    récupérer toutes les affectations d'une hospitalisation FAIT
    récupérer les staffs d'une affectations
    récupérer les acts d'une affectation
    récupérer toutes les affectations FAIT
*/

}