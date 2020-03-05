package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.DMP;
import fr.ajaate.dora.entities.Hospitalization;
import fr.ajaate.dora.services.DMPServices;
import fr.ajaate.dora.services.HospitalizationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/DMP")
public class DMPController {

    @Autowired
    private DMPServices dmpServices;

    @Autowired
    private HospitalizationServices hospitalizationServices;

    @PostMapping
    public ResponseEntity<DMP> save(@RequestBody DMP dmp) {
        DMP savedDMP = dmpServices.save(dmp);
        return new ResponseEntity<>(savedDMP, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DMP>> findAll() {
        return new ResponseEntity<List<DMP>>(dmpServices.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DMP> findById(@PathVariable("id") Long id){
        return new ResponseEntity<DMP>(dmpServices.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<DMP>> findByLastName(@PathVariable("lastName") String lastName){
        return new ResponseEntity<List<DMP>>(dmpServices.findByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<DMP>> findByFirstName(@PathVariable("firstName") String firstName){
        return new ResponseEntity<List<DMP>>(dmpServices.findByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/ssn/{ssn}")
    public ResponseEntity<Optional<DMP>> findBySocialSecurityNumber(@PathVariable("ssn") String ssn){
        return new ResponseEntity<Optional<DMP>>(dmpServices.findBySocialSecurityNumber(ssn), HttpStatus.OK);
    }

    @GetMapping("/struct/{id}")
    public ResponseEntity<Set<DMP>> findAllByStructId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<DMP>>(dmpServices.findAllByStructId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/hospitalizations")
    public ResponseEntity<Set<Hospitalization>> findAllHospitalizationsByDMPId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<Hospitalization>>(hospitalizationServices.findAllByDmpId(id), HttpStatus.OK);
    }

/*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        dmpServices.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
 */
}
