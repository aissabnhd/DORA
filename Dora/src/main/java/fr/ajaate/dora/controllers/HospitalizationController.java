package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.services.AffectationServices;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/hospitalization")
public class HospitalizationController {
    @Autowired
    private HospitalizationServices hospitalizationServices;

    @Autowired
    private AffectationServices affectationServices;

    @PostMapping
    public ResponseEntity<Hospitalization> save(@RequestBody Hospitalization hospitalization) {
        return new ResponseEntity<>(hospitalizationServices.save(hospitalization), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hospitalization>> findAll() {
        return new ResponseEntity<List<Hospitalization>>(hospitalizationServices.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalization> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Hospitalization>(hospitalizationServices.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/date/{dateHospitalization}")
    public ResponseEntity<Set<Hospitalization>> findAllByDateHospitalization(@PathVariable("dateHospitalization") Instant dateHospitalization){
        return new ResponseEntity<Set<Hospitalization>>(hospitalizationServices.findAllByDateHospitalization(dateHospitalization), HttpStatus.OK);
    }

    @GetMapping("/{id}/affectations")
    public ResponseEntity<Set<Affectation>> findAllAffectationsByHospitalizationId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<Affectation>>(affectationServices.findAllByHospitalization(id), HttpStatus.OK);
    }

    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        hospitalizationServices.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    */


}
