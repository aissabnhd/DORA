package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.repository.SpecialityRepository;
import fr.ajaate.dora.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public class SpecialityController {

    @Autowired
    private SpecialityRepository specialityRepository;

    @PostMapping
    public ResponseEntity<Speciality> save(@RequestBody Speciality speciality) {
        return new ResponseEntity<>(specialityRepository.save(speciality), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Speciality> update(@RequestBody Speciality speciality) {
        return new ResponseEntity<>(specialityRepository.save(speciality), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Speciality>> findAll() {
        return new ResponseEntity<List<Speciality>>(specialityRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        specialityRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
