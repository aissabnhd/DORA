package fr.ajaate.dora.controllers;


import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/Staff")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping
    public ResponseEntity<List<Staff>> findAll() {
        return new ResponseEntity<List<Staff>>(staffService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Staff> save(@RequestBody Staff s) {
        Staff newStaff = staffService.createStaff(s);
        return new ResponseEntity<>(newStaff, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Staff>(staffService.getOne(id).get(), HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Staff>> findByName(@PathVariable("lastName") String lastName){
        return new ResponseEntity<List<Staff>>(staffService.findByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Staff> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<Staff>(staffService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Optional<Staff>> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return new ResponseEntity<Optional<Staff>>(staffService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }








}
