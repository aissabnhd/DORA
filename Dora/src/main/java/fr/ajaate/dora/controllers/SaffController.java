package fr.ajaate.dora.controllers;


import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.services.SecurityService;
import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/staff")
public class SaffController {

    @Autowired
    private StaffService staffService;




    @GetMapping("/{id}")
    public ResponseEntity<Staff> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Staff>(staffService.findByID(id), HttpStatus.OK);
    }

    @GetMapping("/ByUsername/{username}")
    public ResponseEntity<Staff> findByUsername(@PathVariable("username") String username){
        return new ResponseEntity<Staff>(staffService.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/ByEmail/{email}")
    public ResponseEntity<Staff> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<Staff>(staffService.findByEmail(email), HttpStatus.OK);
    }


    @PostMapping ("/update/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable("id") Long id, @RequestBody Staff staff){
        return new ResponseEntity<Staff>(staffService.updateStaff(id,staff), HttpStatus.OK);
    }






}