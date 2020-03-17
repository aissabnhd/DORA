package fr.ajaate.dora.controllers;

import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping
    public ResponseEntity<List<Staff>> findAll() {
        return new ResponseEntity<List<Staff>>(staffRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> findById(@PathVariable Long id) {
        return new ResponseEntity<Staff>(staffRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Staff> save(@RequestBody Staff s) {
        return new ResponseEntity<Staff>(staffService.updateStaff(s.getId(), s), HttpStatus.CREATED);
    }
}
