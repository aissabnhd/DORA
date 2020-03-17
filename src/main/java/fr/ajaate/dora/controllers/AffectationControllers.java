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
import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/affectation")
public class AffectationControllers {
    @Autowired
    private AffectationServices affectationServices;

    @Autowired
    private ActService actService;

    @Autowired
    private StaffService staffService;


    @PostMapping
    @PreAuthorize("hasAuthority('SECRETARY')")
    public ResponseEntity<Affectation> save(@RequestBody Affectation affectation) {
        Affectation savedAffectation = affectationServices.save(affectation);
        return new ResponseEntity<>(savedAffectation, HttpStatus.CREATED);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Affectation>> findAll() {
        return new ResponseEntity<List<Affectation>>(affectationServices.findAll(), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Affectation> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Affectation>(affectationServices.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/{id}/acts")
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Set<Act>> findAllActsByAffectationId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<Act>> (actService.findAllByAffectationId(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/{done}/acts")
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Act>> findAllActsByAffectationIdAndDone(@PathVariable("id") Long id, @PathVariable("done") boolean done){
        return new ResponseEntity<List<Act>> (actService.findAllByAffectationIdAndDone(id, done), HttpStatus.OK);
    }

    @GetMapping("/date/{dateAffectation}")
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Set<Affectation>> findAllByDateAffectation(@PathVariable("dateAffectation") Date dateAffectation){
        return new ResponseEntity<Set<Affectation>>(affectationServices.findAllByDateAffectation(dateAffectation), HttpStatus.OK);
    }

    @GetMapping("/current/{idDMP}")
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<Affectation> findCurrentAffectation(@PathVariable("idDMP") Long idDMP){
        return new ResponseEntity<Affectation>(affectationServices.findCurrentAffectation(idDMP).get(), HttpStatus.OK);
    }

    @PostMapping("/change_staff/{idAffectation}")
    @PreAuthorize("hasAuthority('SECRETARY')")
    public ResponseEntity<Affectation> save(@PathVariable("idAffectation") Long idAffectation, @RequestBody List<Long> idStaffs) {
        Affectation savedAffectation = affectationServices.findById(idAffectation).get();
        Set<Staff> set = savedAffectation.getListOfStaffs();
        for(int i = 0; i < idStaffs.size(); i++){
            set.add(staffService.findByID(idStaffs.get(i)));
        }
        savedAffectation.setListOfStaffs(set);
        affectationServices.save(savedAffectation);
        return new ResponseEntity<>(savedAffectation, HttpStatus.CREATED);
    }



/*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        affectationServices.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
*/


}
