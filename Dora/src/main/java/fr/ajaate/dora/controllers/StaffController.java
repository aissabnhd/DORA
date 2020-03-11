package fr.ajaate.dora.controllers;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.service.StaffService;
import fr.ajaate.dora.service.impl.StaffServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public ResponseEntity<Staff> save(@RequestBody Staff staff) {
        return new ResponseEntity<>(staffService.createStaff(staff), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Staff> update(@RequestBody Staff staff) {
        return new ResponseEntity<>(staffService.update(staff), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Staff>> findAll() {
        return new ResponseEntity<List<Staff>>(staffService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> findById(@PathVariable("id") Long id){
        return new ResponseEntity<Staff>(staffService.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<Set<Staff>> findByLastName(@PathVariable("lastName") String lastName){
        return new ResponseEntity<Set<Staff>>(staffService.findAllByLastName(lastName), HttpStatus.OK);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<Set<Staff>> findByFirstName(@PathVariable("firstName") String firstName){
        return new ResponseEntity<Set<Staff>>(staffService.findAllByFirsName(firstName), HttpStatus.OK);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Optional<Staff>> findByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){
        return new ResponseEntity<Optional<Staff>>(staffService.findByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Optional<Staff>> findByEmail(@PathVariable("email") String email){
        return new ResponseEntity<Optional<Staff>>(staffService.findByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/struct/{id}")
    public ResponseEntity<Set<Staff>> findAllByStructBelongId(@PathVariable("id") Long id){
        return new ResponseEntity<Set<Staff>>(staffService.findAllByStructBelongId(id), HttpStatus.OK);
    }

    @PostMapping("/speciality")
    public ResponseEntity<Set<Staff>> findAllByStaffSpeciality(@RequestBody Speciality speciality){
        return new ResponseEntity<Set<Staff>>(staffService.findAllByStaffSpeciality(speciality), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
        staffService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
