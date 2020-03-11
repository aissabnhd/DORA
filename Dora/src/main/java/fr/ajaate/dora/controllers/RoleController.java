package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Role;
import fr.ajaate.dora.repository.RoleRepository;
import fr.ajaate.dora.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody Role role) {
        return new ResponseEntity<>(roleRepository.save(role), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role role) {
        return new ResponseEntity<>(roleRepository.save(role), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return new ResponseEntity<List<Role>>(roleRepository.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        roleRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
