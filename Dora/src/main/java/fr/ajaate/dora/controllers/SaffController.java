package fr.ajaate.dora.controllers;


import fr.ajaate.dora.entities.Staff;
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




}