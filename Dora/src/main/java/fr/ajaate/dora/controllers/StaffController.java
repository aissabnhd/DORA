package fr.ajaate.dora.controllers;

import fr.ajaate.dora.dao.RoleRepository;
import fr.ajaate.dora.dao.StaffRepository;
import fr.ajaate.dora.entities.Act;
import fr.ajaate.dora.entities.Document;
import fr.ajaate.dora.entities.Role;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private RoleRepository roleRepository;


    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<Staff>> findByName(@PathVariable("lastName") String lastName){
        return new ResponseEntity<List<Staff>>(staffService.findByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Staff> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<Staff>(staffService.findByEmail(email).get(), HttpStatus.OK);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Staff> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return new ResponseEntity<Staff>(staffService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

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

    @PostMapping("/create")
    public ResponseEntity<Staff> create(@RequestBody Staff s) {
        return new ResponseEntity<Staff>(staffService.save(s), HttpStatus.CREATED);
    }

    @PostMapping("/setRole/{id}")
    public ResponseEntity<Staff> setRole(@RequestBody Role r, @PathVariable long id) {
        Set<Role> s = new HashSet<>();
        s.add(roleRepository.findByName(r.getName()).get());
        Staff staff = staffService.findByID(id);
        staff.setRoles(s);
        return new ResponseEntity<Staff>(staffService.save(staff), HttpStatus.CREATED);
    }
}
