package fr.ajaate.dora.controllers;

import fr.ajaate.dora.dao.StructRepository;
import fr.ajaate.dora.entities.Affectation;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import fr.ajaate.dora.services.StaffService;
import fr.ajaate.dora.services.StructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/struct")
public class StructController {
    @Autowired
    private StructRepository structRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('SECRETARY') or hasAuthority('NURSE') or hasAuthority('DOCTOR') or hasAuthority('LABORATORY')")
    public ResponseEntity<List<Struct>> findAll() {
        return new ResponseEntity<List<Struct>>(structRepository.findAll(), HttpStatus.CREATED);
    }

}

