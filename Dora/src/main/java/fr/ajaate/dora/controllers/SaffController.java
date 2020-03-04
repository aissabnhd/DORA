package fr.ajaate.dora.controllers;


import fr.ajaate.dora.entities.Staff;

import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/staff")
public class SaffController {

    @Autowired
    private StaffService staffService;





    @GetMapping("/ByEmail/{email}")
    public ResponseEntity<Optional<Staff>> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<Optional<Staff>>(staffService.findByEmail(email), HttpStatus.OK);
    }









}
